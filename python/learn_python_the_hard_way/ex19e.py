from sys import argv
script, cheese, crackers =argv

def cheese_and_crackers(cheese_count, boxes_of_crackers):
    print "You have %r cheeses!" % cheese_count
    print "You have %r boxes of crackers!" % boxes_of_crackers
    print "Man that's enough for a party!"
    print "Get a blanket.\n"


print "We can just give function numbers directly:" #1
cheese_and_crackers(20, 30)


print "Or, we can use variables from our script:" #2
amount_of_cheese = 10
amount_of_crackers = 50

cheese_and_crackers(amount_of_cheese, amount_of_crackers)


print "We can even do math inside too:" #3
cheese_and_crackers(10 + 20, 5 + 6)


print "And we can combine the two, variables and math:" #4
cheese_and_crackers(amount_of_cheese + 100, amount_of_crackers + 100)

print "user input: cheese/crackers " #5
amount_of_cheese = raw_input()
amount_of_crackers = raw_input()
cheese_and_crackers(amount_of_cheese, amount_of_crackers)

print "argv:" #6
cheese_and_crackers(cheese, crackers)

print "format control:" #7
print """
You have %r cheeses!
You have %r boxes of crackers! 
Man that's enough for a party!
Get a blanket.\n
""" % (amount_of_cheese, amount_of_crackers)

def cheese_and_crackers(*args): 
    cheese_count, boxes_of_crackers = args
    print "You have %r cheeses!" % cheese_count
    print "You have %r boxes of crackers!" % boxes_of_crackers
    print "Man that's enough for a party!"
    print "Get a blanket.\n"

print "diff def:" #8
cheese_and_crackers(amount_of_cheese, amount_of_crackers) 

print "hardcode:" #9
print "You have 10 cheeses!" 
print "You have 20 boxes of crackers!" 
print "Man that's enough for a party!"
print "Get a blanket.\n"

print "read from file:" #10
file_name = raw_input("filename: ")
indata = open(file_name)
amount_of_cheese = indata.readline()
amount_of_crackers = indata.readline()
cheese_and_crackers(amount_of_cheese, amount_of_crackers)

