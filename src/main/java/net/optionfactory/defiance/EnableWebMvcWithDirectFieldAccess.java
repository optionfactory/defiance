package net.optionfactory.defiance;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

/**
 * This annotation replaces @EnableWebMvc. Use this annotation to enable access
 * to public fields when binding request data to DTOs
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value = DirectFieldAccessConfiguration.class)
public @interface EnableWebMvcWithDirectFieldAccess {

}
