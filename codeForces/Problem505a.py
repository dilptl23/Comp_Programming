import sys
def checkRest(word):
	left = 0;
	right = len(word) - 1
	while(left <= right):
		if(word[left] != word[right]):
			return False
		left+=1
		right-=1
	return True

def palen(line):
	
	left = 0
	right = len(line)-1
	while(left < right):
		if(line[left] != line[right]):
			

			worda = line[:right+1] +line[left] + line[right+1:]
			wordb = line[:left] + line[right] + line[left:]
			if(checkRest(worda)):
				print(worda)
				return
			elif(checkRest(wordb)):
				print(wordb)
				return
			else:
				print("NA")
				return
		left+=1
		right-=1
				
	print(line[:right]+line[right]+line[right:])
	return

def main():
	palen(input())

main()	