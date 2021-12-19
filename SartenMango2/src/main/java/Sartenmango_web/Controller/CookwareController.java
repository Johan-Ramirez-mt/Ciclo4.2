package Sartenmango_web.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import Sartenmango_web.Model.Cookware;
import Sartenmango_web.Service.CookwareService;

/**
 *
 * @author Johan Ramirez
 */

@RestController
@RequestMapping("api/cookware")
@CrossOrigin("*")
public class CookwareController {
     @Autowired
    private CookwareService cookWareService;

    @GetMapping("/all")
    public List<Cookware> getAll() {
        return cookWareService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Cookware> getProduct(@PathVariable("reference") String reference) {
        return cookWareService.getCook(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware create(@RequestBody Cookware gadget) {
        return cookWareService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cookware update(@RequestBody Cookware product) {
        return cookWareService.update(product);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return cookWareService.delete(reference);
    }
}
