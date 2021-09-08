using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web;
using Commande_DataAccess;

namespace ProPlusNetV2API_COMMANDE.Controllers
{
    public class CommandeController : ApiController
    {
        public IEnumerable<COMMANDE> Get()
        {
            using (ProPlusNetV2Entities entities = new ProPlusNetV2Entities())
            {

                return (entities.COMMANDE.ToList());


            }

        }

        public IEnumerable<COMMANDE> Get(int id)
        {
            using (ProPlusNetV2Entities entities = new ProPlusNetV2Entities())
            {
                var query = from c in entities.COMMANDE
                            where (c.IdTiers == id)
                            select c;

                var result = query.ToList();


                return result;
            }

        }

    }
}
