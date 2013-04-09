def is_palindrome_v1(s):
	"""
	(str) --> boolean

	Return True if and only if s is a palindrome

	>>> is_palindrome_v1('noon')
	True
	>>> is_palindrome_v1('racecar')
	True
	>>> is_palindrome_v1('dented')
	False
	"""	
	return s == reverse(s)

def reverse(s):
	""" (str) -> str

    Return s reversed.
    
    >>> reverse('hello')
    'olleh'
    """
	s_reversed = ''
	for ch in s:
		s_reversed = ch + s_reversed
	return s_reversed

print reverse('hello')
print is_palindrome_v1('noon')
print is_palindrome_v1('racecar')
print is_palindrome_v1('dented')

