package dev.alonso.ChallengeForoHubProyecto.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull Long usuario_id,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String curso,
        @NotBlank String autor
) {
}
