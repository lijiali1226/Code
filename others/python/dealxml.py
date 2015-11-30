import os
import xml.etree.cElementTree as ET
f=open("d:\\full.xml")
i=1
for line in f.readlines():
    print(line)
    tree = ET.fromstring(line)
    for elem in tree.iter():
        if elem.tag=='{http://schema.ksec.com}FileName':
            print(elem.text)
            newname="d:\\"+elem.text+str(i)+".xml"
            print(newname)
            new_f=open(newname,'w')
            new_f.write(line)
            new_f.close
    i+=1
