def bubble_sort(L):
    """ (list) -> NoneType

    Sort the items of L from smallest to largest.

    >>> L = [7, 3, 5, 2]
    >>> bubble_sort(L)
    >>> L
    [2, 3, 5, 7]
    """
    
    e = len(L) - 1
    while e != 0:
        i = 0 
        while i < e:           
            if L[i] > L[i + 1]:
                L[i], L[i + 1] = L[i + 1], L[i]
            i += 1
        e -= 1

if __name__ == '__main__':
    import doctest
    doctest.testmod()
