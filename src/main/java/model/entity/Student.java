package model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
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

    @Override
    public String toString() {
        return "Student{" +
                super.toString()+
                "city='" + city + '\'' +
                ", college=" + college +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return getId() != null && Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
