package cn.xlibs.lib4j.validator.validation;

import cn.xlibs.lib4j.validator.XlibsValidator;
import cn.xlibs.lib4j.validator.annotation.AlphaNumber;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;

/**
 * 字母数字标识
 * Alpha Number Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public class AlphaNumberValidator extends BaseValidator<AlphaNumber, String> {
    @Override
    public void initialize(AlphaNumber ann) {
        initialize(ann.required());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if (StringUtils.isBlank(value)) {
            return notRequired();
        }

        return XlibsValidator.AlphaNumber.matches(value);
    }
}
