package pro.acutus.keycloak.freemarkerplus;

import org.keycloak.forms.login.LoginFormsProvider;
import org.keycloak.forms.login.freemarker.FreeMarkerLoginFormsProviderFactory;
import org.keycloak.models.KeycloakSession;

public class FreeMarkerPlusLoginFormsProviderFactory extends FreeMarkerLoginFormsProviderFactory {

    @Override
    public LoginFormsProvider create(KeycloakSession session) {
        return new FreeMarkerPlusLoginFormsProvider(session);
    }

    @Override
    public String getId() {
        return "freemarker+";
    }

}
