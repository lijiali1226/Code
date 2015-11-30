import xml.etree.cElementTree as ET
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
        

#path="d:\\"+str(i)+".xml"
tree = ET.parse("d:\\1.xml")
root=tree.getroot()
print(root)
print('\n')
print(root.tag)
print('\n')
print(root.attrib)

for child in root:
    print(child)

for elem in tree.iter():
    print(elem.tag,elem.attrib,elem.text)
