l, p = map(int, input().split())
news = list(map(int, input().split()))

sg = l * p

for i in range(0, 5):
    news[i] -= sg


print(*news)