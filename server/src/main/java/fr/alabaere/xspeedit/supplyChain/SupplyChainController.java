package fr.alabaere.xspeedit.supplyChain;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "api/supplyChain")
public class SupplyChainController {

    @Resource
    private SupplyChainService service;

    @GetMapping("/getAll")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<SupplyChainDTO> getAll() {
        return service.getAll();
    }

    @PostMapping("/optimize")
    @CrossOrigin(origins = "http://localhost:4200")
    public SupplyChainDTO optimize(@RequestBody SupplyChainService.OptimizeParameter parameter) {
        return service.optimizeArticlesIntoBoxes(parameter);
    }
}
