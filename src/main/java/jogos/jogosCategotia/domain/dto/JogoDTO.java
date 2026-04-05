package jogos.jogosCategotia.domain.dto;


import java.util.List;

public record JogoDTO(String nome, String idade, List<Long>categoriasIds) {
}
