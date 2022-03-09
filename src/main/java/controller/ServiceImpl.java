package controller;

import lombok.NoArgsConstructor;
import model.repository.Repository;

import java.util.List;

@NoArgsConstructor
public class ServiceImpl<R extends Repository<T,ID>,T,ID> implements Service<R,T,ID>{
    private R r;


    public ServiceImpl(R r) {
        this.r = r;
    }

    @Override
    public void save(T t) {
        r.save(t);
    }

    @Override
    public void update(T t) {
        r.update(t);
    }

    @Override
    public void delete(T t) {
        r.delete(t);
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public T findById(Class<T> tClass, ID id) {
        return r.findById(tClass,id);
    }

    @Override
    public List<T> findAll(Class<T> tClass) {
        return r.findAll(tClass);
    }
}
