package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@ToString
@Getter
@Setter
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(name = "name")
    private String role;
}
