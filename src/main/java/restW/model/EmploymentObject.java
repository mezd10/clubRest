package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Getter
@Setter
@ToString
@Table(name = "employment_object")
public class EmploymentObject extends BaseEntity {

    @Column(name = "object_id")
    private Integer objectID;

    @Column(name = "day_work")
    private String dayWork;

    @Column(name = "clock_work_from")
    private Time workFrom;

    @Column(name = "clock_work_to")
    private Time workTo;

    @Column(name = "clock_technical_works")
    private Time clockTechnicalWorks;
}
