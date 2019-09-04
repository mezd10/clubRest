package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@ToString
@Setter
@Getter
@Table(name = "position_on_club")
public class PositionOnClub extends BaseEntity {
    @Column(name = "name")
    private String name;
}
