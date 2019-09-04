package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
public class Employee extends BaseEntity{

    @Column(name = "date_of_birth")
    private Date dateBirth;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;
}
