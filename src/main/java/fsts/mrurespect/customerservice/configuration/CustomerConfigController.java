package fsts.mrurespect.customerservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class CustomerConfigController {
    @Value("${env.name}")
    private String p1;
    @Value("${spring.datasource.username}")
    private String p2;
    @Value("${global.params.owner}")
    private String p3;
    @GetMapping("/params")
    Map<String, String> getParams() {
        return Map.of("environment name", p1, "username", p2, "owner", p3);
    }
}
