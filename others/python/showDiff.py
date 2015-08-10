f1=open("e:\\1.txt","r")
f2=open("e:\\2.txt","r")
line1=f1.readline()
line2=f2.readline()
count=0
while (line1 and line2):
	if(line1!=line2):
		print(count)
		print(line1+" "+line2+"error")
		break
	else:
		line1=f1.readline()
		line2=f2.readline()
		count+=1
f3=open("e:\\3.txt","r")
line3=f3.readline()
i=0
while line3:
        if(count!=i):
                i+=1
                line3=f3.readline()
        else:
                print(line3)
                break
input()
