package pro.acutus.keycloak.freemarkerplus;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.specimpl.ResteasyUriInfo;
import org.keycloak.forms.login.freemarker.FreeMarkerLoginFormsProvider;
import org.keycloak.forms.login.LoginFormsPages;
import org.keycloak.models.KeycloakSession;
import org.keycloak.theme.Theme;

public class FreeMarkerPlusLoginFormsProvider extends FreeMarkerLoginFormsProvider {

    private static final Logger LOG = Logger.getLogger(FreeMarkerPlusLoginFormsProvider.class.getName());

    public FreeMarkerPlusLoginFormsProvider(KeycloakSession session) {
        super(session);
    }

    @Override
    protected void createCommonAttributes(Theme theme, Locale locale, Properties messagesBundle, UriBuilder baseUriBuilder, LoginFormsPages page) {
        super.createCommonAttributes(theme, locale, messagesBundle, baseUriBuilder, page);
        attributes.put("uri", uriInfo);
        try {
            URI redirectUri = new URI(uriInfo.getQueryParameters().getFirst("redirect_uri"));
            attributes.put("redirectUri", new ResteasyUriInfo(redirectUri));
        } catch (URISyntaxException ex) {
            LOG.log(Level.SEVERE, "redirect_uri missing or invalid", ex);
        }
    }

}
