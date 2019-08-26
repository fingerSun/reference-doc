package swaggerdemo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger配置类
 *
 * @author 韩通
 * @since 2019-06-28
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select()
                //要扫描的API(Controller)基础包
                .apis(RequestHandlerSelectors.basePackage("swaggerdemo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建API基本信息
     *
     * @author 韩通
     * @since 2019-06-28
     */
    private ApiInfo buildApiInfo() {

        return new ApiInfoBuilder()
                .title("业务系统<>API文档")
                .description("这里除了查看接口功能外，还提供了调试测试功能")
                .contact("韩通")
                .version("1.0")
                .build();

    }
}
