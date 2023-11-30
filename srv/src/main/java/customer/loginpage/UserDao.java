
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.List;
// import javax.persistence.EntityManager;
// import javax.persistence.PersistenceContext;
// import javax.persistence.StoredProcedureQuery;
// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;
// @Component
// public class UserDao {
//     @PersistenceContext
//     private EntityManager entityManager;
 
//     public Collection<UserData> jgetAllUsers() {
//         try {
//             Collection<UserData> results = new ArrayList<UserData>();
//             if (entityManager != null) {
//                   StoredProcedureQuery spEmployees = entityManager
//                     .createStoredProcedureQuery("GETUSERDETAIL", "user_mapping");
//             spEmployees.execute();
//             @SuppressWarnings("unchecked")
//             Collection<UserData> tempResults = spEmployees.getResultList();
//             results.addAll(tempResults);
//             }
//             // else {      
//             // }
 
//            return results;
//         } catch (Exception exception) {
//             throw exception;
//         }
//     }
    
        
//     }
package customer.loginpage;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserData getById(Long userId) {
        try {
            StoredProcedureQuery spGetEntityById = entityManager
                    .createStoredProcedureQuery("GETENTITYBYID", UserData.class)
                    .registerStoredProcedureParameter("p_user_id", Long.class, ParameterMode.IN)
                    .setParameter("p_user_id", userId);

            return (UserData) spGetEntityById.getSingleResult();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public Collection<UserData> getAll() {
        try {
            Collection<UserData> results = new ArrayList<>();
            StoredProcedureQuery spGetAllEntities = entityManager
                    .createStoredProcedureQuery("GETUSERDETAIL", UserData.class);

            @SuppressWarnings("unchecked")
            Collection<UserData> tempResults = spGetAllEntities.getResultList();
            results.addAll(tempResults);

            return results;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public UserData create(UserData entity) {
        try {
            StoredProcedureQuery spCreateEntity = entityManager
                    .createStoredProcedureQuery("CREATEDATA")
                    .registerStoredProcedureParameter("p_username", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_password", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_full_name", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_date_of_birth", java.sql.Date.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_status", Integer.class, ParameterMode.IN)
                    .setParameter("p_username", entity.getUsername())
                    .setParameter("p_email", entity.getEmail())
                    .setParameter("p_password", entity.getPassword())
                    .setParameter("p_full_name", entity.getFullName())
                    .setParameter("p_date_of_birth", entity.getDateOfBirth())
                    .setParameter("p_status", entity.getStatus());

            spCreateEntity.execute();
            
            // You might need to return the created entity or its ID, depending on your stored procedure
            return null;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public UserData update(UserData entity) {
        try {
            StoredProcedureQuery spUpdateEntity = entityManager
                    .createStoredProcedureQuery("UPDATEENTITY")
                    // .registerStoredProcedureParameter("p_user_id", Long.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_username", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_password", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_full_name", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_date_of_birth", java.sql.Date.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("p_status", Integer.class, ParameterMode.IN)
                    // .setParameter("p_user_id", entity.getUserId())
                    .setParameter("p_username", entity.getUsername())
                    .setParameter("p_email", entity.getEmail())
                    .setParameter("p_password", entity.getPassword())
                    .setParameter("p_full_name", entity.getFullName())
                    .setParameter("p_date_of_birth", entity.getDateOfBirth())
                    .setParameter("p_status", entity.getStatus());

            spUpdateEntity.execute();
            
            // You might need to return the updated entity or its ID, depending on your stored procedure
            return null;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public void delete(Long userId) {
        try {
            StoredProcedureQuery spDeleteEntity = entityManager
                    .createStoredProcedureQuery("DELETEENTITY")
                    .registerStoredProcedureParameter("p_user_id", Long.class, ParameterMode.IN)
                    .setParameter("p_user_id", userId);

            spDeleteEntity.execute();
        } catch (Exception exception) {
            throw exception;
        }
    }
}
