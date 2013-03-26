"""
-heaven(-God-Seraphim-Dominions-Angel)
-hell(-Satan-Evil-Demon-Ghost) 
-humen society(-)
"""

def what_you_become_heaven():
    print "Here is the room to register permanent residence."
    print "Your ID means what you are."
    print "What is your ID(0-10000)?"
    
    next = raw_input("> ")
    if next.isdigit():
        how_much = int(next)
    else:
        end("Man, learn to type a number.")

    if how_much == 0:
        end("Oh my god! You become the GOD!")
    elif how_much > 0 and how_much < 11:
        end("You are a Seraphim!")
    elif how_much > 10 and how_much < 101:
        end("You are a Dominions!")
    else:
        end("You are an angel!")

def what_you_become_hell():
    print "Pick your lucky number(0-10000)?"
    print "You have about 50% chance to survive."
    
    next = raw_input("> ")
    if next.isdigit():
        how_much = int(next)
    else:
        end("Man, learn to type a number.")
    
    if how_much != 0 and how_much % 2 == 0:
        end("You soul has been eaten by ghost.")

    if how_much == 0:
        end("Oh my Satan! You become the SATAN!")        
    elif how_much > 0 and how_much < 11:
        end("You are a Evil!")        
    elif how_much > 10 and how_much < 101:
        end("You are a Demon!")        
    else:
        end("You are a Ghost!")
        

"""
def interpret_string(s):
    if not isinstance(s,str):
        return str(s)
    if s.isdigit():
        return int(s)
    try:
        return float(s)
    except:
    return s
"""

def heaven():
    print "There is a guardian angel here."
    print "The angel has a bow."
    print "The angel is in front of another door."
    print "How are you going to move the angel?"
    angel_moved = False

    while True:
        next = raw_input("> ")
    
        if next == "steal bow":
            end("The angel finished you.")
        elif next == "taunt angel" and not angel_moved:
            print "The angel has moved from the door. You can go through it now."
            angel_moved = True
        elif next == "taunt angel" and angel_moved:
            end("The angel gets pissed off and finished you.")
        elif next == "open door" and angel_moved:
            what_you_become_heaven()
        else:
            print "I got no idea what that means."


def hell():
    print "Here you are in the hell."
    print "You have only about 50% chance to keep your soul."
    print "Do you flee for your life or gamble for your soul?"

    next = raw_input("> ")
    
    if "flee" in next:
        start()
    elif "gamble" in next:
        what_you_become_hell()
    else:
        hell()


def end(why):
    print why, "oooooOh!"
    exit(0)

def start():
    print "You are in a universe."
    print "There is a door to heaven and hell."
    print "Which one do you take?"

    next = raw_input("> ")

    if next == "heaven":
        heaven()
    elif next == "hell":
        hell()
    else:
        end("You went to human society and become who you are.")


start()

