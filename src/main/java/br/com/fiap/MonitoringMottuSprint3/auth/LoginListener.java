package br.com.fiap.MonitoringMottuSprint3.auth;

import br.com.fiap.MonitoringMottuSprint3.usuario.UsuarioService;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class LoginListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private final UsuarioService usuarioService;

    public LoginListener(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        var principal = (OAuth2User) event.getAuthentication().getPrincipal();
        usuarioService.register(principal);
    }
}
