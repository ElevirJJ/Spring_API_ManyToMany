package jogos.jogosCategotia.domain.exerception;

import lombok.Builder;

@Builder
public record ErroResponse(String mensagem, Integer status) {
}
