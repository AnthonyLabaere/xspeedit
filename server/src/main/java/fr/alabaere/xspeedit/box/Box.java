package fr.alabaere.xspeedit.box;

import fr.alabaere.xspeedit.article.Article;
import fr.alabaere.xspeedit.supplyChain.SupplyChain;
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
public class Box {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    private SupplyChain supplyChain;

    @OneToMany(
            mappedBy = "box",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Article> articles = new ArrayList<>();

    public Integer occupancy() {
        return articles.stream().reduce(0, (sum, article) -> sum += article.getSize(), (article1, article2) -> article1 + article2);
    }

    public List<Article> fillWithArticles(List<Article> articles) {
        List<Article> remainingArticles = new ArrayList<>(articles);

        articles.stream()
                .sorted((article1, article2) -> Integer.compare(article2.getSize(), article1.getSize()))
                .forEach(article -> {
                    Integer occupancy = occupancy();

                    // TODO : à corriger car pas terrible
                    if (article.getSize() <= supplyChain.getBoxesCapacity() - occupancy && occupancy < supplyChain.getBoxesCapacity()) {
                        this.articles.add(article);
                        remainingArticles.remove(article);
                    }
                });

        return remainingArticles;
    }

}
