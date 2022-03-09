package model.repository;

import model.entity.Person;
import model.entity.TrainingEmployee;
import model.util.SingleTonConnection;

import javax.persistence.Entity;
import javax.persistence.NoResultException;

public interface LoginBase<T extends Person> {
     default T login(Class<T>  tClass, String userName , String password){
         var sessionFactory = SingleTonConnection.getInstance();
         try(var session = sessionFactory.openSession()){
             var transaction = session.getTransaction();
             try{
                 var criteriaBuilder = session.getCriteriaBuilder();
                 var criteriaQuery = criteriaBuilder.createQuery(tClass);
                 var root = criteriaQuery.from(tClass);

                 var userNameEqual = criteriaBuilder.equal(root.get("userName"),userName);
                 var passwordEqual = criteriaBuilder.equal(root.get("password"),password);
                 
                 var query = criteriaQuery
                         .select(root)
                         .where(criteriaBuilder.and(userNameEqual,passwordEqual));
                 return session.createQuery(query).getSingleResult();
             }catch (NoResultException e){
                 transaction.rollback();
                 e.printStackTrace();
             }
         }
         return null;
     }
}
