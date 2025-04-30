#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int T; cin >> T;
    while (T--) {
        int N, M;
        cin >> N >> M;
        string S;
        cin >> S;

        vector<vector<ll>> A(N, vector<ll>(M));
        vector<ll> rowSum(N, 0), colSum(M, 0);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j) {
                cin >> A[i][j];
                rowSum[i] += A[i][j];
                colSum[j] += A[i][j];
            }

        int x = 0, y = 0;
        for (char c : S) {
            if (c == 'D') {
                ll su = rowSum[x];
                A[x][y] = -su;
                colSum[y] -= su;
                x++;
            } else {
                ll su = colSum[y];
                A[x][y] = -su;
                rowSum[x] -= su;
                y++;
            }
        }

        ll su = 0;
        for (int i = 0; i < N; ++i)
            su += A[i][M - 1];
        A[N - 1][M - 1] = -su;

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j)
                cout << A[i][j] << " ";
            cout << '\n';
        }
    }

    return 0;
}
