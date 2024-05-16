#include <string>
#include <iostream>

using namespace std;

int main() {
    int T;
    string input[11];

    cin >> T;
    for (int i = 0; i < T; i++) {
        cin >> input[i];
    }

    for (int i = 0; i < T; i++) {
        string &result = input[i];
        unsigned long length = result.length();
        cout << result[0] << result[length - 1] << endl;
    }
}