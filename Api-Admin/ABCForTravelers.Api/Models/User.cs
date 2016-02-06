using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;

namespace ABCForTravelers.Api.Model
{
    public class User
    {
        public int ID { get; set; }
        public string Name { get; set; }
        public string EmailID { get; set; }
        public string Phonenumber { get; set; }
        [IgnoreDataMember]
        public string Password { get; set; }
        public string Photourl { get; set; }
        public int Usertype { get; set; }
        public int Status { get; set; }
        public DateTime CreatedOn { get; set; }
    }
}
