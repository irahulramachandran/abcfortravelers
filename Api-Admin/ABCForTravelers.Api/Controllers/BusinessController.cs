using System;
using System.Collections.Generic;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;
using System.Web.Http;
using ABCForTravelers.Api.Model;
using ABCForTravelers.Biz;
using ABCForTravelers.EN;

namespace ABCForTravelers.Controllers
{
    public class BusinessController : ApiController
    {
        // POST
        [HttpPost]
        public Business Add(Business business)
        {
            BusinessEN businessEN = new BusinessEN();
            businessEN.Name = business.Name;
            businessEN.Category = new CategoryEN();
            businessEN.Category.ID = business.CategoryId;
            businessEN.User = new UserEN();
            businessEN.User.ID = business.UserId;
            businessEN.Description = business.Description;
            businessEN.Latitude = business.Latitude;
            businessEN.Longitude = business.Longitude;
            businessEN.Currency = business.Currency;
            businessEN.Price = business.Price;

            ContactsEN contactsEN = new ContactsEN();
            contactsEN.Business = businessEN;
            contactsEN.Phonenumber = business.Phonenumber;
            contactsEN.EmailID = business.EmailID;
            contactsEN.Address = business.Address;

            BusinessBiz biz = new BusinessBiz();
            businessEN = biz.Add(businessEN, contactsEN);
            business.ID = businessEN.ID;
            return business;
        }

        [HttpPost]
        public List<BusinessEN> Search(Business business)
        {
            BusinessBiz biz = new BusinessBiz();
            return biz.GetByGeo(business.Latitude, business.Longitude);
        }
        
        [HttpPost]
        public string UploadPhoto(int id)
        {
            try
            {
                var httpRequest = HttpContext.Current.Request;
                if (httpRequest.Files.Count == 1)
                {
                    var postedFile = httpRequest.Files[0];
                    string date = DateTime.Now.ToString("ddMMyyyyHHmmss");
                    string fileName = id+".png";
                    string filePath = HttpContext.Current.Server.MapPath("~/" + fileName);
                    postedFile.SaveAs(filePath);
                    return "/" + fileName;
                }
                return null;
            }
            catch (Exception e1)
            {
                throw;
            }
        }

        [HttpGet]
        public HttpResponseMessage Photo(int id)
        {
            try
            {
                var file = HttpContext.Current.Server.MapPath("~/" + id+".png");
                using (Image img = new Bitmap(file))
                {
                    using (MemoryStream stream = new MemoryStream())
                    {
                        img.Save(stream, ImageFormat.Png);
                        HttpResponseMessage result = new HttpResponseMessage(HttpStatusCode.OK);
                        result.Content = new ByteArrayContent(stream.ToArray());
                        result.Content.Headers.ContentType = new MediaTypeHeaderValue("image/png");
                        return result;
                    }
                }
            }
            catch (System.Exception ex)
            {
                throw;
            }
        }
    }
}
