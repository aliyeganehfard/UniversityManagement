package model.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Student extends Person{
    private String city;

    @ManyToOne
    private College college;
}
