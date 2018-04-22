package fr.alabaere.xspeedit.supplyChain;

import fr.alabaere.xspeedit.article.Article;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
public class SupplyChainServiceImpl implements SupplyChainService {

    @Override
    public SupplyChain optimizeArticlesIntoBoxes(OptimizeParameter parameter) {
        // TODO : vérification paramètres non null

        Integer boxesCapacity = parameter.getBoxesCapacity();
        String articleSizes = parameter.getArticlesSizes();

        if (!articleSizes.matches("^\\d+$")) {
            // TODO : gestion des exceptions fonctionnelles
        }

        SupplyChain supplyChain = new SupplyChain(boxesCapacity);

        List<Article> articles = articleSizes.chars()
                .mapToObj(i -> Character.getNumericValue((char)i))
                .sorted((size1, size2) -> Integer.compare(size2, size1))
                .map(Article::new)
                .collect(Collectors.toList());

        List<Article> remainingArticles = new ArrayList<>(articles);
        while (remainingArticles.size() > 0) {
            remainingArticles = supplyChain.addBox().fillWithArticles(remainingArticles);
        }

        return supplyChain;
    }
}
