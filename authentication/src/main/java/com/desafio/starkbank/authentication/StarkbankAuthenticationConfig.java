package com.desafio.starkbank.authentication;

import com.starkbank.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StarkbankAuthenticationConfig
{
    @Value("${starkbank.environment:sandbox}")
    private String environment;

    @Value("${starkbank.project-id}")
    private String projectId;

    @Value("${starkbank.private-key}")
    private String privateKeyPem;

    @PostConstruct
    public void init() throws Exception {
        Settings.user = new Project(environment, projectId, privateKeyPem);
    }
}
