using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web;
using Tiers_DataAccess;

namespace ProPlusNetV2API_TIERS.Controllers
{
    public class TiersController : ApiController
    {
        public IEnumerable<TIERS> Get()
        {
            using (ProPlusNetV2Entities entities = new ProPlusNetV2Entities())
            {

                return (entities.TIERS.ToList());


            }

        }

        public IEnumerable<TIERS> Get(int id)
        {
            using (ProPlusNetV2Entities entities = new ProPlusNetV2Entities())
            {
                var query = from c in entities.TIERS
                            where (c.IdTiers == id)
                            select c;

                var result = query.ToList();


                return result;
            }

        }
    }
}
