package fr.alabaere.xspeedit.supplyChain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public interface SupplyChainService {

    @Getter
    @Setter
    class OptimizeParameter {
        Integer boxesCapacity;
        String articlesSizes;
    }

    List<SupplyChainDTO> getAll();

    SupplyChainDTO optimizeArticlesIntoBoxes(OptimizeParameter parameter);
}
