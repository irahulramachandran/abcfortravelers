using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ABCForTravelers.Api.Model
{
    public class Reviews
    {
        public int ID { get; set; }
        public User User { get; set; }
        public Business Business { get; set; }
        public decimal Rating { get; set; }
        public string Description { get; set; }
        public int Status { get; set; }
        public DateTime CreatedOn { get; set; }
    }
}
