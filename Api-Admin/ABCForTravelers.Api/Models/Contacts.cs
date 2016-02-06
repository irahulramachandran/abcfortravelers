using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ABCForTravelers.Api.Model
{
    public class Contacts
    {
        public int ID { get; set; }
        public Business Business { get; set; }
        public string Phonenumber { get; set; }
        public string EmailID { get; set; }
        public string Address { get; set; }
        public int Status { get; set; }
    }
}
