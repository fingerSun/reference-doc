package swaggerdemo.common;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import static java.util.Optional.*;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
import static org.springframework.core.annotation.AnnotationUtils.getAnnotation;

public class Annotations {

    private Annotations() {
        throw new UnsupportedOperationException();
    }

    public static Optional<ApiParam> findApiParamAnnotation(AnnotatedElement annotated) {
        return ofNullable(getAnnotation(annotated, ApiParam.class));
    }

    public static List<ApiResponses> findApiResponsesAnnotations(AnnotatedElement annotated) {
        List<ApiResponses> results = new ArrayList<>();
        ApiResponses currentLevel = getAnnotation(annotated, ApiResponses.class);
        if (currentLevel != null) {
            results.add(currentLevel);
        }
        if (annotated instanceof Method) {
            ApiResponses parentLevel = findAnnotation(((Method) annotated).getDeclaringClass(), ApiResponses.class);
            if (parentLevel != null) {
                results.add(parentLevel);
            }
        }
        return results;
    }

    public static Function<ApiOperation, ResolvedType> resolvedTypeFromOperation(
            final TypeResolver typeResolver,
            final ResolvedType defaultType) {

        return annotation -> getResolvedType(annotation, typeResolver, defaultType);
    }

    public static Function<ApiResponse, ResolvedType> resolvedTypeFromResponse(
            final TypeResolver typeResolver,
            final ResolvedType defaultType) {

        return annotation -> getResolvedType(annotation, typeResolver, defaultType);
    }

    @SuppressWarnings("Duplicates")
    static ResolvedType getResolvedType(
            ApiOperation annotation,
            TypeResolver resolver,
            ResolvedType defaultType) {

        if (null != annotation) {
            Class<?> response = annotation.response();
            String responseContainer = annotation.responseContainer();
            if (resolvedType(resolver, response, responseContainer).isPresent()) {
                return resolvedType(resolver, response, responseContainer).get();
            }
        }
        return defaultType;
    }

    @SuppressWarnings("Duplicates")
    static ResolvedType getResolvedType(
            ApiResponse annotation,
            TypeResolver resolver,
            ResolvedType defaultType) {

        if (null != annotation) {
            Class<?> response = annotation.response();
            String responseContainer = annotation.responseContainer();
            if (resolvedType(resolver, response, responseContainer).isPresent()) {
                return resolvedType(resolver, response, responseContainer).get();
            }
        }
        return defaultType;
    }

    private static Optional<ResolvedType> resolvedType(
            TypeResolver resolver,
            Class<?> response,
            String responseContainer) {
        if (isNotVoid(response)) {
            if ("List".compareToIgnoreCase(responseContainer) == 0) {
                return of(resolver.resolve(List.class, response));
            } else if ("Set".compareToIgnoreCase(responseContainer) == 0) {
                return of(resolver.resolve(Set.class, response));
            } else {
                return of(resolver.resolve(response));
            }
        }
        return empty();
    }

    private static boolean isNotVoid(Class<?> response) {
        return Void.class != response
                && void.class != response;
    }
}
