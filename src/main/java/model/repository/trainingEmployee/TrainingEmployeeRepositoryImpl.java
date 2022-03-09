package model.repository.trainingEmployee;

import model.entity.TrainingEmployee;
import model.repository.LoginBase;
import model.repository.RepositoryImpl;
import model.util.SingleTonConnection;

public class TrainingEmployeeRepositoryImpl extends RepositoryImpl<TrainingEmployee,Integer> implements  TrainingEmployeeRepository {
public TrainingEmployee login(String userName , String password){
        try(var session = getSessionFactory().openSession()){
            var transaction = session.getTransaction();
            try{
                var criteriaBuilder = session.getCriteriaBuilder();
                var criteriaQuery = criteriaBuilder.createQuery(TrainingEmployee.class);
                var root = criteriaQuery.from(TrainingEmployee.class);

                var userNameEqual = criteriaBuilder.equal(root.get("userName"),userName);
                var passwordEqual = criteriaBuilder.equal(root.get("password"),password);

                var query = criteriaQuery
                        .select(root)
                        .where(criteriaBuilder.and(userNameEqual,passwordEqual));
                return session.createQuery(query).getSingleResult();
            }catch (Exception e){
                transaction.rollback();
                e.printStackTrace();
            }
        }
        return null;
    }
}
