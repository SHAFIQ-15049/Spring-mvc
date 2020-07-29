package com.shafiq.lc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.shafiq.lc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.shafiq.lc.controllers")
public class LoveCalculatorAppConfig implements WebMvcConfigurer{

	//set up view Resolver
	
	@Bean
	public InternalResourceViewResolver getResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
	@Bean(name="validator")
    public LocalValidatorFactoryBean validator()
    {
    	LocalValidatorFactoryBean localValidatorFactoryBean   = new LocalValidatorFactoryBean();
    	localValidatorFactoryBean.setValidationMessageSource(messageSource());
    	
    	return localValidatorFactoryBean;
    }
	
	@Override
	public Validator getValidator() {
		
		return validator();
	}
    
	
	
	
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		System.out.println("inside add Formatters methods..");
		registry.addFormatter(new PhoneNumberFormatter());
	}
	
	
}
