package fr.alabaere.xspeedit.box;

import fr.alabaere.xspeedit.article.ArticleDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BoxDTO {

    private Long id;

    private List<ArticleDTO> articles = new ArrayList<>();
}
