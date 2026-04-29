package jogos.jogosCategotia.repository;

import jogos.jogosCategotia.domain.entity.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JogosRepository extends JpaRepository<Jogos, Long> {

}
