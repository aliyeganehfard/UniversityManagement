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

    public Student(Integer id, String name, String userName, String password, String city, College college) {
        super(id, name, userName, password);
        this.city = city;
        this.college = college;
    }
}
