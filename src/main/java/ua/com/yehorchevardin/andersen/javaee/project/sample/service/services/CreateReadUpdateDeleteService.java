package ua.com.yehorchevardin.andersen.javaee.project.sample.service.services;

public interface CreateReadUpdateDeleteService<T> extends CreateReadDeleteService<T> {
    void update(T object);
}
