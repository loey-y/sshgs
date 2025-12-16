package br.com.gt.sghss.domain.repository;

import br.com.gt.sghss.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
