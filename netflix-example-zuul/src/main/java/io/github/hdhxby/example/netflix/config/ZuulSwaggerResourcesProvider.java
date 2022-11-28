package io.github.hdhxby.example.netflix.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

//@Primary
//@Component
public class ZuulSwaggerResourcesProvider implements SwaggerResourcesProvider {

    private DiscoveryClient discoveryClient;



    public ZuulSwaggerResourcesProvider(final DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public List<SwaggerResource> get() {
        discoveryClient.getServices().stream()
                .map(service -> {
                    SwaggerResource swaggerResource = new SwaggerResource();
                    swaggerResource.setName(service);
                    swaggerResource.setUrl("http://"+service+"/v3/api-docs");
                    swaggerResource.setSwaggerVersion("3.0.3");
                    return swaggerResource;
                }).collect(Collectors.toList());
        return null;
    }
}
