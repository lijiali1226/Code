import os
rootdir="e:\\Github\\MindMap\\_posts"

for file in os.listdir(rootdir):
    if file.find('MindMap')<0:
        #print(file.split('-')[3])
        print(file)
        print(file[:11]+file[19:])
        newname=file[:11]+file[19:]
        #print(rootdir+"\\"+file)
        os.rename(rootdir+"\\"+file,rootdir+"\\"+newname)
        print(file)
