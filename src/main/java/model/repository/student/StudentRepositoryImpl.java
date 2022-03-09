package model.repository.student;

import model.entity.Score;
import model.entity.Student;
import model.repository.RepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentRepositoryImpl extends RepositoryImpl<Student,Integer> implements StudentRepository {

    @Override
    public List<Score> getStudentCourse(Integer id) {
        try(var session = getSessionFactory().openSession()){
            var transaction = session.getTransaction();
            try{
                var hql = "FROM model.entity.Score score " +
                        "JOIN FETCH model.entity.Student student " +
                        "WHERE score.student.id = :studentId ";
                var query = session.createQuery(hql,Score.class);
                query.setParameter("studentId",id);
                return query.getResultList()
                        .stream()
                        .sorted(Comparator.comparing(Score::getTerm))
                        .collect(Collectors.toList());
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }
        }
        return null;
    }
}
