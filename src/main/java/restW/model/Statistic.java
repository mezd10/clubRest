package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@Table(name = "statistics")

public class Statistic extends BaseEntity{

    @Column(name = "minutes_played")
    private Integer minutesPlayed;

    @Column(name = "goals_scored")
    private Integer goalsScored;

    @Column(name = "goals_missed")
    private Integer goalsMissed;

    @Column(name = "average_efficiency")
    private Integer averageEfficiency;

    @Column(name = "last_updated_date")
    private Date lastUpdate ;
}
