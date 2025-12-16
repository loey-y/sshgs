package br.com.gt.sghss.controller;

import br.com.gt.sghss.domain.entity.Paciente;
import br.com.gt.sghss.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    // LISTAR TODOS – ADMIN, MEDICO, ENFERMEIRO, TECNICO_ENFERMAGEM
    @PreAuthorize("hasAnyRole('ADMIN','MEDICO','ENFERMEIRO','TECNICO_ENFERMAGEM')")
    @GetMapping
    public List<Paciente> listarTodos() {
        return service.listarTodos();
    }

    // BUSCAR POR ID – ADMIN, MEDICO, ENFERMEIRO, TECNICO_ENFERMAGEM
    @PreAuthorize("hasAnyRole('ADMIN','MEDICO','ENFERMEIRO','TECNICO_ENFERMAGEM')")
    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // CRIAR – ADMIN e MEDICO
    @PreAuthorize("hasAnyRole('ADMIN','MEDICO')")
    @PostMapping
    public ResponseEntity<Paciente> criar(@RequestBody Paciente paciente) {
        Paciente salvo = service.salvar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // ATUALIZAR – ADMIN e MEDICO
    @PreAuthorize("hasAnyRole('ADMIN','MEDICO')")
    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente existente = service.buscarPorId(id);
        paciente.setId(existente.getId());
        return service.salvar(paciente);
    }

    // EXCLUIR – só ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
