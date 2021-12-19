package Sartenmango_web.Interface;

/**
 *
 * @author Elsy Del Aguila 
 */
import org.springframework.data.mongodb.repository.MongoRepository;
import Sartenmango_web.Model.Cookware;
public interface CookwareInterface extends MongoRepository<Cookware, String> {
    
}
