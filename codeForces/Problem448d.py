import sys

def check(x, a, b, c):
    nt = 0
    for i in range(1, a+1):
        nt += min(b, x/i)
    if(nt >= c):
        return True
    return False

def main():
    for line in sys.stdin:
        a, b, c = [int(x) for x in line.split(" ")]
    low = 1
    high = a * b
    ans = -1
    mid = 0

    while(low <= high):
        mid = (low + high) // 2
        if(check(mid, a, b, c)):
            ans = mid
            high = mid - 1
        else:
            low = mid+1

    print(ans)
main()
