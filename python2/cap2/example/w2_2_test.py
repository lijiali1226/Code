import unittest
import w2_2

class TestDivisors(unittest.TestCase):
    
    """Example unittest test methods for get_divisors."""
    
    def test_divisors_e1(self):

        """Test get_divisors with 8 and [1, 2, 3]."""

        actual = w2_2.get_divisors(8, [1, 2, 3])
        expected = [1, 2]
        self.assertEqual(expected, actual)

    def test_divisors_e2(self):

        """Test get_divisors with 4 and [0, -2, 2]."""

        actual = w2_2.get_divisors(4, [-2, 2, 0])
        expected = [-2, 2]
        self.assertEqual(expected, actual)

unittest.main(exit = False)
