package fr.alabaere.xspeedit.box;

import fr.alabaere.xspeedit.article.Article;
import fr.alabaere.xspeedit.supplyChain.SupplyChain;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class BoxTest {

    private final static Integer BOXES_CAPACITY = 10;

    private final static String ARTICLE_SIZES_1 = "163841689525773";
    private final static String ARTICLE_SIZES_2 = "12345";
    private final static String ARTICLE_SIZES_3 = "8723";
    private final static String ARTICLE_SIZES_4 = "1";

    private Box box;

    @Before
    public void setUp() {
        box = new Box();
        box.setSupplyChain(new SupplyChain(BOXES_CAPACITY));
    }

    @Test
    public void fillWithArticlesTest1() {
        // Le carton se remplit avec 9 et 1
        fillWithArticlesTest(ARTICLE_SIZES_1, new Integer[]{9, 1}, new Integer[]{6, 3, 8, 4, 1, 6, 8, 5, 2, 5, 7, 7, 3});
    }

    @Test
    public void fillWithArticlesTest2() {
        // Le carton se remplit avec 5, 4 et 1
        fillWithArticlesTest(ARTICLE_SIZES_2, new Integer[]{5, 4, 1}, new Integer[]{2, 3});
    }

    @Test
    public void fillWithArticlesTest3() {
        // Le carton se remplit avec 8 et 2
        fillWithArticlesTest(ARTICLE_SIZES_3, new Integer[]{8, 2}, new Integer[]{7, 3});
    }

    @Test
    public void fillWithArticlesTest4() {
        // Le carton se remplit avec 1
        fillWithArticlesTest(ARTICLE_SIZES_4, new Integer[]{1}, new Integer[0]);
    }

    private void fillWithArticlesTest(String articlesSizes, Integer[] boxArticlesSizes, Integer[] remainingArticlesSizes) {
        List<Article> remainingArticles = box.fillWithArticles(getArticles(articlesSizes));

        Assertions.assertThat(box.getArticles()).isNotNull();
        Assertions.assertThat(box.getArticles().size()).isEqualTo(boxArticlesSizes.length);
        Assertions.assertThat(box.getArticles().stream().map(Article::getSize).toArray()).isEqualTo(boxArticlesSizes);

        Assertions.assertThat(remainingArticlesSizes).isNotNull();
        Assertions.assertThat(remainingArticlesSizes.length).isEqualTo(remainingArticlesSizes.length);
        Assertions.assertThat(remainingArticles.stream().map(Article::getSize).toArray()).isEqualTo(remainingArticlesSizes);
    }

    private List<Article> getArticles(String articlesSizes) {
        return articlesSizes.chars()
                .mapToObj(i -> Character.getNumericValue((char)i))
                .map(Article::new)
                .collect(Collectors.toList());
    }
}
