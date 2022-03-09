package model.repository;

import java.io.Serializable;
import java.util.List;

public class RepositoryImpl<T,ID> implements Repository<T,ID>{
    @Override
    public void save(T t) {
        try(var session = getSessionFactory().openSession()){
            var transaction = session.beginTransaction();
            try{
                session.save(t);
                transaction.commit();
            }catch (Exception e){
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(T t) {
        try(var session = getSessionFactory().openSession()){
            var transaction = session.beginTransaction();
            try{
                session.update(t);
                transaction.commit();
            }catch (Exception e){
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(T t) {
        try(var session = getSessionFactory().openSession()){
            var transaction = session.beginTransaction();
            try{
                session.delete(t);
                transaction.commit();
            }catch (Exception e){
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteById(ID id) {
        try(var session = getSessionFactory().openSession()){
            var transaction = session.beginTransaction();
            try{
                session.delete(id);
                transaction.commit();
            }catch (Exception e){
                transaction.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public T findById(Class<T> tClass, ID id) {
        try (var session = getSessionFactory().openSession()){
            return session.get(tClass, (int) id);
        }
    }

    @Override
    public List<T> findAll(Class<T> tClass) {
        try(var session = getSessionFactory().openSession()){
            var criteriaBuilder = session.getCriteriaBuilder();
            var criteriaQuery = criteriaBuilder.createQuery(tClass);
            var root = criteriaQuery.from(tClass);
            return session.createQuery(criteriaQuery.select(root)).list();
        }
    }
}
