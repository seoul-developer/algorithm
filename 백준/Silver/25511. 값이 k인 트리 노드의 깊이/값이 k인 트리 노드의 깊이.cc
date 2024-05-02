#include <bits/stdc++.h>

using namespace std;
#define fastio ios::sync_with_stdio(false), cin.tie(NULL)
#define endl "\n"
typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
const ll mod = 1e9 + 7;

struct node {
    int parent = 0;
    vector<int> children;
};
int main() {
    fastio;
    int n, k;
    cin >> n >> k;
    vector<node> tree(n);
    for(int i = 0; i < n-1; i++){
        int p, c;
        cin >> p >> c;
        tree[c].parent = p;
        tree[p].children.push_back(c);
    }

    for(int i = 0; i < n; i++){
        int tmp;
        cin >> tmp;
        if(tmp == k){
            int ans = 0;
            while(i != 0){
                i = tree[i].parent;
                ans++;
            }
            cout << ans;
            break;
        }
    }
    return 0;
}