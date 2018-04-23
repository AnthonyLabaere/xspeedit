package fr.alabaere.xspeedit.supplyChain;

import fr.alabaere.xspeedit.box.Box;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class SupplyChainTest {

    private SupplyChain supplyChain;

    @Before
    public void setUp() {
        supplyChain = new SupplyChain();
    }

    @Test
    public void addBoxTest() {
        Assertions.assertThat(supplyChain.getBoxes().size()).isEqualTo(0);

        Box box = supplyChain.addBox();

        Assertions.assertThat(box.getSupplyChain()).isEqualTo(supplyChain);
        Assertions.assertThat(supplyChain.getBoxes().size()).isEqualTo(1);
    }
}
