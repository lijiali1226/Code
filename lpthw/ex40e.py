cities = {'CA': 'San Francisco', 'MI': 'Detroit', 'FL': 'Jacksonville'}


cities['NY'] = 'New York'
cities['OR'] = 'Portland'

for i in cities:
    print cities.items()

while True:
    print "State? (ENTER to quit)",
    state = raw_input("> ")

    if not state: break

    if state in cities:
        print cities[state]
        #print cities.items()
    else:   
        print "Not found."    
