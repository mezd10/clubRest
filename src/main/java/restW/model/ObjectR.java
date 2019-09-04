package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@Table(name = "object")

public class ObjectR extends BaseEntity {
    @Column(name = "state")
    private String state;

    @Column(name = "id_code_responsible")
    private Integer codeResponsible;

    @Column(name = "type_object")
    private String typeObject;
}
