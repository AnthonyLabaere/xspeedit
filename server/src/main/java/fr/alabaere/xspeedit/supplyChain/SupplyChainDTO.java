package fr.alabaere.xspeedit.supplyChain;

import fr.alabaere.xspeedit.box.BoxDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SupplyChainDTO {

    private Long id;

    private List<BoxDTO> boxes = new ArrayList<>();
}
