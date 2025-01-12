package dev.alonso.ChallengeForoHubProyecto.controller;

import dev.alonso.ChallengeForoHubProyecto.domain.topico.*;
import dev.alonso.ChallengeForoHubProyecto.domain.usuarios.UsuarioRepositorio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> topicoList(@PageableDefault(size = 2)
                                                               Pageable pageable) {
        return ResponseEntity.ok(topicoRepositorio.findByStatusTrue(pageable).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> obtenerDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepositorio.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getAutor(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_de_creacion()
        );
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        if (topicoRepositorio.existsById(datosActualizarTopico.id())) {
            Topico topico = topicoRepositorio.getReferenceById(datosActualizarTopico.id());
            topico.actualizarDatos(datosActualizarTopico);
            return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getAutor(), topico.getTitulo(),
                    topico.getMensaje(), topico.getFecha_de_creacion()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopicoPorId(@RequestBody @Valid DatosActulizarTopicoEspecifico datosActulizarTopicoEspecifico, @PathVariable Long id) {
        if (topicoRepositorio.existsById(id)) {
            Topico topico = topicoRepositorio.getReferenceById(id);
            topico.actualizarDatosTopicoEspecifico(datosActulizarTopicoEspecifico);
            return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getAutor(), topico.getTitulo(),
                    topico.getMensaje(), topico.getFecha_de_creacion()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosDeteleLogico> eliminarTopico(@PathVariable Long id) {
        if (topicoRepositorio.existsById(id)) {
            Topico topico = topicoRepositorio.getReferenceById(id);
            topico.desactivarTopico();
            return ResponseEntity.ok(new DatosDeteleLogico(topico.getId(), topico.getAutor(),
                    topico.getTitulo(), topico.getFecha_de_creacion(), topico.getStatus()));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
