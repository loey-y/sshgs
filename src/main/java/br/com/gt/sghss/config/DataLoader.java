package br.com.gt.sghss.config;

import br.com.gt.sghss.domain.entity.PerfilUsuario;
import br.com.gt.sghss.domain.entity.Usuario;
import br.com.gt.sghss.domain.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner createDefaultUsers(UsuarioRepository usuarioRepository,
                                                PasswordEncoder passwordEncoder) {
        return args -> {
            criarSeNaoExistir(usuarioRepository, passwordEncoder,
                    "admin", "admin123", PerfilUsuario.ADMIN);

            criarSeNaoExistir(usuarioRepository, passwordEncoder,
                    "medico1", "medico123", PerfilUsuario.MEDICO);

            criarSeNaoExistir(usuarioRepository, passwordEncoder,
                    "enfermeiro1", "enf123", PerfilUsuario.ENFERMEIRO);

            criarSeNaoExistir(usuarioRepository, passwordEncoder,
                    "tecnico1", "tec123", PerfilUsuario.TECNICO_ENFERMAGEM);
        };
    }

    private void criarSeNaoExistir(UsuarioRepository repo,
                                   PasswordEncoder encoder,
                                   String login,
                                   String senhaPura,
                                   PerfilUsuario perfil) {

        if (repo.findByLogin(login).isEmpty()) {
            Usuario u = new Usuario();
            u.setLogin(login);
            u.setSenhaHash(encoder.encode(senhaPura)); // senha criptografada
            u.setPerfil(perfil);
            u.setAtivo(true);
            repo.save(u);
            System.out.printf("Usuário criado: %s / %s (%s)%n",
                    login, senhaPura, perfil.name());
        }
    }
}
