import os
rootdir="e:\\Github\\Code"

def count(i):
    f=open(i,"rb")
    try:
        n=len(f.readlines())
        print(i+"  "+str(n))
        return n
    finally:
        f.close()
        
n=0        
for rt,dirs,files in os.walk(rootdir):
    #print("rt")
    #print(rt)
    #print("dirs")
    #print(dirs)
    #print("files")
    #print(files)
   
    if files!=[]:
        for f in files:
            #print(rt,os.sep,f)
            if not "." in rt and f!=".gitignore" and f!="README": 
                n+=count(rt+os.sep+f)
print(n)

