package model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Professor extends Person{
    private String degree;
    private String office;

    @ManyToOne
    private College college;

    public Professor(Integer id, String name, String userName, String password, String degree, String office, College college) {
        super(id, name, userName, password);
        this.degree = degree;
        this.office = office;
        this.college = college;
    }
}
