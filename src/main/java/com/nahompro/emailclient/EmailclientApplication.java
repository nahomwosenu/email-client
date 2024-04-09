package com.nahompro.emailclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmailclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailclientApplication.class, args);
	}


	/*@Bean
	public graphql.schema.GraphQLScalarType extendedScalarLong() {
		return graphql.scalar.GraphqlIDCoercing;
	}*/
}
