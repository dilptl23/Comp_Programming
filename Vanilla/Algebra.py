import sys

def ints():
	for line in sys.stdin:
		for d in line.split(" "):
			yield int(d)

def plugIn(poly, x):
	ans = 0
	power = 0
	for coef in poly:
		ans += coef * (x ** power)
		power += 1
	return ans

def binarySearch(poly, y):
	#binary search
	lo = 0
	hi = y

	while lo <= hi:
		mid = lo + (hi - lo) // 2
		#print("Mid: " + str(mid))
		guess = plugIn(poly, mid)
		#print("PlugIn: " + str(guess))
		if guess == y:
			return mid
		elif guess < y:
			lo = mid + 1
		else:
			hi = mid - 1
	return -1


def main():
	nums = ints()
	tests = nums.next()
	for t in range(0,tests):
		n = nums.next()
		y = nums.next()
		poly = []
		for i in range(0,n+1):
			poly.append(nums.next())
		x = binarySearch(poly, y)
		if(x == -1):
			print("N/A")
		else:
			print(x)

	

main()