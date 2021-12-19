package Sartenmango_web.Interface;

/**
 *
 * @author Elsy Del Aguila 
 */
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import Sartenmango_web.Model.User;

public interface InterfaceUser extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> findTopByOrderByIdDesc();
}
