using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ABCForTravelers.Api.Model
{
    public class Photos
    {
        public int ID { get; set; }
        public int UserId { get; set; }
        public int BusinessId { get; set; }
        public string Photourl { get; set; }
        public int Status { get; set; }
        public DateTime CreatedOn { get; set; }
    }
}
