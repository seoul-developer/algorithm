import sys

a = int(sys.stdin.readline(), 2)

o = format(a, '#o')
result = o.replace('0o', '')
print(result)