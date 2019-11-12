package com.jersey.mavendemo;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        //my resources
        resources.add(com.jersey.mavendemo.http.CallResource.class);

        // swagger resources
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        swaggerConfiguration();

        return resources;
    }

    private void swaggerConfiguration() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8888");
        beanConfig.setBasePath("/mavendemo/rest");
        beanConfig.setResourcePackage("com.jersey.mavendemo");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
        beanConfig.setTitle("Jersey Swagger Demo");
        beanConfig.setVersion("1.0");
        beanConfig.setLicense("Apache License Version 2.0");
        beanConfig.setLicenseUrl("https://www.apache.org/licenses/LICENSE-2.0");
    }

}
