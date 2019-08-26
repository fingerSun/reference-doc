package swaggerdemo.common;

import org.springframework.core.Ordered;
import springfox.documentation.spi.DocumentationType;

public class SwaggerPluginSupport {
    private SwaggerPluginSupport() {
        throw new UnsupportedOperationException();
    }

    public static final int SWAGGER_PLUGIN_ORDER = Ordered.HIGHEST_PRECEDENCE + 1000;
    public static boolean pluginDoesApply(DocumentationType documentationType) {
        return DocumentationType.SWAGGER_12.equals(documentationType)
                || DocumentationType.SWAGGER_2.equals(documentationType);
    }
}
