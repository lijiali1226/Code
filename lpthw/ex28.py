table = (True and True, #t
False and True, #f
1 == 1 and 2 == 1, #f
"test" == "test", #t
1 == 1 or 2 != 1, #t
True and 1 == 1, #t
False and 0 != 0, #f
True or 1 == 1, #t
"test" == "testing", #f
1 != 0 and 2 == 1, #f
"test" != "testing", #t
"test" == 1, #f
not (True and False), #t
not (1 == 1 and 0 != 1), #f
not (10 == 1 or 1000 == 1000), #f 
not (1 !=10 or 3 == 4), #f
not ("testing" == "testing" and "Zed" == "Cool Guy"), #t
1 == 1 and not ("testing" == 1 or 1 == 0), #t
"chunky" == "bacon" and not (3 == 4 or 3 == 3), #f
3 == 3 and not ("testing" == "testing" or "Python" == "Fun") #f
)

for i in table:
    print i
