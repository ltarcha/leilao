package br.com.tcc.leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.tcc.leilao.interceptors.AuthorizerInterceptor;


@Configuration
public class WebAppInitializer extends WebMvcConfigurerAdapter   {

	@Autowired
	private AuthorizerInterceptor authorizerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authorizerInterceptor);
    }

}
