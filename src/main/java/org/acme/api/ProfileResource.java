package org.acme.api;

import io.quarkus.security.identity.SecurityIdentity;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/profile")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    @Inject
    SecurityIdentity identity;

    @GET
    public Object profile() {
        return new Profile(
                identity.getPrincipal().getName(),
                identity.getRoles()
        );
    }

    public static class Profile {
        public String username;
        public Object roles;
        public Profile(String u, Object r) {
            this.username = u;
            this.roles = r;
        }
    }
}
