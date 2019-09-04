package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Setter
@Getter
@ToString
@Table(name = "employment_people")
public class EmployementPeople extends BaseEntity {

    @Column(name = "personal_id_employees")
    private Integer personalIDEmployees;

    @Column(name = "personal_id_players")
    private Integer personalIDPlayers;

    @Column(name = "to_do")
    private String toDo;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "object_id")
    private Integer objectID;
}
