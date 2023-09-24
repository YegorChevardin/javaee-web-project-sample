package ua.com.yehorchevardin.andersen.javaee.project.sample.service.exceptions.impl;

import ua.com.yehorchevardin.andersen.javaee.project.sample.service.exceptions.CustomWebException;

/**
 * Exception for case of unsupported operation on not expected errors from db
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
public class WebOperationException extends CustomWebException {
  public WebOperationException(String message) {
    super(message);
  }

  public WebOperationException(String message, Throwable cause) {
    super(message, cause);
  }
}
