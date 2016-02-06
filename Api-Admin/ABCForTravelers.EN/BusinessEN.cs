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
        public float Longitude { get; set; }
        public float Latitude { get; set; }
        public string Currency { get; set; }
        public decimal Price { get; set; }
        public int Status { get; set; }
        public DateTime CreatedOn { get; set; }
    }
}
