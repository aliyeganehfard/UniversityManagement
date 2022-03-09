package model.repository;

import model.util.SingleTonConnection;
import org.hibernate.SessionFactory;

import java.util.List;

public interface Repository<T,ID> {
    default SessionFactory getSessionFactory(){
        return SingleTonConnection.getInstance();
    }
    void save(T t);
    void update(T t);
    void delete(T t);
    void deleteById(ID id);
    T findById(Class<T> tClass, ID id);
    List<T> findAll(Class<T> tClass);
}
