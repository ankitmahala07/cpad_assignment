package com.cpad.assignment.config;

import com.arangodb.ArangoDB;
import com.arangodb.springframework.annotation.EnableArangoRepositories;
import com.arangodb.springframework.config.ArangoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableArangoRepositories("com.cpad.assignment.repository")
public class ArangoConfig implements ArangoConfiguration {

    @Value("${arangodb.host}")
    private String host;

    @Value("${arangodb.username}")
    private String username;

    @Value("${arangodb.password}")
    private String password;

    @Value("${arangodb.port}")
    private int port;

    @Value("${arangodb.dbname}")
    private String databaseName;

    @Override
    public ArangoDB.Builder arango() {
        return new ArangoDB.Builder().host(host, port).user(username).password(password);
    }

    @Override
    public String database() {
        return databaseName;
    }

}