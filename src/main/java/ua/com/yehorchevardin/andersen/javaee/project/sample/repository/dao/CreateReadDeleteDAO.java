package ua.com.yehorchevardin.andersen.javaee.project.sample.repository.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * DAO interface for CRD opeartions
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
public interface CreateReadDeleteDAO<T> {
  void create(T object) throws SQLException;

  List<T> readAll() throws SQLException;

  Optional<T> readById(Long id) throws SQLException;

  void deleteById(Long id) throws SQLException;
}
