package jogos.jogosCategotia.domain.controller;

import jogos.jogosCategotia.domain.dto.CategoriaDTO;
import jogos.jogosCategotia.domain.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity newCategoria (@RequestBody CategoriaDTO dto){
        categoriaService.createCategoria(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<CategoriaDTO>> list (){
        var lista = categoriaService.listAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity peloID(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.buscarPorID(id));
    }
}
