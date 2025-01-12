package dev.alonso.ChallengeForoHubProyecto.domain.topico;

import dev.alonso.ChallengeForoHubProyecto.domain.usuarios.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_de_creacion;
    private Boolean status;
    private String autor;
    private String curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Topico() {
    }

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fecha_de_creacion, Boolean status, String autor, String curso, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha_de_creacion = fecha_de_creacion;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
        this.usuario = usuario;
    }

    public Topico(@Valid DatosRegistroTopico datosRegistroTopico, Usuario usuario) {
        this.usuario = usuario;
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.autor = datosRegistroTopico.autor();
        this.curso = datosRegistroTopico.curso();
        this.fecha_de_creacion = LocalDateTime.now();
        this.status = true;
    }

    public void actualizarDatos(@Valid DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.autor() != null) {
            this.autor = datosActualizarTopico.autor();
        }
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }

    public void actualizarDatosTopicoEspecifico(@Valid DatosActulizarTopicoEspecifico datosActulizarTopicoEspecifico) {
        if (datosActulizarTopicoEspecifico.autor() != null) {
            this.autor = datosActulizarTopicoEspecifico.autor();
        }
        if (datosActulizarTopicoEspecifico.titulo() != null) {
            this.titulo = datosActulizarTopicoEspecifico.titulo();
        }
        if (datosActulizarTopicoEspecifico.mensaje() != null) {
            this.mensaje = datosActulizarTopicoEspecifico.mensaje();
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public void setFecha_de_creacion(LocalDateTime fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}