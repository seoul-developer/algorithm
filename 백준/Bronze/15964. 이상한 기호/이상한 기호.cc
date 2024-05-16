#include <iostream>

using namespace std;

long long op(long long a, long long b){
    return (a + b) * (a - b);
}

int main() {
    long long A, B;
    cin >> A >> B;

    cout << op(A, B) << endl;
}