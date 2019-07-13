import collections
import functools

from test_framework import generic_test
from test_framework.test_failure import TestFailure
from test_framework.test_utils import enable_executor_hook

'''
Description
Your input is an array of integers, 
and you have to reorder its entries so that the even entries appear first.
This is easy if you use O(n) space, where n is the length of the array. 
However, you are required to solve it without allocating additional storage.
'''


def even_odd(A):
    # TODO - you fill in here.
    even_p, odd_p = 0, len(A) - 1
    while even_p < odd_p:
        if A[even_p] % 2 == 0:
            even_p += 1
        else:
            A[odd_p], A[even_p] = A[even_p], A[odd_p]
            odd_p -= 1
    return


@enable_executor_hook
def even_odd_wrapper(executor, A):
    before = collections.Counter(A)

    executor.run(functools.partial(even_odd, A))

    in_odd = False
    for a in A:
        if a % 2 == 0:
            if in_odd:
                raise TestFailure("Even elements appear in odd part")
        else:
            in_odd = True
    after = collections.Counter(A)
    if before != after:
        raise TestFailure("Elements mismatch")


if __name__ == '__main__':
    exit(
        generic_test.generic_test_main("even_odd_array.py",
                                       'even_odd_array.tsv', even_odd_wrapper))
