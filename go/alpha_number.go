// @Since 2024-03-21.
// @Author Fury, All rights Reserved.

package validator

// IsValidAlphaNumber 字母数字标识符
// Validate is the value a valid alpha number
func IsValidAlphaNumber(value string, allowBlank bool) bool {
	if isBlank(value) {
		return allowBlank
	}

	return regexp.MustCompile(constAlphaNumberRegStr).MatchString(value)
}
