package swaggerdemo.common;

import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UrlPathHelper;
import springfox.documentation.swagger.common.XForwardPrefixPathAdjuster;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.util.StringUtils.hasText;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromContextPath;

public class HostNameProvider {

    private HostNameProvider() {
        throw new UnsupportedOperationException();
    }

    public static UriComponents componentsFrom(
            HttpServletRequest request,
            String basePath) {

        ServletUriComponentsBuilder builder = fromServletMapping(request, basePath);

        UriComponents components = UriComponentsBuilder.fromHttpRequest(
                new ServletServerHttpRequest(request))
                .build();

        String host = components.getHost();
        if (!hasText(host)) {
            return builder.build();
        }

        builder.host(host);
        builder.port(components.getPort());
        builder.scheme(components.getScheme());
        return builder.build();
    }

    private static ServletUriComponentsBuilder fromServletMapping(
            HttpServletRequest request,
            String basePath) {

        ServletUriComponentsBuilder builder = fromContextPath(request);

        XForwardPrefixPathAdjuster adjuster = new XForwardPrefixPathAdjuster(request);
        builder.replacePath(adjuster.adjustedPath(basePath));
        if (hasText(new UrlPathHelper().getPathWithinServletMapping(request))) {
            builder.path(request.getServletPath());
        }

        return builder;
    }
}
