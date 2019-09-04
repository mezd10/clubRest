package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@ToString
@Setter
@Getter
@Table(name = "player")
public class Player extends BaseEntity {

    @Column(name = "date_of_birth")
    private Date dateBirthPlayer;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;


}
