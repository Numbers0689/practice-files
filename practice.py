import sys
import numpy

x = int(input("Enter num x: "))
y = int(input("Enter num y: "))

x_sqr = x**y
print("x**y = " + str(x_sqr))

x_log = numpy.log2(x)
print("log(x) = " + sys.set_int_max_str_digits(x_log))
