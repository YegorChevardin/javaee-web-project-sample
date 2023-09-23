package ua.com.yehorchevardin.andersen.javaee.project.sample.service.convertors.impl;

import org.springframework.stereotype.Component;
import ua.com.yehorchevardin.andersen.javaee.project.sample.repository.entity.UserEntity;
import ua.com.yehorchevardin.andersen.javaee.project.sample.service.convertors.EntityDtoObjectConvertor;
import ua.com.yehorchevardin.andersen.javaee.project.sample.web.dto.User;

@Component
public class UserEntityDtoObjectConvertor implements EntityDtoObjectConvertor<UserEntity, User> {
  @Override
  public User convertEntityToDto(UserEntity entity) {
    return new User(entity.getId(), entity.getName(), entity.getSecondName(), entity.getAge());
  }

  @Override
  public UserEntity convertDtoToEntity(User dto) {
    return new UserEntity(dto.getId(), dto.getName(), dto.getSecondName(), dto.getAge());
  }
}
