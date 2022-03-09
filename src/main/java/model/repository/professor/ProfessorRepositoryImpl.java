package model.repository.professor;

import model.entity.Professor;
import model.entity.Score;
import model.repository.RepositoryImpl;

import java.util.List;

public class ProfessorRepositoryImpl extends RepositoryImpl<Professor,Integer> implements ProfessorRepository{
    @Override
    public List<Score> getProfessorCourse(Integer id) {
        try(var session = getSessionFactory().openSession()){
            var transaction = session.getTransaction();
            try{
                var hql = "FROM model.entity.Score score " +
                        "WHERE score.professor.id = :professorId ";
                var query = session.createQuery(hql,Score.class);
                query.setParameter("professorId",id);
                return query.getResultList();
            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }
        }
        return null;
    }
}
