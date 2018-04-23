package fr.alabaere.xspeedit.supplyChain;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SupplyChainController {

    @Resource
    private SupplyChainService service;

    @PostMapping("/optimize")
    @CrossOrigin(origins = "http://localhost:4200")
    public SupplyChainDTO optimize(@RequestBody SupplyChainService.OptimizeParameter parameter) {
        return service.optimizeArticlesIntoBoxes(parameter);
    }
}
