using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ABCForTravelers.EN
{
    public class UserEN
    {
        public int ID { get; set; }
        public string Name { get; set; }
        public string EmailID { get; set; }
        public string Phonenumber { get; set; }
        public string Password { get; set; }
        public string Photourl { get; set; }
        public int Usertype { get; set; }
        public int Status { get; set; }
        public DateTime CreatedOn { get; set; }
    }
}
