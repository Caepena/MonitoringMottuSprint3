package br.com.fiap.MonitoringMottuSprint3.garagem;

import br.com.fiap.MonitoringMottuSprint3.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Garagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "garagem.responsavel.notblank")
    @Size(max = 50, message = "garagem.responsavel.size")
    private String responsavel;

    @NotBlank(message = "garagem.endereco.notblank")
    @Size(min = 10, message = "garagem.endereco.size")
    private String endereco;

    @ManyToOne
    private Usuario usuario;
}
