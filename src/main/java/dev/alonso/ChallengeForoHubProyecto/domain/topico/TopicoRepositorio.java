package dev.alonso.ChallengeForoHubProyecto.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepositorio extends JpaRepository<Topico, Long> {
    Page<Topico> findByStatusTrue(Pageable pageable);
}
