#include <iostream>

using namespace std;

long long op(int a, int b){
    return (a + b) * (a - b);
}

int main() {
    int A, B;
    cin >> A >> B;

    cout << op(A, B);
}