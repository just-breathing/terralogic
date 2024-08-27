package assessment.terralogic.authentication.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User  {
    @Id
    @Column(nullable=false, unique = true,name="user_name")
    private String userName;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false, unique = true,name="email")
    private String email;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="middle_name")
    private String middleName;
    @Column(name="contact_no")
    private String contactNo;
    @Column(name="expiration_date")
    private LocalDate expirationDate;
    @Column(name="description")
    private String description;
    @Column(name="timeout")
    private Integer Timeout;
    @Column(name="date_time_format")
    private String dateTimeFormat;
    @Column(name="role")
    private String Role;
    @Column(name="scope_name_list")
    private String scopeNameList;
    @Column(nullable=false,name="prime_group_name")
    private String primeGroupName;
    @Column(name="second_group_name")
    private String secondGroupName;
    @Column(name="language")
    private String language;
    @Column(name="organization")
    private String organization;
    @Column(name="time_zone")
    private String timeZone ;
    @Column(name="memo")
    private String Memo;

    
}

