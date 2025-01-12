package dev.alonso.ChallengeForoHubProyecto.controller;

import dev.alonso.ChallengeForoHubProyecto.domain.topico.DatosRegistroTopico;
import dev.alonso.ChallengeForoHubProyecto.domain.topico.DatosRespuestaTopico;
import dev.alonso.ChallengeForoHubProyecto.domain.topico.Topico;
import dev.alonso.ChallengeForoHubProyecto.domain.topico.TopicoRepositorio;
import dev.alonso.ChallengeForoHubProyecto.domain.usuarios.UsuarioRepositorio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    TopicoRepositorio topicoRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        var usuario = usuarioRepositorio.findById(datosRegistroTopico.usuario_id()).get();
        Topico newTopico = topicoRepositorio.save(new Topico(datosRegistroTopico, usuario));

        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                newTopico.getId(), newTopico.getAutor(), newTopico.getTitulo(), newTopico.getMensaje(), newTopico.getFecha_de_creacion()
        );

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(newTopico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
}
