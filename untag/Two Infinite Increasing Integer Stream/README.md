# Two Infinite Increasing Integer Stream

## Tag

LinkedList

## Description

1. [1point3acres](http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=441804&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311)

2. [Description.pdf](Description.pdf)

## Clarify

1. What is the format of input?

   (Define it yourself.)

2. What is the format of output?

    (Print it out.)

3. Will the two stream ever be empty?

4. Do the process as a infinite loop?

## Bug Free

1. The implement of `Deque` in Java is `LinkedList` .
2. `twoStream(Deque<Integer> a, Deque<Integer> b)` The type should be defined here.

## Solution

1. Best solution:

   Define the input as `Deque`, repeat the while-loop as long as one of them is not empty. 

   Compare `a.peek()` with `b.peek()`, poll the less one out and print it.

   - Time complexity: O(n) 
   - Space complexity: O(1)