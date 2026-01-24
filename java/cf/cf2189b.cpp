#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int T; cin >> T;
    while (T--) {
        ll n, x;
        cin >> n >> x;
        ll r = 0, m = -1e9, a, b, c;
        for (int i = 0; i < n; i++) {
            cin >> a >> b >> c;
            r += a*(b-1);
            m = max(m, a*b-c);
        }
        if (r >= x) cout << 0 << "\n";
        else if (m <= 0) cout << -1 << "\n";
        else cout << (x-r+m-1)/m << "\n";
    }

    return 0;
}
