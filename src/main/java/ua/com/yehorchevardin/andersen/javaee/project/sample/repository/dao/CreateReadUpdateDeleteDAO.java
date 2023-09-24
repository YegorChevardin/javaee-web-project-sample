package ua.com.yehorchevardin.andersen.javaee.project.sample.repository.dao;

import java.sql.SQLException;

/**
 * DAO interface for CRUD operations
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
public interface CreateReadUpdateDeleteDAO<T> extends CreateReadDeleteDAO<T> {
  void update(T object) throws SQLException;
}
