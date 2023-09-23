package ua.com.yehorchevardin.andersen.javaee.project.sample.service.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Excpetion messages
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
@AllArgsConstructor
public enum ExceptionMessages {
  WEB_OPERATION_EXCEPTION("Oops! Something went wrong, try again later!"),
  OBJECT_NOT_FOUND_EXCEPTION("Object with this id %s was not found!");

  @Getter private final String message;
}
