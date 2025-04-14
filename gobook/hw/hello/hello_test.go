package main

import "testing"

func TestHello(t *testing.T) {
	t.Run("saying hello to people", func(t *testing.T) {
		got := hello("sai", "")
		want := "hello sai"
		assertCorrectMessage(t, got, want)
	})
	t.Run("saying 'hello world' to people, when empty string is supplied", func(t *testing.T) {
		got := hello("", "")
		want := "hello world!"
		assertCorrectMessage(t, got, want)
	})
	t.Run("in spanish", func(t *testing.T) {
		got := hello("sai", "spanish")
		want := "hola sai"
		assertCorrectMessage(t, got, want)
	})
	t.Run("in french", func(t *testing.T) {
		got := hello("sai", "french")
		want := "bonjour sai"
		assertCorrectMessage(t, got, want)
	})
}

func assertCorrectMessage(t testing.TB, got, want string) {
	t.Helper()
	if got != want {
		t.Errorf("got %q want %q", got, want)
	}
}
