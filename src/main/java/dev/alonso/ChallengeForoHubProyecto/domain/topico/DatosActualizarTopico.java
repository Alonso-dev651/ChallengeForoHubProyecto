package dev.alonso.ChallengeForoHubProyecto.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String autor,
        String titulo,
        String mensaje
) {
}
