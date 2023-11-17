package customer.loginpage;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@SqlResultSetMapping(name = "user_mapping", classes =
@ConstructorResult(targetClass = UserData.class, columns = {
@ColumnResult(name = "user_id", type = Long.class),
@ColumnResult(name = "username", type = String.class),
@ColumnResult(name = "email", type = String.class),
@ColumnResult(name = "password", type = String.class),
@ColumnResult(name = "full_name", type = String.class),
@ColumnResult(name = "date_of_birth", type = Date.class),
@ColumnResult(name = "registration_date", type = Date.class),
@ColumnResult(name = "status", type = Integer.class)
}))
@Entity
@Getter
@Setter
// @Table(name = "user_data")
public class UserData {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "user_id")
    private Long userId;

    // @Column(name = "username", nullable = false, length = 256)
    private String username;

    // @Column(name = "email", nullable = false, length = 256)
    private String email;

    // @Column(name = "password", nullable = false, length = 256)
    private String password;

    // @Column(name = "full_name", length = 256)
    private String fullName;

    // @Column(name = "date_of_birth")
    private Date dateOfBirth;

    // @Column(name = "registration_date", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    // @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    // @Column(name = "status", nullable = false)
    private Integer status;

//    public UserData(){

//    }
    public UserData(String username, String email, String password, String fullName, Date dateOfBirth, Integer status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    // Additional constructors, getters, and setters as needed
}
