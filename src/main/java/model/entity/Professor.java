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
}
