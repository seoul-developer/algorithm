#include <iostream>

using namespace std;

int main(int argc, char const *argv[]) {
    long n, m;
    cin >> n >> m;

    long diff = n - m;

    if (diff < 0) {
        cout << -diff;
        return 0;
    }

    cout << diff;

    return 0;
}