package no.soprasteria.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @GetMapping("/")
    public ResponseEntity<Object> index(Authentication user) {
        return ResponseEntity.ok(user.getPrincipal());
    }

    @GetMapping("/token")
    public ResponseEntity<Object> token(@AuthenticationPrincipal OidcUser oidcUser) {
        return ResponseEntity.ok(oidcUser.getIdToken() );
    }

    @GetMapping("/username")
    public ResponseEntity<Object> username(@AuthenticationPrincipal OidcUser oidcUser) {
        return ResponseEntity.ok(oidcUser.getUserInfo().getGivenName());
    }
}
