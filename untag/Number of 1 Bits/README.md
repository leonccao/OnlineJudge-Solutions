# Number of 1 Bits

## Tag

Bit manipulation

## Description

https://codelab.interviewbit.com/problems/num1bits/

## Clarify

1. How long is the unsigned integer? 

   (32bit)

2. What is the input format?

    (Unsigned int)

3. How about Java? 

   (Use `long` instead )

## Bug Free

1. `a & 1 == 1` -> `(a & 1) == 1`

   The precedence of bit operators should be rememberd clearly.

   https://www.cnblogs.com/zjfjava/p/5996666.html

## Solution

1. Brute-force:

   Check all 32 bits one by one.

   - Time complexity: 32 times
   - Space complexity: O(1)

2. Best solution:

   Trick: `(x - 1)` will reverse all bits starting from the last 1 bit.

   So when we do `x & (x - 1)` , we will actually remove the last 1 bit from x.

   Repeat this operation until x equals 0.

   - Time complexity: O(n) (n is the number of 1 bits, n <= 32)
   - Space complexity: O(1)