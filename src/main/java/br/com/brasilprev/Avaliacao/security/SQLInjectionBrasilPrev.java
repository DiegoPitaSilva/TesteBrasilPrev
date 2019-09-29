package br.com.brasilprev.Avaliacao.security;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Documented
@Constraint(validatedBy = SQLInjectionSafeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInjectionBrasilPrev {
	String message() default "{SQLInjectionBrasilPrev}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}