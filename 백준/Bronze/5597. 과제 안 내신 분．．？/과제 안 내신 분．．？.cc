#include <iostream>

using namespace std;

int main() {
    int arr[30];
    for (int i = 0; i < 30; i++) {
        arr[i] = 0;
    }

    for (int j = 0; j < 28; ++j) {
        int i;
        cin >> i;
        arr[i - 1] = 1;
    }

    for (int i = 0; i < 30; ++i) {
        if (arr[i] == 0) {
            cout << i + 1 << endl;
        }
    }
}