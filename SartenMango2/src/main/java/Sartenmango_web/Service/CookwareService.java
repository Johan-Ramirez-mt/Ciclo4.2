package Sartenmango_web.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Sartenmango_web.Model.Cookware;
import Sartenmango_web.Repository.CookwareRepository;

/**
 *
 * @author Elsy Del Aguila 
 */
@Service
public class CookwareService {
    @Autowired
    private CookwareRepository cookWareRepository;

    public List<Cookware> getAll() {
        return cookWareRepository.getAll();
    }

    public Optional<Cookware> getCook(String reference) {
        return cookWareRepository.getCook(reference);
    }

    public Cookware create(Cookware cook) {
        if (cook.getReference() == null) {
            return cook;
        } else {
            return cookWareRepository.create(cook);
        }
    }

    public Cookware update(Cookware cook) {

        if (cook.getReference() != null) {
            Optional<Cookware> suplementDb = cookWareRepository.getCook(cook.getReference());
            if (!suplementDb.isEmpty()) {

                if (cook.getMateriales()!= null) {
                    suplementDb.get().setMateriales(cook.getMateriales());
                }
                if (cook.getDimensiones()!= null) {
                    suplementDb.get().setDimensiones(cook.getDimensiones());
                }
                
                if (cook.getBrand()!= null) {
                    suplementDb.get().setBrand(cook.getBrand());
                }
                
                if (cook.getCategory() != null) {
                    suplementDb.get().setCategory(cook.getCategory());
                }
                
                if (cook.getDescription() != null) {
                    suplementDb.get().setDescription(cook.getDescription());
                }
                if (cook.getPrice() != 0.0) {
                    suplementDb.get().setPrice(cook.getPrice());
                }
                if (cook.getQuantity() != 0) {
                    suplementDb.get().setQuantity(cook.getQuantity());
                }
                if (cook.getPhotography() != null) {
                    suplementDb.get().setPhotography(cook.getPhotography());
                }
                suplementDb.get().setAvailability(cook.isAvailability());
                cookWareRepository.update(suplementDb.get());
                return suplementDb.get();
            } else {
                return cook;
            }
        } else {
            return cook;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCook(reference).map(accesory -> {
            cookWareRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
