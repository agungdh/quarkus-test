package org.acme;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class HomeController {

    @Inject
    SecurityIdentity identity;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String home() {
        if (identity.isAnonymous()) {
            return "Selamat datang! Silakan login di /oauth2/authorization/company-realm";
        } else {
            return "Halo, " + identity.getPrincipal().getName();
        }
    }
}
