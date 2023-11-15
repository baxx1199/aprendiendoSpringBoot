package com.baxxy.springboot.form.app.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = IdRegexValidator.class)
@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdRegex {

	String message() default "El codigo de identificacion no coincde (ej:00.000.000-B)";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
