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

    public Student(Integer id, String name, String city, College college) {
        super(id, name);
        this.city = city;
        this.college = college;
    }
}
