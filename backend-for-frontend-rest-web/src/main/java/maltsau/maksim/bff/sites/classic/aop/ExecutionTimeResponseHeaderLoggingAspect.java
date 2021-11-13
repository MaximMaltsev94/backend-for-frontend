package maltsau.maksim.bff.sites.classic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;


/**
 * Execution time logging aspect.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/12/2021
 *
 * @author Maksim Maltsau
 */
@Aspect
@Component
public class ExecutionTimeResponseHeaderLoggingAspect {

    private static final String PROCESSING_START_HEADER = "bff-java-processing-start";
    private static final String PROCESSING_END_HEADER = "bff-java-processing-end";
    private static final String PROCESSING_RESPONSE_TIME_HEADER = "bff-java-processing-response-time";


    @Pointcut("@annotation(ExecutionTimeLoggable)")
    public void loggableMethod() {

    }

    @Pointcut("@within(ExecutionTimeLoggable)")
    public void loggableClass() {

    }

    @Around("loggableClass() || loggableMethod()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletResponse servletResponse = getHttpServletResponseArg();
        long start = System.currentTimeMillis();

        if (servletResponse != null) {
            servletResponse.addHeader(PROCESSING_START_HEADER, String.valueOf(start));
        }

        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            if (servletResponse != null) {
                servletResponse.addHeader(PROCESSING_END_HEADER, String.valueOf(end));
                servletResponse.addHeader(PROCESSING_RESPONSE_TIME_HEADER, String.valueOf(end - start));
            }
            System.out.println("execution time: " + (end - start));
        }
    }

    private HttpServletResponse getHttpServletResponseArg() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes instanceof ServletRequestAttributes) {
            return ((ServletRequestAttributes) requestAttributes).getResponse();
        }
        return null;
    }


}
