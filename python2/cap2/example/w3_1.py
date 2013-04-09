def print_ints(n):
    """ (int) -> NoneType

    Print the integers from 1 to n, inclusive.
    """

    for i in range(1, n + 1):
        print(i)

def print_odd_ints(n):
    """ (int) -> NoneType

    Print the odd values from 1 to n, inclusive.
    """

    for i in range(1, n + 1, 2):
        print(i)

def print_pairs(n):
    """ (int) -> NoneType

    Print all combinations of pairs of integers 1 to n,
	inclusive.
    """

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            print(i, j)

def print_double_step(n):
    """ (int) -> NoneType

    Print integers from 1 to n inclusive, with an initial
    step size of 1 and each subsequent step size being 
    twice as large as it was previously.    
    """
    i = 1
    while i < n + 1:
        print(i)
        i = i * 2

print "print_ints(10)"
print_ints(10)
print "print_odd_ints(10)"
print_odd_ints(10)
print "print_pairs(10)"
print_pairs(10)
print "print_double_step(10)"
print_double_step(10)
 
