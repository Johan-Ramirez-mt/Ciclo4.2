package Sartenmango_web.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Sartenmango_web.Model.Cookware;
import Sartenmango_web.Interface.CookwareInterface;

/**
 *
 * @author Elsy Del Aguila 
 */
@Repository
public class CookwareRepository {
    @Autowired
    private CookwareInterface cookWareCrudRepository;

    /**
     *
     * @return lista de Cookware
     */
    public List<Cookware> getAll() {
        return cookWareCrudRepository.findAll();
    }
    public Optional<Cookware> getCook(String Reference) {
        return cookWareCrudRepository.findById(Reference);
    }

    public Cookware create(Cookware cook) {
        return cookWareCrudRepository.save(cook);
    }

    public void update(Cookware cook) {
        cookWareCrudRepository.save(cook);
    }

    public void delete(Cookware cook) {
        cookWareCrudRepository.delete(cook);
    }

}
