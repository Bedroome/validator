// @Since 2024-03-21.
// @Author Fury, All rights Reserved.

package validator

import "regexp"

const bankCardRegexp string = ""

// IsValidBankCard 银行卡号
// Validate is the value a valid bank card number
func IsValidBankCard(value string, allowBlank bool) bool {
	if isBlank(value) {
		return allowBlank
	}

	return regexp.MustCompile(bankCardRegexp).MatchString(value)
}
