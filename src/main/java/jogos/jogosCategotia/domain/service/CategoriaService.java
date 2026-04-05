package jogos.jogosCategotia.domain.service;

import jogos.jogosCategotia.domain.dto.CategoriaDTO;
import jogos.jogosCategotia.domain.entity.Categoria;
import jogos.jogosCategotia.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void createCategoria (CategoriaDTO dto){
        Categoria categoria = new Categoria();
        categoria.setRpg(dto.rpg());
        categoria.setLuta(dto.luta());
        categoria.setCorrida(dto.corrida());
        categoriaRepository.save(categoria);
    }

    public List<CategoriaDTO> listAll (){
        return categoriaRepository.findAll()
                .stream()
                .map(c -> new CategoriaDTO(c.getId(), c.getRpg(), c.getLuta(), c.getCorrida()))
                .toList();
    }

    public Categoria buscarPorID(Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " não encontrado"));
    }
}
