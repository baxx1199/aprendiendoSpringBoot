package com.baxxy.springboot.form.app.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = RequiedValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface RequiedF {
	String message() default "Campo Requerido _ Validacion by RequiedValidator";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
