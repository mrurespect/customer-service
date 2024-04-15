package fsts.mrurespect.springcloudgateway.configuration;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    //static config
  // @Bean
  // RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
  //     return builder.routes()
  //
  //             .route(r->r.path("/customers/**").uri("http://localhost:8081/"))
  //             .route(r->r.path("/products/**").uri("http://localhost:8082/"))
  //             .build();
  //
  // }

   // Static routes configuration with Discovery Service
   //@Bean
   //RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
   //    return builder.routes()
   //            .route(r->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))       //lb: load balancing
   //            .route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE"))       //nom du service en majuscule
   //            .build();
   // // on est pas sence de savoir l'adresse ip de chaque service, on utilise le nom du service
   //}

    //Dynamic routes configuration with Discovery Service
    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
                                                        DiscoveryLocatorProperties dlp){

        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);

    }
}
