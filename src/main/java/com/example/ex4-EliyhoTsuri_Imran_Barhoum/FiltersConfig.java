package com.example.ex4;
import com.example.ex4.filters.ChatFilter;
import com.example.ex4.filters.LoggingInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FiltersConfig implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // if you want to apply filter only for REST controller: change the "/**" pattern
        registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
    }
    @Bean
    public FilterRegistrationBean FilterRegistration()
    {
        FilterRegistrationBean  registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ChatFilter());
        registrationBean.addUrlPatterns("/Chat/*");
        return registrationBean;
    }
}