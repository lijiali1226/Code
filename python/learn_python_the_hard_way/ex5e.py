name = 'Zed A. Shaw'
age = 35 # not a lie 
height = 74 # inches
weight = 180 # lbs
eyes = 'Blue'
teech = 'White'
hair = 'Brown'

print "Let's talk about %s." % name
print "He's %d cm tall." % (height * 2.54)
print "He's %d kg heavy." % (weight * 0.45359237)
print "Actually that's not too heavy."
print "He's got %r eyes and %r hair." % (eyes, hair)
print "His teeth are usually %s depending on the coffee." %teech

# this line is tricky, try to get it exactly right
print "If I add %d, %d, and %d, I get %d." % (age, height, weight, age +  height + weight)
