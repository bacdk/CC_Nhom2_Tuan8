package com.hellokoding.springboot;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
    @Value("${spring.view.prefix}")
    private String prefix = "";
	@Value("${spring.view.suffix}")
	    private String suffix = "";
	@Value("${spring.view.view-names}")
    private String viewNames = "";
	@Bean
	    InternalResourceViewResolver jspViewResolver() {
	        final InternalResourceViewResolver vr = new InternalResourceViewResolver();
	        vr.setPrefix(prefix);
	
	        vr.setSuffix(suffix);
	
	        vr.setViewClass(JstlView.class);
	
	        vr.setViewNames(viewNames);
	
	        return vr;
	
	    }
}

