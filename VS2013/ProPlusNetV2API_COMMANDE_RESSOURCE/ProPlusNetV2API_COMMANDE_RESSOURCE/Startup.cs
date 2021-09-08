using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Owin;
using Owin;

[assembly: OwinStartup(typeof(ProPlusNetV2API_COMMANDE_RESSOURCE.Startup))]

namespace ProPlusNetV2API_COMMANDE_RESSOURCE
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
