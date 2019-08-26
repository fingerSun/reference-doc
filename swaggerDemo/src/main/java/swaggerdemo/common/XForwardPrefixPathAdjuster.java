package swaggerdemo.common;
//
//import org.springframework.core.SpringVersion;
//import springfox.documentation.service.PathAdjuster;
//
//import javax.servlet.http.HttpServletRequest;
//
//import static springfox.documentation.swagger.common.SpringVersionCapability.supportsXForwardPrefixHeader;
//
//
//public class XForwardPrefixPathAdjuster implements PathAdjuster {
//    static final String X_FORWARDED_PREFIX = "X-Forwarded-Prefix";
//
//    private final HttpServletRequest request;
//    private final SpringVersion springVersion;
//
//    public XForwardPrefixPathAdjuster(HttpServletRequest request) {
//        this(request, new SpringVersion());
//    }
//
//    XForwardPrefixPathAdjuster(HttpServletRequest request, SpringVersion springVersion) {
//        this.request = request;
//        this.springVersion = springVersion;
//    }
//
//    @Override
//    public String adjustedPath(String path) {
//        String prefix = request.getHeader(X_FORWARDED_PREFIX);
//        if (prefix != null) {
//            if (!supportsXForwardPrefixHeader(springVersion.getVersion())) {
//                return prefix + path;
//            } else {
//                return prefix;
//            }
//        } else {
//            return path;
//        }
//    }
//}
