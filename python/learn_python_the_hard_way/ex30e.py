people = 30
cars = 40
buses = 15


if cars > people and buses > cars:
    print "We should take the cars."
elif cars < people and buses < cars:
    print "We should not take the cars."
else:
    print "We can't decide."

if people > buses:
    print "Alright, let's just take the buses."
else:
    print "Fine, let's stay home then."
