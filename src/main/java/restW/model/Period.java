package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "period")
public class Period extends BaseEntity {

    @Column(name = "position_id")
    private Integer positionID;

    @Column(name = "personal_id")
    private Integer personalID;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "price")
    private Integer price;
}
