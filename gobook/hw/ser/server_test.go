package ser

import (
	"context"
	"net/http"
	"net/http/httptest"
	"testing"
	"time"
)

type SpyStore struct {
	res       string
	cancelled bool
}

func (s *SpyStore) Fetch() string {
	time.After(100 * time.Millisecond)
	return s.res
}

func (s *SpyStore) Cancel() {
	s.cancelled = true
}

func TestServer(t *testing.T) {
	t.Run("returns data from store", func(t *testing.T) {
		data := "hello, world"
		store := &SpyStore{res: data}
		svr := Server(store)

		request := httptest.NewRequest(http.MethodGet, "/", nil)
		response := httptest.NewRecorder()

		svr.ServeHTTP(response, request)

		if response.Body.String() != data {
			t.Errorf(`got "%s", want "%s"`, response.Body.String(), data)
		}

		if store.cancelled {
			t.Error("it should not have cancelled the store")
		}
	})
	t.Run("tells store to cancel request if its cancelled", func(t *testing.T) {
		data := "hello world"
		store := &SpyStore{res: data}
		svr := Server(store)

		req := httptest.NewRequest(http.MethodGet, "/", nil)

		cancellingCtx, cancel := context.WithCancel(req.Context())
		time.AfterFunc(5*time.Millisecond, cancel)
		req = req.WithContext(cancellingCtx)

		res := httptest.NewRecorder()

		svr.ServeHTTP(res, req)

		if !store.cancelled {
			t.Errorf("store was not told to cancel")
		}
	})
}
