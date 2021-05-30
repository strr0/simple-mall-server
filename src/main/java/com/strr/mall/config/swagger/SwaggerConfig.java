package com.strr.mall.config.swagger;

import com.fasterxml.classmate.TypeResolver;
import com.strr.mall.system.entity.Authority;
import com.strr.mall.system.entity.Role;
import com.strr.mall.system.entity.User;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .alternateTypeRules(alternateTypeRules())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("SwaggerUI")
                .description("simple-mall-server")
                .build();
    }

    /**
     * 类型转化规则 （无限递归问题）
     * @return
     */
    private AlternateTypeRule[] alternateTypeRules() {
        TypeResolver typeResolver = new TypeResolver();
        AlternateTypeRule rule1 = new AlternateTypeRule(typeResolver.resolve(User.class), typeResolver.resolve(Object.class));
        AlternateTypeRule rule2 = new AlternateTypeRule(typeResolver.resolve(Role.class), typeResolver.resolve(Object.class));
        AlternateTypeRule rule3 = new AlternateTypeRule(typeResolver.resolve(Authority.class), typeResolver.resolve(Object.class));
        return new AlternateTypeRule[] {rule1, rule2, rule3};
    }
}
