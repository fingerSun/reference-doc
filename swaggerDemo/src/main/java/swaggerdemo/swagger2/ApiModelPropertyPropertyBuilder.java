package swaggerdemo.swagger2;//package com.zjft.swaggerdemo.swagger2;
//
//
//import com.zjft.swaggerdemo.common.SwaggerPluginSupport;
//import io.swagger.annotations.ApiModelProperty;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
//import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
//import springfox.documentation.spring.web.DescriptionResolver;
//
//import java.util.Optional;
//
//import static com.zjft.swaggerdemo.swagger2.ApiModelProperties.*;
//import static java.util.Optional.empty;
//import static springfox.documentation.schema.Annotations.findPropertyAnnotation;
//
//@Component
//@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
//public class ApiModelPropertyPropertyBuilder implements ModelPropertyBuilderPlugin {
//    private final DescriptionResolver descriptions;
//
//    @Autowired
//    public ApiModelPropertyPropertyBuilder(DescriptionResolver descriptions) {
//        this.descriptions = descriptions;
//    }
//
//    @Override
//    public void apply(ModelPropertyContext context) {
//        Optional<ApiModelProperty> annotation = empty();
//
//        if (context.getAnnotatedElement().isPresent()) {
//            annotation =
//                    annotation.map(Optional::of).orElse(findApiModePropertyAnnotation(context.getAnnotatedElement().get()));
////                            .orElse(findApiModePropertyAnnotation(context.getAnnotatedElement().get()));
//        }
//        if (context.getBeanPropertyDefinition().isPresent()) {
//            annotation = annotation.map(Optional::of).orElse(findPropertyAnnotation(
//                    context.getBeanPropertyDefinition().get(),
//                    ApiModelProperty.class));
//        }
//        if (annotation.isPresent()) {
//            context.getBuilder()
//                    .allowableValues(annotation.map(toAllowableValues()).orElse(null))
//                    .required(annotation.map(ApiModelProperty::required).orElse(false))
//                    .readOnly(annotation.map(ApiModelProperty::readOnly).orElse(false))
//                    .description(annotation.map(toDescription(descriptions)).orElse(null))
//                    .isHidden(annotation.map(ApiModelProperty::hidden).orElse(false))
//                    .type(annotation.map(toType(context.getResolver())).orElse(null))
//                    .position(annotation.map(ApiModelProperty::position).orElse(0))
//                    .example(annotation.map(toExample()).orElse(null));
//        }
//    }
//
//    @Override
//    public boolean supports(DocumentationType delimiter) {
//        return SwaggerPluginSupport.pluginDoesApply(delimiter);
//    }
//}
