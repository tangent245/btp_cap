package customer.loginpage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Component
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;
 
    public Collection<UserData> jgetAllUsers() {
        try {
            Collection<UserData> results = new ArrayList<UserData>();
            if (entityManager != null) {
                  StoredProcedureQuery spEmployees = entityManager
                    .createStoredProcedureQuery("GETUSERDETAIL", "user_mapping");
            spEmployees.execute();
            @SuppressWarnings("unchecked")
            Collection<UserData> tempResults = spEmployees.getResultList();
            results.addAll(tempResults);
            }
            // else {      
            // }
 
           return results;
        } catch (Exception exception) {
            throw exception;
        }
    }
}
