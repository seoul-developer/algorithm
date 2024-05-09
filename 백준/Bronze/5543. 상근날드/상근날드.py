high = int(input())
mid = int(input())
low = int(input())
coke = int(input())
cid = int(input())

burger_list = []
bev_list = []

burger_list.append(high)
burger_list.append(mid)
burger_list.append(low)

bev_list.append(coke)
bev_list.append(cid)

lowest = min(burger_list) + min(bev_list) - 50

print(lowest)

