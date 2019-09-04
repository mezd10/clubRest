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
@Table(name = "role_period")
public class RolePeriod extends BaseEntity {

    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "perssonal_id")
    private Integer personalId;

    @Column(name = "statistics_id")
    private Integer statisticId;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    @Column(name = "price")
    private Integer price;


}
