# Remove Duplicate LinkedList

## Tag

LinkedList

## Description

https://codelab.interviewbit.com/problems/remduplnk/

## Clarify

1. What is the input format? 

   (Given structure ListNode)

2. Will the input be empty? 

   (Yes)

3. Does the LinkedList start with empty node or not?

   (No empty head)

4. Does the LinkedList end by `null` ?

   (Yes)

5. Could the `val` of ListNode be changed?

   (This is extremely important)

## Bug Free

Done

## Solution

1. Best solution:

   One slow pointer, one fast pointer. Slow pointer records the tail of result LinkedList, and fast pointer records the position you have checked. If the node value you check next if different from the result tail, add it to the result. (Notice: change value or `next` according to question clarify.) And remember to set the `next` of result tail to `null`. 

   - Time complexity: O(n)
   - Space complexity: O(1)
