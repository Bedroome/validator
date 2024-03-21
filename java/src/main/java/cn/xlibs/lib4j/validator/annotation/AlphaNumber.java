package cn.xlibs.lib4j.validator.annotation;

import cn.xlibs.lib4j.validator.validation.AlphaNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 字母数字标识
 * Alpha Number Validator
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
public @interface AlphaNumber {
    boolean required() default true;

    String message() default "参数格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
