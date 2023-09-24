package ua.com.yehorchevardin.andersen.javaee.project.sample.service.exceptions.impl;

import ua.com.yehorchevardin.andersen.javaee.project.sample.service.exceptions.CustomWebException;

/**
 * Exception for case if object was not found
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
public class DataNotFoundException extends CustomWebException {
  public DataNotFoundException(String message) {
    super(message);
  }

  public DataNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
