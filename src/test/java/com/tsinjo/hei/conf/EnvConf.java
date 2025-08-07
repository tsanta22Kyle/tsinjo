package com.tsinjo.hei.conf;

import org.springframework.test.context.DynamicPropertyRegistry;

public class EnvConf {
    void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("env", () -> "test");
        registry.add("spring.datasource.url", () -> "jdbc:postgresql://localhost:5432/tsinjo_preprod");
        registry.add("spring.datasource.driverClassName", () -> "org.postgresql.Driver");
        registry.add("spring.jpa.database-platform", () -> "org.hibernate.dialect.PostgreSQLDialect");

        registry.add(
                "vola.api.url", () -> "https://42cwka3n4ifcp7ufheyrpmph240iuaxo.lambda-url.eu-west-3.on.aws");
        registry.add(
                "vola.api.key", () -> "the key");

    }
}
