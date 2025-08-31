package com.app.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class BootstrapApplication {

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${server.port}")
    private String SERVER_PORT;

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() throws Exception {
        var resource = new ClassPathResource(AppConstants.APPLICATION_BANNER_DOT_IO);
        String content = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        System.out.println(content);
        System.out.println("---------------------------------------------------------");
        System.out.println();
        System.out.println("    Application is running on the port: " + SERVER_PORT);
        System.out.println("    Swagger API's: ");
        System.out.println("        1] http://localhost:" + SERVER_PORT + "/swagger-ui/index.html#/");
        System.out.println("        2] http://localhost:" + SERVER_PORT + "/v3/api-docs");
        System.out.println();
        System.out.println("---------------------------------------------------------");
    }

}