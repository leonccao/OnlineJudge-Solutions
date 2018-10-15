# Binary Tree Zigzag Level Order Traversal

## Tag

Tree, LinkedList, Stack

## Description

1. https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
2. [1point3acres](http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=441250&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311)

## Clarify

1. What is the input format?

   (TreeNode)

2. What if the tree is empty?

    (Output null)

3. What is the starting order? 

   (From left to right )

4. What is the output format?

## Bug Free

1. `List<List<Integer>> ans` define must be the same.
2. Forget to write `new`

## Solution

1. Solution 1

   Use two stacks, one for the odd level (left to right), the other for the even level (right to left).

   When you pop one element from one stack, push its children to another stack. Mind which child first.

   - Time complexity: O(n)
   - Space complexity: O(n)

2. Solution 2

   Two `LinkedList`, one to record all `TreeNode` this level, the other record next level.

   Enumerate this level to get all values and fill list of the next level.

   Whether reverse all values this level depends on parity of depth.

   - Time complexity: O(n)
   - Space complexity: O(n) The total number of list element equals the nodes in tree.