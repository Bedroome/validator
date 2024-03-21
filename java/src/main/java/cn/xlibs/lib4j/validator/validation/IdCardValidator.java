package cn.xlibs.lib4j.validator.validation;

import cn.xlibs.lib4j.validator.XlibsValidator;
import cn.xlibs.lib4j.validator.annotation.IdCard;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;

/**
 * 身份证号码
 * ID Card Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public class IdCardValidator extends BaseValidator<IdCard, String> {
    @Override
    public void initialize(IdCard ann) {
        initialize(ann.required());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if (StringUtils.isBlank(value)) {
            return notRequired();
        }

        return XlibsValidator.IdCard.matches(value);
    }
}
