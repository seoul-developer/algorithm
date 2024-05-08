#include <string>
#include <iostream>

using namespace std;

int main() {
    string grade;
    double res = 0;
    cin >> grade;

    char letter = grade[0];
    char detail = grade[1];

    if (letter == 'A') {
        res += 4.0;
    }
    if (letter == 'B') {
        res += 3.0;
    }
    if (letter == 'C') {
        res += 2.0;
    }
    if (letter == 'D') {
        res += 1.0;
    }
    if (letter == 'F') {
        res += 0.0;
    }

    if (detail == '+') {
        res += 0.3;
    }
    if (detail == '-') {
        res -= 0.3;
    }

    cout << fixed;
    cout.precision(1);
    cout << res;
}