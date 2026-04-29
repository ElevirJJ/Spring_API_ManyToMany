package jogos.jogosCategotia.domain.handler;

import jogos.jogosCategotia.domain.exerception.ErroResponse;
import jogos.jogosCategotia.domain.exerception.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ErroResponse> erro (NotFound notFound){
        ErroResponse response = ErroResponse.builder()
                .mensagem(notFound.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
