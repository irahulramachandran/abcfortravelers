using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ABCForTravelers.Api.Model
{
    public class Business
    {
        public int ID { get; set; }
        public int UserId { get; set; }
        public int CategoryId { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public float Longitude { get; set; }
        public float Latitude { get; set; }
        public string Currency { get; set; }
        public decimal Price { get; set; }
        public string Phonenumber { get; set; }
        public string EmailID { get; set; }
        public string Address { get; set; }
        public int Status { get; set; }
        public DateTime CreatedOn { get; set; }
    }
}
