package iteration

import "strings"

// Repeat a string said times
func Repeat(character string, repeatCount int) string {
	var repeated strings.Builder

	for range repeatCount {
		repeated.WriteString(character)
	}
	return repeated.String()
}
