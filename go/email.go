// @Since 2024-03-21.
// @Author Fury, All rights Reserved.

package validator

// IsValidEmail 电子邮件
// Validate is the value a valid email
func IsValidEmail(value string, allowBlank bool) bool {
	if isBlank(value) {
		return allowBlank
	}

	return true
}
