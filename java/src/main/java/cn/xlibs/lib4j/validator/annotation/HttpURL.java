package cn.xlibs.lib4j.validator.annotation;

import cn.xlibs.lib4j.validator.validation.AlphaNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * HTTP(S) URL字符串
 * Http or Https URL Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AlphaNumberValidator.class)
public @interface HttpURL {
    boolean required() default true;

    String message() default "URL格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
