package jogos.jogosCategotia.repository;

import jogos.jogosCategotia.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
