package fr.alabaere.xspeedit.supplyChain;

import fr.alabaere.xspeedit.article.Article;
import fr.alabaere.xspeedit.box.Box;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class SupplyChain {

    @Id
    @GeneratedValue
    private Long id;

    private @NonNull Integer boxesCapacity;

    @OneToMany(
            mappedBy = "tag",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Box> boxes = new ArrayList<>();

    public SupplyChain (Integer boxesCapacity) {
        this.boxesCapacity = boxesCapacity;
    }

    public Box addBox() {
        Box box = new Box();
        boxes.add(box);
        return box;
    }

}
