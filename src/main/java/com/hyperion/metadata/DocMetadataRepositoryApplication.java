package com.hyperion.metadata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DocMetadataRepositoryApplication {

	public static void main(String[] args) {
			SpringApplication.run(DocMetadataRepositoryApplication.class, args);
	}

	@Bean
	public Docket swaggerSettings(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/");
	}

	@Bean
	CommandLineRunner init(){
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				System.out.println("inside init...>>>>"+strings);
			}
		};
	}
}
