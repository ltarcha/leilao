package br.com.tcc.leilao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@ComponentScan({"br.com.tcc.leilao*"})
@SpringBootApplication
public class LeilaoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LeilaoApplication.class, args);
	}
	
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CharacterEncodingFilter characterEncodingFilter() {
      CharacterEncodingFilter filter = new CharacterEncodingFilter();
      filter.setEncoding("UTF-8");
      filter.setForceEncoding(true);
      return filter;
    }	

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
      FilterRegistrationBean registrationBean = new FilterRegistrationBean();
      registrationBean.setFilter(characterEncodingFilter());
      registrationBean.setOrder(0);
      return registrationBean;
    }       
    
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
      final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
      templateResolver.setCacheable(false);
      templateResolver.setPrefix("classpath:/templates/");
      templateResolver.setSuffix(".html");
      templateResolver.setTemplateMode("HTML5");
      return templateResolver;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine() {
      SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
      springTemplateEngine.setTemplateResolver(templateResolver());

      return springTemplateEngine;
    }
    
    @Bean(name="storage")
    public String storage() {
		return System.getenv("STORAGE");
	}    

    @Bean
    public ThymeleafViewResolver viewResolver() {
      ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
      thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
      thymeleafViewResolver.setCharacterEncoding("UTF-8");
      return thymeleafViewResolver;
    }
}