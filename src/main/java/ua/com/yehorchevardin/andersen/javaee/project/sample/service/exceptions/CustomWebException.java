package ua.com.yehorchevardin.andersen.javaee.project.sample.service.exceptions;

/**
 * Custom unchecked exception for handling custom web exceptions
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
public abstract class CustomWebException extends RuntimeException {
  public CustomWebException(String message) {
    super(message);
  }

  public CustomWebException(String message, Throwable cause) {
    super(message, cause);
  }
}
