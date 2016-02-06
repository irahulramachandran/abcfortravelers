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
    public class UserController : ApiController
    {
        UserBiz userBiz = new UserBiz();

        public UserEN Register(UserEN registerUser)
        {
            UserEN response = userBiz.Register(registerUser);
            return response;
        }
    }
}
