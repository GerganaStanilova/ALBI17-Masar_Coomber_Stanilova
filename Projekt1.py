def patterncount(text,pattern):
	count=0
	for i in range(0, (len(text)-(len(pattern)))): 
		if text[i:i+len(pattern)]==pattern: 
                count=count+1
	return count
print(patterncount("hallohang", "hang"))
#def frequentword(text, k):
#    count=[]
#    frequentpattern=[]
#    pattern=" "
#    for i in range (len(text)-k):
#        pattern = text[i:k]
#        count[i]=patterncount(text, pattern)
#        
#        
