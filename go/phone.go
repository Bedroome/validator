// @Since 2024-03-21.
// @Author Fury, All rights Reserved.

package validator

// IsValidPhone 手机号码
// Validate is the value a valid phone number
func IsValidPhone(value string, allowBlank bool) bool {
	if isBlank(value) {
		return allowBlank
	}

	return true
}
