
export class ArticleDTO {
  id: number;
  size: number;
}

export class BoxDTO {
  id: number;
  articles: ArticleDTO[];
}

export class SupplyChainDTO {
  id: number;
  initialArticlesSizes: number;
  boxesCapacity: number;
  boxes: BoxDTO[];
}

export class OptimizeParameter {
  boxesCapacity: number;
  articlesSizes: string;
}
