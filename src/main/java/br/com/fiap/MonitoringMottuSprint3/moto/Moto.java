package br.com.fiap.MonitoringMottuSprint3.moto;

import br.com.fiap.MonitoringMottuSprint3.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{moto.modelo.notblank}")
    private String modelo;

    @NotBlank(message = "{moto.placa.notblank}")
    @Size(min = 7, max = 7, message = "{moto.placa.size}")
    @Pattern(regexp = "^[A-Z0-9]{7}$", message = "{moto.placa.pattern}")
    private String placa;

    @NotNull(message = "{moto.statusmoto.notnull}")
    @Enumerated(EnumType.STRING)
    private StatusMoto statusMoto;

    @ManyToOne
    private Usuario usuario;
}
