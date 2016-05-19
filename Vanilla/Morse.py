import sys
letters = []

def numOfWays(word, knownResults):
	ans = 0
	if len(word) == 1:
		return 1
	elif len(word) == 2:
		return 2
	elif len(word) == 3:
		return 4
	elif len(word) == 4:
		if letters.count(word) == 0:
			return 7
		return 8 

	if(knownResults.has_key(word)):
		return knownResults[word]
	firstFour = word[:4]
	start = 3 if letters.count(firstFour) == 0 else 4
	for i in range(start,0,-1):
			n = numOfWays(word[i:], knownResults)
			knownResults[word[i:]] = n 
			ans += n

	#print(knownResults)
	return ans

	#recusively -- too slow
	# if(letters.count(firstFour) == 0):
	# 	return numOfWays(word[1:]) + numOfWays(word[2:]) + numOfWays(word[3:])
	# else:
	# 	return numOfWays(word[1:]) + numOfWays(word[2:]) + numOfWays(word[3:]) + numOfWays(word[4:])



def main():
	global letters
	numTests = 0
	tests = []
	i = 1
	for line in sys.stdin:
		if(i < 27):
			letters += line.split()
		elif (i == 27):
			numTests = int(line)
		else:
			tests += line.split()
		i += 1
	knownResults = {"-" : 1, ".": 1}
	for t in tests:
		ans = numOfWays(t, knownResults)
		print(ans % 1000000007)

main()