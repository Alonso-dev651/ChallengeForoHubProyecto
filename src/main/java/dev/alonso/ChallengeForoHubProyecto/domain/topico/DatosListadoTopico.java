package dev.alonso.ChallengeForoHubProyecto.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String autor,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion
) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getAutor(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_de_creacion());
    }
}
