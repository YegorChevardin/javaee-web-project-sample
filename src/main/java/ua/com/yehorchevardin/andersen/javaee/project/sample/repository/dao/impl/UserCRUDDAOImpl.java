package ua.com.yehorchevardin.andersen.javaee.project.sample.repository.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.com.yehorchevardin.andersen.javaee.project.sample.repository.dao.CreateReadUpdateDeleteDAO;
import ua.com.yehorchevardin.andersen.javaee.project.sample.repository.entity.UserEntity;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * User CRUD DAO
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
@Repository
@RequiredArgsConstructor
public class UserCRUDDAOImpl implements CreateReadUpdateDeleteDAO<UserEntity> {
  private static final String CREATE_USER_STATEMENT =
      "INSERT INTO users(name, second_name, age) VALUES (?, ?, ?);";
  private static final String FIND_ALL_USERS = "SELECT * FROM users;";
  private static final String FIND_BY_ID = "SELECT * FROM users WHERE id = ?;";
  private static final String DELETE_BY_ID = "DELETE FROM users WHERE id = ?;";
  private static final String UPDATE_USER_BY_ID =
      "UPDATE users SET name = ?, second_name = ?, age = ? WHERE id = ?";

  private final DataSource dataSource;

  @Override
  public void create(UserEntity object) throws SQLException {
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_STATEMENT)) {
      prepareStatementFromObject(preparedStatement, object);
      preparedStatement.executeUpdate();
    }
  }

  @Override
  public List<UserEntity> readAll() throws SQLException {
    List<UserEntity> result = new ArrayList<>();

    try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_ALL_USERS)) {
      while (resultSet.next()) {
        result.add(
            new UserEntity(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("second_name"),
                resultSet.getInt("age")));
      }
    }

    return result;
  }

  @Override
  public Optional<UserEntity> readById(Long id) throws SQLException {
    Optional<UserEntity> optionalUser = Optional.empty();

    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        optionalUser =
            Optional.of(
                new UserEntity(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("second_name"),
                    resultSet.getInt("age")));
      }
    }

    return optionalUser;
  }

  @Override
  public void deleteById(Long id) throws SQLException {
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
      preparedStatement.setLong(1, id);
      preparedStatement.executeUpdate();
    }
  }

  @Override
  public void update(UserEntity object) throws SQLException {
    try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID)) {
      int lastIndex = prepareStatementFromObject(preparedStatement, object);
      preparedStatement.setLong(++lastIndex, object.getId());
      preparedStatement.executeUpdate();
    }
  }

  private int prepareStatementFromObject(PreparedStatement preparedStatement, UserEntity user)
      throws SQLException {
    int index = 0;
    preparedStatement.setString(++index, user.getName());
    preparedStatement.setString(++index, user.getSecondName());
    preparedStatement.setLong(++index, user.getAge());
    return index;
  }
}
