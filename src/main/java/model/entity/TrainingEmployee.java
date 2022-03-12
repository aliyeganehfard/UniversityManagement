package model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TrainingEmployee extends Person{
    @ManyToOne
    private College college;

    public TrainingEmployee(Integer id, String name, String userName, String password, College college) {
        super(id, name, userName, password);
        this.college = college;
    }

    @Override
    public String toString() {
        return "TrainingEmployee{" +
                super.toString()+
                "college=" + college +
                '}';
    }
}
