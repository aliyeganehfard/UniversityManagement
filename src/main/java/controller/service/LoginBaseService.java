package controller.service;

public interface LoginBaseService<T> {
    T login(String username , String password);
}
