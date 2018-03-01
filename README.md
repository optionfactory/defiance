# Defiance

Replace ```@EnableWebMvc``` annotation with ```@EnableWebMvcWithDirectFieldAccess``` to activate direct field access in Spring WebDataBinder. 

This allows binding between requests and DTOs with public fields and without getters and setters.

NOTE: do not use both ```@EnableWebMvc``` and ```@EnableWebMvcWithDirectFieldAccess``` on the same context. 

## Example

```java

@Configuration
//@EnableWebMcv
@EnableWebMvcWithDirectFieldAccess
public class ApiConfig extends WebMvcConfigurerAdapter {

    // configuration

}

public class WebApp implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws ServletException {

        final AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(MainConfig.class);
        sc.addListener(new ContextLoaderListener(rootContext));

        final AnnotationConfigWebApplicationContext apiContext = new AnnotationConfigWebApplicationContext();
        apiContext.setParent(rootContext);
        apiContext.setDisplayName("apiContext");
        apiContext.register(ApiConfig.class);
        final ServletRegistration.Dynamic api = sc.addServlet("api", new DispatcherServlet(apiContext));
        api.setLoadOnStartup(1);
        api.addMapping(... mappings ...);
    }
}

```

## Maven artifact
```xml
<dependency>
  <groupId>net.optionfactory</groupId>
  <artifactId>defiance</artifactId>
  <version>1.0</version>
</dependency>
```