package fr.alabaere.xspeedit.supplyChain;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "api/supplyChain")
public class SupplyChainController {

    @Resource
    private SupplyChainService service;

    @PostMapping("/optimize")
    @CrossOrigin(origins = "http://localhost:4200")
    public SupplyChainDTO optimize(@RequestBody SupplyChainService.OptimizeParameter parameter) {
        return service.optimizeArticlesIntoBoxes(parameter);
    }
}
