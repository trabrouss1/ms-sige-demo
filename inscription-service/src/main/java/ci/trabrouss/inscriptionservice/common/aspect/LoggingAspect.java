package ci.trabrouss.inscriptionservice.common.aspect;

import ci.trabrouss.inscriptionservice.common.utils.Utils;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
@Order(2)  // Ensure this aspect runs before others
public class LoggingAspect {

    private static final ThreadLocal<String> currentLogId = new ThreadLocal<>();
    private final Tracer tracer;  // Injecting the Tracer from Spring Cloud Sleuth

    @Around("@within(org.springframework.web.bind.annotation.RestController)")
    public Object logControllerMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> declaringType = signature.getDeclaringType();
        Logger logger = LoggerFactory.getLogger(declaringType);

        String className = declaringType.getSimpleName();
        String methodName = signature.getName();
        String requestMappingPath = Utils.getRequestMappingPath(declaringType, signature.getMethod().getAnnotation(RequestMapping.class));
        String logId = Utils.generateLogId();
        String traceId = Objects.requireNonNull(tracer.currentSpan()).context().traceId();
        String spanId = Objects.requireNonNull(tracer.currentSpan()).context().spanId();

        currentLogId.set(logId);

        logger.info("[START][{}][{}][{}][{}-{}]", className, methodName, requestMappingPath, traceId, spanId);

        try {

            Object result = joinPoint.proceed();
            long executionTime = System.currentTimeMillis() - start;
            System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
            logger.info("[END][{}][{}][{}][{}-{}]", className, methodName, requestMappingPath, traceId, spanId);
            return result;
        } catch (Throwable throwable) {
            logger.error("[ERROR][{}][{}][{}][{}-{}]] Exception: {}", className, methodName, requestMappingPath, traceId,spanId, throwable.getMessage());
            throw throwable;
        } finally {
            currentLogId.remove();
        }
    }

    public static String getCurrentLogId() {
        return currentLogId.get();
    }
}
