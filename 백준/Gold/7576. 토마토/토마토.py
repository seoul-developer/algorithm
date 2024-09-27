# 7576번 토마토
from collections import deque
import sys

def bfs(queue, graph):
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < M and 0 <= ny < N and graph[ny][nx] == 0:
                graph[ny][nx] = graph[y][x] + 1
                queue.append((nx, ny))


M, N = map(int, input().split())
graph = []
queue = deque()
count = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(N):
    graph.append(list(map(int, input().split())))

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            queue.append((j, i))

bfs(queue, graph)
for lst in graph:
    for tomato in lst:
        if tomato == 0:
            print(-1)
            sys.exit(0)
    count = max(count, max(lst))
print(count - 1)
