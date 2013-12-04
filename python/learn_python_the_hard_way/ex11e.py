print "How old are you?",
age = raw_input()
print "How tall are you?",
height = raw_input()
print "How much do you weigh?",
weight = raw_input()
print "Do you enjoy coding?(y/n)",
ans = raw_input()

print "So, you're %r old, %r tall and %r heavy." % (
    age, height, weight)
if ans == "y":
    print "She enjoys coding."
else: 
    print "She dosn't enjoy coding yet."
