def is_palindrome_v2(s):
	"""
	(str) --> boolean

	Return True if and only if s is a palindrome

	>>> is_palindrome_v2('noon')
	True
	>>> is_palindrome_v2('racecar')
	True
	>>> is_palindrome_v2('dented')
	False
	"""	
	
	if is_even(len(s)):
		return s[ : len(s) // 2 ] == reverse(s[ len(s) // 2 : len(s)])

	else:
		return s[ : len(s) // 2 ] == reverse(s[ len(s) // 2 + 1 : len(s)])

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

def is_even(n):
	if n % 2 == 0:
		return True

print is_palindrome_v2('noon')
print is_palindrome_v2('racecar')
print is_palindrome_v2('dented')

