using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ABCForTravelers.Api.Model;
using ABCForTravelers.Biz;
using ABCForTravelers.EN;

namespace ABCForTravelers.Controllers
{
    public class LoginController : ApiController
    {
        UserBiz userBiz = new UserBiz();

        public LoginResponse Auth(LoginRequest loginRequest)
        {
            UserEN user = new UserEN();
            user.EmailID = loginRequest.UserName;
            user.Password = loginRequest.PassWord;
            user = userBiz.Login(user);
            LoginResponse response = new LoginResponse();
            if (user != null)
            {
                response.Status = true;
                response.UserID = user.ID;
            }
            else
            {
                response.Status = false;
                response.UserID = 0;
            }
            return response;
        }
    }
}
