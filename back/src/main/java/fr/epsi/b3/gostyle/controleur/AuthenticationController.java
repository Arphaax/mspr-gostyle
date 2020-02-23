package fr.epsi.b3.gostyle.controleur;

import fr.epsi.b3.gostyle.model.User;
import fr.epsi.b3.gostyle.security.JwtRequest;
import fr.epsi.b3.gostyle.security.JwtTokenUtil;
import fr.epsi.b3.gostyle.service.UserService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/authenticate", produces = "application/hal+json", consumes = "application/json")
public class AuthenticationController {
    @Autowired
    UserService userService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping(value = "/")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        //authenticate(authenticationRequest.getNumero(), authenticationRequest.getPassword());
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getNumero());
        HttpHeaders responseHeaders = jwtTokenUtil.getTokenAsHeader(userDetails);
        User user = userService.getByLogin(authenticationRequest.getNumero());
        return ResponseEntity.ok().headers(responseHeaders).body(user);
    }

    private Authentication authenticate(String username, String password) throws Exception {

        try {

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException e) {

            throw new Exception("USER_DISABLED", e);

        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
