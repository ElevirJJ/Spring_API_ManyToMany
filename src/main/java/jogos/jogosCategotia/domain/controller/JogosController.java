package jogos.jogosCategotia.domain.controller;

import jogos.jogosCategotia.domain.dto.CategoriaDTO;
import jogos.jogosCategotia.domain.dto.JogoDTO;
import jogos.jogosCategotia.domain.service.CategoriaService;
import jogos.jogosCategotia.domain.service.JogosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogo")
public class JogosController {

    private final JogosService jogosService;

    public JogosController(JogosService jogosService) {
        this.jogosService = jogosService;
    }


    @PostMapping
    public ResponseEntity newCategoria (@RequestBody JogoDTO dto){
        jogosService.createJogo(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<JogoDTO>> list (){
        var lista = jogosService.jogoAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity peloID(@PathVariable Long id){
        return ResponseEntity.ok(jogosService.buscarID(id));
    }
}
