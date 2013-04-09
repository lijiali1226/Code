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
    word_list = []
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
        word_list.append(tmp)
    
    return word_list
      
class ParserError(Exception):
    pass

class Sentence(object):

    def __init__(self, subject, verb, object_):
        # remember we take ('noun', 'princess') tuples and convert them
        self.subject = subject[1]
        self.verb = verb[1]
        self.object_ = object_[1]

#    def __eq__(self, other):
#        return (self.subject == other.subject and 
#                self.verb == other.verb and 
#                self.object_ == other.object_)

def peek(word_list):
    if word_list:
        word = word_list[0]
        return word[0]
    else:
        return None

def match(word_list, expecting):
    if word_list:
        word = word_list.pop(0)

        if word[0] == expecting:
            return word
        else:
            return None
    else:
        return None

def skip(word_list, word_type):
    while peek(word_list) == word_type:
        match(word_list, word_type)

def parse_verb(word_list):
    skip(word_list, 'stop')
    
    if peek(word_list) == 'verb':
        return match(word_list, 'verb')
    else:
        raise ParserError("Expected a verb next.")

def parse_object(word_list):
    skip(word_list, 'stop')
    next = peek(word_list)

    if next == 'noun':
        return match(word_list, 'noun')
    if next == 'direction':
        return match(word_list, 'direction')
    else:
        raise ParserError("Expected a noun or direction next.")

def parse_subject(word_list, subj):
    verb = parse_verb(word_list)
    obj = parse_object(word_list)
    
    return Sentence(subj, verb, obj)
   
def parse_sentence(word_list):
    skip(word_list, 'stop')
    
    start = peek(word_list)

    if start == 'noun':
        subj = match(word_list, 'noun')
        return parse_subject(word_list, subj)
    elif start == 'verb':
        # assume the subject is the player then
        return parse_subject(word_list, ('noun', 'player'))
    else:
        raise ParserError("Must start with subject, object, or verb not: %s" % start)
    

#print parse_sentence(scan("princess kill the bear"))
#print parse_sentence(scan("kill the bear"))
#print parse_sentence(scan("bear"))
#print parse_sentence(scan("123455"))
#print parse_sentence(scan("the stop stop"))
