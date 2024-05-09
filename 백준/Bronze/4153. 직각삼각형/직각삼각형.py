while True:
    tri = list(map(int, input().split()))

    if sum(tri) == 0:
        break
    
    max_tri = max(tri)
    tri.remove(max_tri)

    if max_tri ** 2 == tri[0] ** 2 + tri[1] ** 2:
        print('right')
    else:
        print('wrong')