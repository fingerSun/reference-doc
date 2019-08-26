package swaggerdemo.swagger2;//package com.zjft.swaggerdemo.swagger2;
//
//import com.fasterxml.classmate.TypeResolver;
//import io.swagger.annotations.ApiModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import springfox.documentation.schema.ModelReference;
//import springfox.documentation.schema.TypeNameExtractor;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.schema.EnumTypeDeterminer;
//import springfox.documentation.spi.schema.ModelBuilderPlugin;
//import springfox.documentation.spi.schema.contexts.ModelContext;
//import springfox.documentation.swagger.common.SwaggerPluginSupport;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.zjft.swaggerdemo.common.SwaggerPluginSupport.pluginDoesApply;
//import static springfox.documentation.schema.ResolvedTypes.modelRefFactory;
//
//@Component
//@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
//public class ApiModelBuilder implements ModelBuilderPlugin {
//    private final TypeResolver typeResolver;
//    private final TypeNameExtractor typeNameExtractor;
//    private final EnumTypeDeterminer enumTypeDeterminer;
//
//    @Autowired
//    public ApiModelBuilder(
//            TypeResolver typeResolver,
//            TypeNameExtractor typeNameExtractor,
//            EnumTypeDeterminer enumTypeDeterminer) {
//        this.typeResolver = typeResolver;
//        this.typeNameExtractor = typeNameExtractor;
//        this.enumTypeDeterminer = enumTypeDeterminer;
//    }
//
//    @Override
//    public void apply(ModelContext context) {
//        ApiModel annotation = AnnotationUtils.findAnnotation(forClass(context), ApiModel.class);
//        if (annotation != null) {
//            List<ModelReference> modelRefs = new ArrayList<ModelReference>();
//            for (Class<?> each : annotation.subTypes()) {
//                modelRefs.add(modelRefFactory(context, enumTypeDeterminer, typeNameExtractor)
//                        .apply(typeResolver.resolve(each)));
//            }
//            context.getBuilder()
//                    .description(annotation.description())
//                    .discriminator(annotation.discriminator())
//                    .subTypes(modelRefs);
//        }
//    }
//
//    private Class<?> forClass(ModelContext context) {
//        return typeResolver.resolve(context.getType()).getErasedType();
//    }
//
//
//    @Override
//    public boolean supports(DocumentationType delimiter) {
//        return pluginDoesApply(delimiter);
//    }
//}
