#include <iostream>

using namespace std;

int main(int argc, char const *argv[]) {
    int n;
    cin >> n;

    long res = 1;

    for (int i = 1; i <= n; i++) {
        res *= i;
    }

    cout << res;

    return 0;
}