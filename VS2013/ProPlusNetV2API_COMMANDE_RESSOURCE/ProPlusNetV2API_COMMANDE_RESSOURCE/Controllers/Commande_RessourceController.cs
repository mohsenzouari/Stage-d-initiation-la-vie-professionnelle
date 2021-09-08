using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web;
using Commande_RessourceDataAccess;

namespace ProPlusNetV2API_COMMANDE_RESSOURCE.Controllers
{
    public class Commande_RessourceController : ApiController
    {
        public IEnumerable<COMMANDE_RESSOURCE> Get()
        {
            using (ProPlusNetV2Entities entities = new ProPlusNetV2Entities())
            {

                return (entities.COMMANDE_RESSOURCE.ToList());


            }

        }

        public IEnumerable<COMMANDE_RESSOURCE> Get(int id)
        {
            using (ProPlusNetV2Entities entities = new ProPlusNetV2Entities())
            {
                var query = from c in entities.COMMANDE_RESSOURCE
                            where (c.IdObjet == id)
                            select c;

                var result = query.ToList();


                return result;
            }

        }
    }
}
