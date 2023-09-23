package ua.com.yehorchevardin.andersen.javaee.project.sample.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity user object
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
@Getter
@Setter
@AllArgsConstructor
public class UserEntity {
  private Long id;
  private String name;
  private String secondName;
  private int age;
}
