package cn.xlibs.lib4j.validator.validation;

import cn.xlibs.lib4j.validator.XlibsValidator;
import cn.xlibs.lib4j.validator.annotation.Email;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;

/**
 * 电子邮件
 * Email Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public class EmailValidator extends BaseValidator<Email, String> {
    @Override
    public void initialize(Email ann) {
        initialize(ann.required());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if (StringUtils.isBlank(value)) {
            return notRequired();
        }

        return XlibsValidator.Email.matches(value);
    }
}
