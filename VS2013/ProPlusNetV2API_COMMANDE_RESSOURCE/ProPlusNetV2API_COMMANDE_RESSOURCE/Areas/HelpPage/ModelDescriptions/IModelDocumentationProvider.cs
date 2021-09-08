using System;
using System.Reflection;

namespace ProPlusNetV2API_COMMANDE_RESSOURCE.Areas.HelpPage.ModelDescriptions
{
    public interface IModelDocumentationProvider
    {
        string GetDocumentation(MemberInfo member);

        string GetDocumentation(Type type);
    }
}