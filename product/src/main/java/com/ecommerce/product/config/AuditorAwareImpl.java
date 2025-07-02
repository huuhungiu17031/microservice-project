package com.ecommerce.product.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // If using Spring Security, return
        // SecurityContextHolder.getContext().getAuthentication().getName()
        return Optional.of("system-user"); // or dynamically get from security/user context
    }
}