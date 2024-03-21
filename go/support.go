// @Since 2024-03-21.
// @Author Fury, All rights Reserved.

package validator

import (
	"regexp"
	"strings"
)

const constBankCardRegStr string = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b"
const constAlphaNumberRegStr string = "^[a-zA-Z][a-zA-Z0-9]*$"
// https://github.com/VincentSit/ChinaMobilePhoneNumberRegex/blob/master/README-CN.md
const constPhoneTypeBasicRegStr string = "^(?:\\+?86)?1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[235-8]\\d{2}|4(?:0\\d|1[0-2]|9\\d))|9[0-35-9]\\d{2}|66\\d{2})\\d{6}$"
const constPhoneTypeVirtualRegStr string = "^(?:\\+?86)?1(?:7[01]|6[257])\\d{8}$"
const constPhoneTypeNetOnlyRegStr string = "^(?:\\+?86)?14[579]\\d{8}$"
const constPhoneTypeIotOnlyRegStr string = "^(?:\\+?86)?14(?:[14]0|41|[68]\\d)\\d{9}$"
const constPhoneTypeAllTypeRegStr string = "^(?:\\+?86)?1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[0-35-9]\\d{2}|4(?:0\\d|1[0-2]|9\\d))|9[0-35-9]\\d{2}|6[2567]\\d{2}|4(?:(?:10|4[01])\\d{3}|[68]\\d{4}|[579]\\d{2}))\\d{6}$"
// HttpUrlRegStr (?i) 定义了不区分大小写
const constHttpUrlRegStr string ="(?i)^https?://(?:www\\.)?[\\w.-]+\\.[a-zA-Z]{2,}(?:/\\S*)?$"

type PhoneType int

const (
	// Basic 11位手机卡-基础运营商,支持语音通话/短信/数据流量
	Basic = iota
	// Virtual 11位手机卡-虚拟运营商,支持语音通话/短信/数据流量
	Virtual
	// NetOnly 11位上网卡,支持语音通话(部分)/短信/数据流量
	NetOnly
	// IotOnly 13位物联网数据卡,支持数据流量
	IotOnly
)

func getRegexp(phoneType PhoneType) *regexp.Regexp {
	switch phoneType {
	case Basic:
		return regexp.MustCompile(PhoneTypeBasicRegStr)
	case Virtual:
		return regexp.MustCompile(PhoneTypeVirtualRegStr)
	case NetOnly:
		return regexp.MustCompile(PhoneTypeNetOnlyRegStr)
	case IotOnly:
		return regexp.MustCompile(PhoneTypeIotOnlyRegStr)
	default: // all type, 11或13位,支持所有号码
		return regexp.MustCompile(PhoneTypeAllTypeRegStr)
	}
}


// check if the input string is blank
func isBlank(value string) bool {
	return len(strings.TrimSpace(value)) == 0
}
