package ua.com.yehorchevardin.andersen.javaee.project.sample.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Dto class for user
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
@AllArgsConstructor
@Getter
@Setter
public class User {
  private Long id;
  private String name;
  private String secondName;
  private int age;
}
