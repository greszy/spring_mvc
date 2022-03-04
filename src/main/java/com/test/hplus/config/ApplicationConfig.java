package com.test.hplus.config;

import com.test.hplus.convertors.StringToEnumConvertor;
import com.test.hplus.interceptors.LoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
@ComponentScan(basePackages = "com.test.hplus")
public class ApplicationConfig extends WebMvcConfigurationSupport {

    /*
    This method helps us to tell Spring MVC that whenever you are picking static files like css or images, you have to pick them up from a particular path.
    It makes sure the static resources are mapped correctly.
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**", "images/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/");
    }
    /*
    InternalResourceViewResolver is commonly used for resolving jsp files.
     The jspViewResolver method makes sure that the jsp templates are picked up from the correct folders.
     */
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setOrder(2);
        return viewResolver;
    }

    //The FormatterRegistry parameter will allow us to register any custom convertors.
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConvertor());
    }

    //Here async processing is configured.
    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(5000);
        configurer.setTaskExecutor(mvcTaskExecutor());
    }

    @Bean
    public AsyncTaskExecutor mvcTaskExecutor() {
        //Instance of ThreadPoolTaskExecutor allows the configuration of the thread pool that is used in the application.
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //Sets the name of each thread.
        threadPoolTaskExecutor.setThreadNamePrefix("hplusapp-thread-");
        return threadPoolTaskExecutor;
    }

    @Bean
    public XmlViewResolver xmlViewResolver() {
        XmlViewResolver viewResolver = new XmlViewResolver();
        //We have to tell the resolver about the location of the xml file.
        viewResolver.setLocation(new ClassPathResource("views.xml"));
        viewResolver.setOrder(1);
        return viewResolver;
    }

//    @Bean
//    public ResourceBundleViewResolver resourceBundleViewResolver() {
//        //This configuration means that all the views are defined in a properties file.
//        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();
//        //The base name of the properties file is "views".
//        viewResolver.setBasename("views");
//        return viewResolver;
//    }


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //Applying the addPathPatterns method means that the logging interceptor has to apply for every utl pattern of the application.
        registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/*");

    }
}
