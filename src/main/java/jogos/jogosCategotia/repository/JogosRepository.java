package jogos.jogosCategotia.repository;

import jogos.jogosCategotia.domain.entity.Jogos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosRepository extends JpaRepository<Jogos, Long> {
}
