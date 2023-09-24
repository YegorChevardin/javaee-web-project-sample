package ua.com.yehorchevardin.andersen.javaee.project.sample.web.controllers.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import ua.com.yehorchevardin.andersen.javaee.project.sample.service.exceptions.CustomWebException;

/**
 * Controller advice for handling errors
 *
 * @author yegorchevardin
 * @version 0.0.1
 */
@ControllerAdvice
public class CustomControllerAdvice {
  @ExceptionHandler(CustomWebException.class)
  public ModelAndView handleCustomExceptions(Exception e) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("error", e.getMessage());
    modelAndView.setViewName("error");
    return modelAndView;
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ModelAndView handle500Error() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("error");
    modelAndView.addObject("error", "Oops, something went wrong, try again later!");
    return modelAndView;
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ModelAndView handle404Error() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("error");
    modelAndView.addObject("error", "This page was not found!");
    return modelAndView;
  }
}
