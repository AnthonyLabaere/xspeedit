package fr.alabaere.xspeedit.supplyChain;

import lombok.*;

public interface SupplyChainService {

    @Getter
    @Setter
    class OptimizeParameter {
        Integer boxesCapacity;
        String articlesSizes;
    }

    SupplyChainDTO optimizeArticlesIntoBoxes(OptimizeParameter parameter);
}
