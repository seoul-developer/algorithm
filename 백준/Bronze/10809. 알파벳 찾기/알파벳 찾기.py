import string
alphabet = list(string.ascii_lowercase)
S = list(input())

for i in alphabet:
    if i in S:
        print(S.index(i), end = " ")
    else:
        print(-1, end = " ")