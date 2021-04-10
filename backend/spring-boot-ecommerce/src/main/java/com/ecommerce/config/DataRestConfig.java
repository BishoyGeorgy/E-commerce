package com.ecommerce.config;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

/**
 * @author @Bishoy
 * @version 1.0
 * @date 09/04/2021
 */
@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] unSupportedMethods = new HttpMethod[] {HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT};

        config.getExposureConfiguration().forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedMethods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedMethods));

        config.getExposureConfiguration().forDomainType(Category.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedMethods))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unSupportedMethods));
    }
}
