import os
f=open("d:\\full.xml")
i=1
for line in f.readlines():
    path="d:\\"+str(i)+".xml"
    print(path)
    new_f=open(path,'w')
    new_f.write(line)
    new_f.close
    i+=1
    #print(line)
    #res=line.split("</Envelope>")[1]
    #print(res)
        
