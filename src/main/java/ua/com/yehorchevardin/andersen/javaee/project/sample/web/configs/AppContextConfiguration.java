package ua.com.yehorchevardin.andersen.javaee.project.sample.web.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring MVC configuration class
 *
 * @author yegorchevardin
 * @version 1.0.0
 */
@EnableWebMvc
@Configuration
@ComponentScan("ua.com.yehorchevardin.andersen.javaee.project.sample")
public class AppContextConfiguration {
  @Bean
  public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
}
