package fr.alabaere.xspeedit.supplyChain;

import lombok.*;

public interface SupplyChainService {

    @Getter
    @Setter
    class OptimizeParameter {
        Integer boxesCapacity;
        String articlesSizes;
    }

    SupplyChain optimizeArticlesIntoBoxes(OptimizeParameter parameter);
}
