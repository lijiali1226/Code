class Parent(object):

    def override(self):
        print "parrent override()"

    def implicit(self):
        print "parrent implicit()"

    def altered(self):
        print "parrent altered()"

class Child(Parent):

    def overide(self):
        print "child override()"

    def altered(self):
        print "child, before parent altered()"
        super(Child, self).altered()
        print "child, after parent altered()"    

dad = Parent()
son = Child()

dad.implicit()
son.implicit()

dad.override()
son.override()

dad.altered()
son.altered()


class Other(object):
    
    def override(self):
        print "other override"
    
    def implicit(self):
        print "other implicit"

    def altered(self):
        print "other altered"

class Child2(object):

    def __init__(self):
        self.other = Other()

    def implicit(self):
        self.other.implicit()
    
    def override(self):
        print "child override"
        self.other.override()

    def altered(self):
        print "child, before other altered()"
        self.other.altered()
        print "child, after other altered()"

son2 = Child2()

son2.implicit()
son2.override()
son2.altered()

