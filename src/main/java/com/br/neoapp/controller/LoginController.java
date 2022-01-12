package com.br.neoapp.controller;

import com.br.neoapp.config.security.service.TokenService;
import com.br.neoapp.config.security.service.dto.TokenDto;
import com.br.neoapp.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
@Profile("prod")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> auth(@RequestBody @Valid LoginForm loginForm){
        UsernamePasswordAuthenticationToken dadosLogin = new UsernamePasswordAuthenticationToken(loginForm.getLogin(), loginForm.getPassword());

        try{
            Authentication authenticate = authenticationManager.authenticate(dadosLogin);

            return ResponseEntity.ok(new TokenDto("Bearer", tokenService.gerarToken(authenticate)));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
