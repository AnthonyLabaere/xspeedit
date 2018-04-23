package fr.alabaere.xspeedit.supplyChain.service;

import fr.alabaere.xspeedit.article.ArticleDTO;
import fr.alabaere.xspeedit.supplyChain.SupplyChainDTO;
import fr.alabaere.xspeedit.supplyChain.SupplyChainService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class OptimizeArticlesIntoBoxesTest extends AbstractSupplyChainServiceTest {

    private final static Integer BOXES_CAPACITY = 10;
    private final static String ARTICLE_SIZES = "163841689525773";

    private SupplyChainService.OptimizeParameter parameter;

    @Before
    @Override
    public void setUp() {
        super.setUp();

        parameter = new SupplyChainService.OptimizeParameter();
        parameter.setBoxesCapacity(BOXES_CAPACITY);
        parameter.setArticlesSizes(ARTICLE_SIZES);
    }

    // TODO : test sur les exceptions

    @Test
    public void test() {
        SupplyChainDTO optimizedSupplyChain = this.supplyChainService.optimizeArticlesIntoBoxes(parameter);

        // The optimized supply chain must be (9,1) (8,2) (8,1) (7,3) (7,3) (6,4) (6) (5,5)
        Assertions.assertThat(optimizedSupplyChain.getBoxes()).isNotNull();
        Assertions.assertThat(optimizedSupplyChain.getBoxes().size()).isEqualTo(8);

        Assertions.assertThat(optimizedSupplyChain.getBoxes().get(0).getArticles().stream().map(ArticleDTO::getSize).toArray()).isEqualTo(new Integer[]{9, 1});
        Assertions.assertThat(optimizedSupplyChain.getBoxes().get(1).getArticles().stream().map(ArticleDTO::getSize).toArray()).isEqualTo(new Integer[]{8, 2});
        Assertions.assertThat(optimizedSupplyChain.getBoxes().get(2).getArticles().stream().map(ArticleDTO::getSize).toArray()).isEqualTo(new Integer[]{8, 1});
        Assertions.assertThat(optimizedSupplyChain.getBoxes().get(3).getArticles().stream().map(ArticleDTO::getSize).toArray()).isEqualTo(new Integer[]{7, 3});
        Assertions.assertThat(optimizedSupplyChain.getBoxes().get(4).getArticles().stream().map(ArticleDTO::getSize).toArray()).isEqualTo(new Integer[]{7, 3});
        Assertions.assertThat(optimizedSupplyChain.getBoxes().get(5).getArticles().stream().map(ArticleDTO::getSize).toArray()).isEqualTo(new Integer[]{6, 4});
        Assertions.assertThat(optimizedSupplyChain.getBoxes().get(6).getArticles().stream().map(ArticleDTO::getSize).toArray()).isEqualTo(new Integer[]{6});
        Assertions.assertThat(optimizedSupplyChain.getBoxes().get(7).getArticles().stream().map(ArticleDTO::getSize).toArray()).isEqualTo(new Integer[]{5, 5});
    }
}
