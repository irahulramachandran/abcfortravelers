using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ABCForTravelers.Api.Model
{
    public class LoginRequest
    {
        public string UserName { get; set; }
        public string PassWord { get; set; }
    }
}
