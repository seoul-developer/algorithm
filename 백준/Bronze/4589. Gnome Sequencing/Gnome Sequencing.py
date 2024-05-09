n = int(input())

genomes = [list(map(int, input().split())) for _ in range(n)]
print('Gnomes:')
for genome in genomes:
    if genome == sorted(genome) or genome == sorted(genome, reverse = True):
        print('Ordered')
    else:
        print('Unordered')