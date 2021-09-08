using System.Web;
using System.Web.Mvc;

namespace ProPlusNetV2API_COMMANDE
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
