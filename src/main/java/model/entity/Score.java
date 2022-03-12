package model.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Professor professor;
    @ManyToOne
    private Course course;
    private Integer term;
    private Double score;


    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", student=" + student +
                ", professor=" + professor +
                ", course=" + course +
                ", term=" + term +
                ", score=" + score +
                '}';
    }
}
