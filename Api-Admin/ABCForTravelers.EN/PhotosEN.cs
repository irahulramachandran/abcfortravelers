using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ABCForTravelers.EN
{
    public class PhotosEN
    {
        public int ID { get; set; }
        public UserEN User { get; set; }
        public BusinessEN Business { get; set; }
        public string Photourl { get; set; }
        public int Status { get; set; }
        public DateTime CreatedOn { get; set; }
    }
}
