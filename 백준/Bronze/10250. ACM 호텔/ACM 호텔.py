import sys
import math

t = int(input())
for i in range(t):
    h, w, n = map(int, sys.stdin.readline().split())
    number = n // h + 1
    floor = n % h
    if n % h == 0:
        number = n // h
        floor = h
    
    print(f'{floor * 100 + number}')