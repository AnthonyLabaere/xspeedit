package fr.alabaere.xspeedit.article;

import fr.alabaere.xspeedit.box.Box;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    private @NonNull Integer size;

    @ManyToOne(fetch = FetchType.LAZY)
    private Box box;

    public Article (Integer size) {
        this.size = size;
    }
}
