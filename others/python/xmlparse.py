import xml.etree.cElementTree as ET
import os
for i in range(24,25):
    path="d:\\"+str(i)+".xml"
    #print(path)
    tree = ET.parse(path)
    #print(tree)
    for elem in tree.iter():
        if elem.tag=='{http://schema.ksec.com}FileName':
            print(elem.text)
            newname="d:\\"+elem.text+str(i)+".xml"
            os.rename(path,newname)
