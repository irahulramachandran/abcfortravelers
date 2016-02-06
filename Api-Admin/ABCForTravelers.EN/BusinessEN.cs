using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ABCForTravelers.EN
{
    public class BusinessEN
    {
        public int ID { get; set; }
        public UserEN User { get; set; }
        public CategoryEN Category { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public string Bannerimageurl { get; set; }
        public float Logitude { get; set; }
        public float Latitude { get; set; }
        public int Status { get; set; }
        public DateTime CreatedOn { get; set; }
    }
}
