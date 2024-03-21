// @Since 2024-03-21.
// @Author Fury, All rights Reserved.

package validator

import "regexp"

// IsValidHttpURL HTTP(S) URL
// Validate is the value a valid phone number
func IsValidHttpURL(value string, allowBlank bool) bool {
	if isBlank(value) {
		return allowBlank
	}

	return regexp.MustCompile(constHttpUrlRegStr).MatchString(value)
}
