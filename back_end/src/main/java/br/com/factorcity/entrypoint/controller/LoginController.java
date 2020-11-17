package br.com.factorcity.entrypoint.controller;

import br.com.factorcity.core.service.TokenService;
import br.com.factorcity.entrypoint.mapper.LoginMapper;
import br.com.factorcity.entrypoint.model.request.LoginRequest;
import br.com.factorcity.entrypoint.model.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private AuthenticationManager autenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginRequest loginRequest){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = LoginMapper.requestToUsernamePasswordAuthenticationToken(loginRequest);
        Authentication authentication = autenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = tokenService.gerarToken(authentication);

        return ResponseEntity.ok(new TokenResponse(token, "Bearer", authentication.getAuthorities()));
    }
}
