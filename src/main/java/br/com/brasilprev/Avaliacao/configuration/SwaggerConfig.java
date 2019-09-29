package br.com.brasilprev.Avaliacao.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2

public class SwaggerConfig {
	/**
	 * @Value("${context.api.dns}") private String authLink;
	 *
	 * @Value("${app.client.id}") private String
	 * clientId; @Value("${app.client.secret}") private String
	 * clientSecret; @Value("${info.build.name}") private String infoBuildName;
	 **/
	
	@Value("${config.oauth2.accessTokenUri}")
	private String accessTokenUri;
	
	@Bean
	public Docket api() {

		List<ResponseMessage> list = new java.util.ArrayList<>();
		list.add(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Result")).build());
		list.add(new ResponseMessageBuilder().code(401).message("Unauthorized").responseModel(new ModelRef("Result")).build());
		list.add(new ResponseMessageBuilder().code(406).message("Not Acceptable").responseModel(new ModelRef("Result")).build());
		// return new
		// Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().securitySchemes(Collections.singletonList(securitySchema())).securityContexts(Collections.singletonList(securityContext())).pathMapping("/")
		// .useDefaultResponseMessages(false).apiInfo(apiInfo()).globalResponseMessage(RequestMethod.GET,
		// list).globalResponseMessage(RequestMethod.POST, list);
		//
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().securityContexts(Collections.singletonList(securityContext())).securitySchemes(Arrays.asList(securitySchema(), apiKey(), apiCookieKey())).apiInfo(apiInfo());

	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.ant("/brasilPrevContextPatternSecured/**")).build();
	}

	@Bean
	public SecurityScheme apiKey() {
		return new ApiKey(HttpHeaders.AUTHORIZATION, "apiChaves", "header");
	}

	@Bean
	public SecurityScheme apiCookieKey() {
		return new ApiKey(HttpHeaders.COOKIE, "apiChaves", "cookie");
	}
	
	private List<SecurityReference> defaultAuth() {
		
		final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
		authorizationScopes[0] = new AuthorizationScope("read", "read all");
		authorizationScopes[1] = new AuthorizationScope("read write", "write all");
		authorizationScopes[2] = new AuthorizationScope("read write", "write all");
		
		return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));
	}
	
	@Bean
	public SecurityConfiguration securityInfo() {

		return new SecurityConfiguration("brasilprev_user_all_permission", "admin1234", "", "", "Bearer access token", ApiKeyVehicle.HEADER, HttpHeaders.AUTHORIZATION, "");
		
	}

	private OAuth securitySchema() {
		
		List<AuthorizationScope> authorizationScopeList = new ArrayList();
		authorizationScopeList.add(new AuthorizationScope("read", "read all"));
		authorizationScopeList.add(new AuthorizationScope("read write", "trust all"));
		authorizationScopeList.add(new AuthorizationScope("read write", "access all"));
		
		List<GrantType> grantTypes = new ArrayList();
		GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant(accessTokenUri);
		
		grantTypes.add(creGrant);
		
		return new OAuth("oauth2schema", authorizationScopeList, grantTypes);
		
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API Teste Brasil Prev").description("").termsOfServiceUrl("https://www.exemploBrasilPrevatividade.com/api").contact(new Contact("Diego", "http://www.brasilprev.com", "dpitaprivate@gmail.com")).license("Open Source").licenseUrl("https://www.none.com")
				.version("1.0.0").build();
	}
}