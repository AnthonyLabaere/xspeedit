package fr.alabaere.xspeedit;

import fr.alabaere.xspeedit.box.Box;
import fr.alabaere.xspeedit.supplyChain.SupplyChain;

import java.util.HashMap;
import java.util.Map;

public class TestObjectFactory {

    private final Map<Class<?>, Integer> hitCounts = new HashMap<>();

    protected int hitsCount(Class<?> type) {
        Integer typeHits = this.hitCounts.get( type );
        if ( typeHits == null ) {
            typeHits = 1;
        }
        else {
            typeHits++;
        }

        this.hitCounts.put(type, typeHits);

        return typeHits;
    }

    public SupplyChain newSupplyChain(String initialArticlesSizes, Integer boxesCapacity) {
        return new SupplyChain(initialArticlesSizes, boxesCapacity);
    }

    public SupplyChain newSupplyChain() {
        return this.newSupplyChain("", 10);
    }

    public Box addBox(SupplyChain supplyChain) {
        return supplyChain.addBox();
    }


}
