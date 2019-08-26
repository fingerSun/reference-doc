package swaggerdemo.swagger2;//package com.zjft.swaggerdemo.swagger2;
//
//import io.swagger.annotations.ApiModel;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import springfox.documentation.schema.DefaultTypeNameProvider;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.swagger.common.SwaggerPluginSupport;
//
//import java.util.function.Predicate;
//
//import static java.util.Optional.*;
//import static org.springframework.core.annotation.AnnotationUtils.*;
//
//@Component
//@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
//public class ApiModelTypeNameProvider extends DefaultTypeNameProvider {
//    @Override
//    public String nameFor(Class<?> type) {
//        ApiModel annotation = findAnnotation(type, ApiModel.class);
//        String defaultTypeName = super.nameFor(type);
//        if (annotation != null) {
//            return ofNullable(annotation.value())
//                    .filter(((Predicate<String>) String::isEmpty).negate())
//                    .orElse(defaultTypeName);
//        }
//        return defaultTypeName;
//    }
//
//    @Override
//    public boolean supports(DocumentationType delimiter) {
//        return SwaggerPluginSupport.pluginDoesApply(delimiter);
//    }
//}
