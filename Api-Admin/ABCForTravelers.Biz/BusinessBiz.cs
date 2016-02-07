using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using ABCForTravelers.DAL;
using ABCForTravelers.EN;

namespace ABCForTravelers.Biz
{
    public class BusinessBiz
    {
        BusinessDAL businessDal = new BusinessDAL();

        public BusinessEN Add(BusinessEN business, ContactsEN contact)
        {
            business = businessDal.Save(business);
            bool isSaved = businessDal.SaveContact(business, contact);
            return business;
        }

        public bool UpdatePhoto(int id, string fileName)
        {
            return businessDal.UpdatePhoto(id, fileName);
        }

        public string GetPhoto(int id)
        {
            return businessDal.GetPhoto(id);
        }

        public List<BusinessEN> GetByGeo(float latitude, float longitude)
        {
            return businessDal.GetByGeo(latitude, longitude);
        }
    }
}
