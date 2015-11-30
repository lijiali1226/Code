import os

rootdir="e:\\Github\\MindMap\\_posts"


for root,dirs,files in os.walk(rootdir):
    for fileObj in files:
        #print(files)
        #print(fileObj)
        #print(rootdir+"\\"+fileObj)
        f=open(rootdir+"\\"+fileObj,'rb')
        
        content=f.read().decode('utf8')
        print(content)      
        content=content.replace('Mindmap ','')
        content=content.replace('lijiali1226.github.io','MindMap')
        print(content)
        content=content.encode('utf8')
        newname=fileObj[:11]+fileObj[19:]
        print(newname)
        f.close()
        
        fnew=open(rootdir+"\\"+newname,'wb')
        fnew.write(content)
        fnew.close()
    
