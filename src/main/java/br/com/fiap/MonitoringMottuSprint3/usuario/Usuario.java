package br.com.fiap.MonitoringMottuSprint3.usuario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Entity
@Data
@Table(name = "usuario")
@NoArgsConstructor
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    public Usuario(OAuth2User principal, String email) {
        this.name = principal.getAttributes().get("name").toString();
        this.email = email;
    }
}
