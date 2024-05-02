#include <iostream>

using namespace std;

int main() {
    int N;
    int arr[101];
    int V;

    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    cin >> V;

    int result = 0;
    for (int i = 0; i < N; ++i) {
        if (arr[i] == V) {
            result++;
        }
    }


    cout << result;

    return 0;
}