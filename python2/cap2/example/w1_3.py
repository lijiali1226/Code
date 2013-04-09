def is_palindrome_v3(s):
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
	i = 0
	j = len(s) - 1
			
	while i < j and s[i] == s [j]:
		i += 1
		j -= 1
		
	return i >= j		

print is_palindrome_v3('noon')
print is_palindrome_v3('racecar')
print is_palindrome_v3('dented')

