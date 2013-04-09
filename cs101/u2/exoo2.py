# By Websten from forums
#
# Given your birthday and the current date, calculate your age in days. 
# Account for leap days. 
#
# Assume that the birthday and current date are correct dates (and no 
# time travel). 
#
def isLeapYear(year):
    if (year % 4 == 0 and year % 100 != 0) or  year % 400 == 0:
        days = 366
    else:
        days = 365
    return days

def month_day(month, year):
    if month == 2 and isLeapYear(year) == 365:
        days = 28
    elif month == 2:
        days = 29
    elif month == 1 or month == 3 or month == 5 or  month == 7 or month == 8 or month == 10 or month == 12:
        days = 31
    else:
        days = 30
    return days

def daysBetweenDates(year1, month1, day1, year2, month2, day2):
    ##
    # Your code here.
    ##
    sumday = 0
    n = 0
    m = 0    
    for year in range(year1, year2 + 1):     
        sumday += isLeapYear(year)    
    
    for month in range(1, month1):
        n += month_day(month, year1)
        
    sumday -= n    
        
    for month in range(month2 + 1, 12 + 1):
        m += month_day(month, year2)
        
    sumday -= m    
    
    d = day1 + month_day(month2, year2) - day2
    sumday -= d
    
    return sumday    

# Test routine

def test():
    test_cases = [((2012,1,1,2012,2,28), 58), 
                  ((2012,1,1,2012,3,1), 60),
                  ((2011,6,30,2012,6,30), 366),
                  ((2011,1,1,2012,8,8), 585 ),
                  ((1900,1,1,1999,12,31), 36523)]
    for (args, answer) in test_cases:
        result = daysBetweenDates(*args)
        if result != answer:
            print "Test with data:", args, "failed"
        else:
            print "Test case passed!"

test()

