directions = ['north', 'south', 'east', 'west', 'down', 'up', 'left', 'right', 'back']
verbs = ['go', 'stop', 'kill', 'eat']
stops = ['the', 'in', 'of', 'from', 'at', 'it']
nouns = ['door', 'bear', 'princess', 'cabinet']
numbers = []


def convert_numbers(s):
    try:
        return int(s)
    except ValueError:
        return None

def scan(s):
    sentence = []
    words = s.split()
    for i in words:
        if i in directions:
            tmp = ('direction','%s' % i)
        elif i in verbs:
            tmp = ('verb','%s' % i)
        elif i in stops:
            tmp = ('stop','%s' % i)
        elif i in nouns:
            tmp = ('noun','%s' % i)
        elif convert_numbers(i) != None:
            tmp = ('number', convert_numbers(i))
        else:
            tmp = ('error', '%s' % i)
        sentence.append(tmp)
    
#    print sentence
    return sentence
      
  
##s = raw_input("> ")            
##scan(s)    

##scan("north")
##scan("north south east")
##scan("1234")
