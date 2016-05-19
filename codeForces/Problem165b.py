import sys

def check(n, k, v):
	i = 0
	lines = 1
	while(lines!=0):
		lines = v // (k**i)
		n -= lines
		#print(n)
		if (n <= 0):
			return True
		i += 1

	return False

def times(n, k):
	low = 1
	hi = n

	while hi >= low:
		mid = (hi + low) // 2
		
		#checks if mid works
		if check(n, k, mid):
			hi = mid
		#checks if low works
		elif check(n, k, low):
			print(low)
			return
		#if mid and low dont work, checks if hi is the answer 
		elif check(n, k, hi - 1) == False:
			print(str(hi))
			return
		#if hi - 1 works then low becomes mid 
		else:	
			low = mid

def main():
	for line in sys.stdin:
		x = [int(a) for a in line.split(" ")]
		times(x[0], x[1])

main()




