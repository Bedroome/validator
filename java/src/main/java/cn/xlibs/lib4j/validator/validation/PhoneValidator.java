package cn.xlibs.lib4j.validator.validation;

import cn.xlibs.lib4j.validator.XlibsValidator;
import cn.xlibs.lib4j.validator.annotation.Phone;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * 手机号码
 * Phone Number Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public class PhoneValidator extends BaseValidator<Phone, String> {
    private Phone ann;

    @Override
    public void initialize(Phone ann) {
        this.ann = ann;
        initialize(ann.required());
    }

    @Override
    public boolean isValid(final String value, ConstraintValidatorContext ctx) {
        if (StringUtils.isBlank(value)) {
            return notRequired();
        }
        return Arrays.stream(this.ann.type()).allMatch(
                t -> XlibsValidator.Phone.matches(value, t));
    }
}
