package main

import (
	"fmt"
)

const (
	spanish = "spanish"
	french  = "french"

	helloPrefix        = "hello "
	spanishHelloPrefix = "hola "
	frenchHelloPrefix  = "bonjour "
)

func hello(name, language string) string {
	if name == "" {
		name = "world!"
	}

	return greetingPrefix(language) + name
}

func greetingPrefix(language string) (prefix string) {
	switch language {
	case spanish:
		prefix = spanishHelloPrefix
	case french:
		prefix = frenchHelloPrefix
	default:
		prefix = helloPrefix
	}
	return
}

func main() {
	fmt.Println(hello("sai", "spanish"))
}
