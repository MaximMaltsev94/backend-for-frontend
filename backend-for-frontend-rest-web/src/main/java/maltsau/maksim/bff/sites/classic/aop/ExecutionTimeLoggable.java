package maltsau.maksim.bff.sites.classic.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for logging execution time to http response header.
 * <p>
 * <p> Copyright &copy; 2021 Edmunds.com
 * Date: 11/12/2021
 *
 * @author Maksim Maltsau
 */
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecutionTimeLoggable {
}
