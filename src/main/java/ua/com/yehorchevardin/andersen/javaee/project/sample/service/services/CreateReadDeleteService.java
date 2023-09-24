package ua.com.yehorchevardin.andersen.javaee.project.sample.service.services;

import java.util.List;

/**
 * Create read delete service
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
public interface CreateReadDeleteService<T> {
  void create(T object);

  List<T> readAll();

  T readById(Long id);

  void deleteById(Long id);
}
