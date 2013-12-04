# while loop
i = 0
numbers = []
n = raw_input("< ")

while i < 15:
    print "At the top i is %d" % i
    numbers.append(i)

    i = i + int(n)
    print "Numbers now: ", numbers
    print "At the bottom i is %d" % i


print "The numbers: "

for num in numbers:
    print num   

# for loop
i = 0
numbers = []

for i in range(0,16):
    numbers.append(i)
    print "Numbers now: ",numbers 


print "The numbers: "

for num in numbers:
    print num   

