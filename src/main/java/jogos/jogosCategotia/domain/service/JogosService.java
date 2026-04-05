package jogos.jogosCategotia.domain.service;

import jogos.jogosCategotia.domain.dto.JogoDTO;
import jogos.jogosCategotia.domain.entity.Categoria;
import jogos.jogosCategotia.domain.entity.Jogos;
import jogos.jogosCategotia.repository.JogosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogosService {

    private final CategoriaService categoriaService;
    private final JogosRepository jogosRepository;

    public JogosService(CategoriaService categoriaService, JogosRepository jogosRepository) {
        this.categoriaService = categoriaService;
        this.jogosRepository = jogosRepository;
    }


    public void createJogo(JogoDTO dto){
        var categoria = dto.categoriasIds()
                .stream()
                .map(categoriaService::buscarPorID)
                .toList();

        Jogos jogos = Jogos.builder()
                .nome(dto.nome())
                .idade(dto.idade())
                .categorias(categoria)
                .build();

        jogosRepository.save(jogos);
    }

    public List<JogoDTO> jogoAll(){
        return jogosRepository.findAll()
                .stream()
                .map(j -> new JogoDTO(j.getNome(), j.getIdade(), j.getCategorias()
                        .stream()
                        .map(Categoria::getId)
                        .toList()
                ))
                .toList();
    }

    public Jogos buscarID (Long id){
        return jogosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(id + "não existi")));
    }


}
