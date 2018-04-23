package fr.alabaere.xspeedit.supplyChain;

import fr.alabaere.xspeedit.article.Article;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service(value = "supplyChainService")
public class SupplyChainServiceImpl implements SupplyChainService {

    @Resource
    private SupplyChainRepository supplyChainRepository;

    @Override
    public SupplyChainDTO optimizeArticlesIntoBoxes(OptimizeParameter parameter) {
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

//        supplyChainRepository.save(supplyChain);

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(supplyChain, SupplyChainDTO.class);
    }
}
