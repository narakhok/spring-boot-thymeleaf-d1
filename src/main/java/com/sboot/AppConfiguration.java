package com.sboot;

import java.util.Locale;

import org.codehaus.groovy.tools.shell.util.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {

		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		//slr.setDefaultLocale(Locale.FRANCE);
		//For Khmer
		slr.setDefaultLocale(new Locale("kh"));
		return slr;
	}
	
	//Change defual config properties
	@Bean
	public ResourceBundleMessageSource messageSource(){

		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("i18n/messages");
		ms.setDefaultEncoding("utf-8");
		return ms;
	}
}
