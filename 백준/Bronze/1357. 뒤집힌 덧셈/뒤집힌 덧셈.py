a, b = map(int, input().split())

def rev(x):
    if x == 1000:
        return 1
    else:    
        sum_num = []
        lst = list(map(int, str(x)))
        for i in range(len(lst)): 
            sum_num.append(lst[i] * (10 ** (i)))
        
        return sum(sum_num)

print(rev(rev(a) + rev(b)))