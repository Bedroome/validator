package cn.xlibs.lib4j.validator.annotation;

import cn.xlibs.lib4j.validator.support.PhoneType;
import cn.xlibs.lib4j.validator.validation.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 手机号码
 * PhoneNumber Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
    boolean required() default true;

    PhoneType[] type() default { PhoneType.BASIC, PhoneType.VIRTUAL, PhoneType.NET_ONLY };

    String message() default "手机号码格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
