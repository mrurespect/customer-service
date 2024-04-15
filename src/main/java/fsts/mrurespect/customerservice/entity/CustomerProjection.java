package fsts.mrurespect.customerservice.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Customer.class}, name = "p1")
public interface CustomerProjection {
    String getName();
    String getEmail();
}
