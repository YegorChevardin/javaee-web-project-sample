package ua.com.yehorchevardin.andersen.javaee.project.sample.service.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.yehorchevardin.andersen.javaee.project.sample.repository.dao.CreateReadUpdateDeleteDAO;
import ua.com.yehorchevardin.andersen.javaee.project.sample.repository.entity.UserEntity;
import ua.com.yehorchevardin.andersen.javaee.project.sample.service.constants.ExceptionMessages;
import ua.com.yehorchevardin.andersen.javaee.project.sample.service.convertors.EntityDtoObjectConvertor;
import ua.com.yehorchevardin.andersen.javaee.project.sample.service.exceptions.impl.DataNotFoundException;
import ua.com.yehorchevardin.andersen.javaee.project.sample.service.exceptions.impl.WebOperationException;
import ua.com.yehorchevardin.andersen.javaee.project.sample.service.services.CreateReadUpdateDeleteService;
import ua.com.yehorchevardin.andersen.javaee.project.sample.web.dto.User;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements CreateReadUpdateDeleteService<User> {
  private final CreateReadUpdateDeleteDAO<UserEntity> userDAO;
  private final EntityDtoObjectConvertor<UserEntity, User> userEntityDtoObjectConvertor;

  @Override
  public void create(User object) {
    try {
      UserEntity userEntity = userEntityDtoObjectConvertor.convertDtoToEntity(object);
      userDAO.create(userEntity);
    } catch (SQLException e) {
      throw new WebOperationException(ExceptionMessages.WEB_OPERATION_EXCEPTION.getMessage(), e);
    }
  }

  @Override
  public List<User> readAll() {
    try {
      return userEntityDtoObjectConvertor.convertListEntityToListDto(userDAO.readAll());
    } catch (SQLException e) {
      throw new WebOperationException(ExceptionMessages.WEB_OPERATION_EXCEPTION.getMessage(), e);
    }
  }

  @Override
  public User readById(Long id) {
    try {
      return userEntityDtoObjectConvertor.convertEntityToDto(findById(id));
    } catch (SQLException e) {
      throw new WebOperationException(ExceptionMessages.WEB_OPERATION_EXCEPTION.getMessage(), e);
    }
  }

  @Override
  public void deleteById(Long id) {
    try {
      findById(id);
      userDAO.deleteById(id);
    } catch (SQLException e) {
      throw new WebOperationException(ExceptionMessages.WEB_OPERATION_EXCEPTION.getMessage(), e);
    }
  }

  @Override
  public void update(User object) {
    try {
      findById(object.getId());
      userDAO.update(userEntityDtoObjectConvertor.convertDtoToEntity(object));
    } catch (SQLException e) {
      throw new WebOperationException(ExceptionMessages.WEB_OPERATION_EXCEPTION.getMessage(), e);
    }
  }

  private UserEntity findById(Long id) throws SQLException {
    return userDAO
        .readById(id)
        .orElseThrow(
            () ->
                new DataNotFoundException(
                    String.format(ExceptionMessages.OBJECT_NOT_FOUND_EXCEPTION.getMessage(), id)));
  }
}
