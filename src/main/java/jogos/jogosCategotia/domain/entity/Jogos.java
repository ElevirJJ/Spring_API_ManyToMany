package jogos.jogosCategotia.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "jogo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Jogos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;

    @ManyToMany
    @JoinTable(
            name = "jogo_categoria",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )

    private List<Categoria> categorias;
}
