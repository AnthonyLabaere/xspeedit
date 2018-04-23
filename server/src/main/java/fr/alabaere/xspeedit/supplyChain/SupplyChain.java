package fr.alabaere.xspeedit.supplyChain;

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

    private @NonNull String initialArticlesSizes;

    private @NonNull Integer boxesCapacity;

    @OneToMany(
            mappedBy = "supplyChain",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Box> boxes = new ArrayList<>();

    public SupplyChain (String initialArticlesSizes, Integer boxesCapacity) {
        this.initialArticlesSizes = initialArticlesSizes;
        this.boxesCapacity = boxesCapacity;
    }

    public Box addBox() {
        Box box = new Box();
        box.setSupplyChain(this);
        boxes.add(box);
        return box;
    }

}
