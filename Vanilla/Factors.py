import sys
import math

def main():
	t = int(input())
	for _ in range(t):
		a, b = map(int, input().split(" "))
		a = math.factorial(a)
		b = math.factorial(b)
		c = a //b
		numOfFactors = 0
		divisor = 2

		while divisor <= c:
			if c % divisor == 0:
				c //= divisor
				numOfFactors += 1
			else:
				divisor += 1
		print(numOfFactors)	

main()
