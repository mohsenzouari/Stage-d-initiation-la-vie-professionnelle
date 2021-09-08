using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ProPlusNetV2WebServiceDataAccess;

namespace ProPlusNetV2WebService.Controllers
{
    public class COMMANDE_RESSOURCEController : ApiController
    {
        public IEnumerable<COMMANDE_RESSOURCE> GET()
        {
            using (ProPlusNetV2Entities entities = new ProPlusNetV2Entities())
            {
                return entities.COMMANDE_RESSOURCE.ToList();
            }
        }
    }
}
