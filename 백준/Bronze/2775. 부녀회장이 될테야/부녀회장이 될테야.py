
t = int(input())

for _ in range(t):
    k = int(input())
    n = int(input())
    people = list(range(1, n + 1))
    
    
    for x in range(k):
        for j in range(1, n):
            people[j] += people[j - 1]
    
    print(people[- 1])
