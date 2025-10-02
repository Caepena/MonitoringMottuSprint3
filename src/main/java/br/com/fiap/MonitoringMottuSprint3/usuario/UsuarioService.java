package br.com.fiap.MonitoringMottuSprint3.usuario;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario register(OAuth2User principal) {
        var login = Optional.ofNullable(principal.getAttributes().get("login"))
                .map(Object::toString)
                .orElseThrow(() -> new IllegalArgumentException("Login não efetuado."));

        var usuario = usuarioRepository.findByEmail(login + "@github.com");
        return usuario.orElseGet(() -> usuarioRepository.save(new Usuario(principal, login + "@github.com")));
    }
}
