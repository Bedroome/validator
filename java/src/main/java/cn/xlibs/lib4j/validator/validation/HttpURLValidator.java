package cn.xlibs.lib4j.validator.validation;

import cn.xlibs.lib4j.validator.XlibsValidator;
import cn.xlibs.lib4j.validator.annotation.HttpURL;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidatorContext;


/**
 * HTTP(S) URL字符串
 * Http or Https URL Validator
 *
 * @author Fury
 * @since 2024-03-21
 * <p>
 * All rights Reserved.
 */
public class HttpURLValidator extends BaseValidator<HttpURL, String> {
    @Override
    public void initialize(HttpURL ann) {
        initialize(ann.required());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if (StringUtils.isBlank(value)) {
            return notRequired();
        }

        return XlibsValidator.HttpURL.matches(value);
    }
}
