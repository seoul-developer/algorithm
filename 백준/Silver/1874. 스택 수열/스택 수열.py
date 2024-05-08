n = int(input())
stack = []
result = []
no_message = True
count = 0

for i in range(0, n):
    x = int(input())
    while count < x:
        count = count + 1
        stack.append(count)
        result.append("+")
        

    if stack[-1] == x:
        stack.pop()
        result.append("-")

    else:
        no_message = False
        break

if no_message == False:
    print("NO")

else:
    print("\n".join(result))