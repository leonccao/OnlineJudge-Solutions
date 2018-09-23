# Leetcode Problem Sheet

## 1. Two Sum

1. O(N^2) is easy
2. O(N) use hash. The map in C++ is quite convenient. 

## 2. Add Two Numbers

O(N) approach. High precision addition method.

Faults:

1. **[WA]** Ingored the carry from the largest bit.
2. **[WA]** `len1(1)` the wrong initialization.

## 3. Longest Substring Without Repeating Characters

O(N) approach, should be the best. Use one array prev[char] to record the latest appeared position of each character. Use one var to record the started position of the current string. Move this var to the new character if such char has appeared in this string.

Faults:

1. **[RE]** The characters are in ASCII range, not only letters.
2. **[RE]** The same as above.

## 4. Median of Two Sorted Arrays  

O(log(2N)) approach. This question is quite complicated. Firstly use dichotomy on one set, enumerate one integer. Secondly use dichotomy on the other set to see how many integers are there larger or smaller than it.

Faults:

1. If the median is not an integer?
2. Or if it is an integer but never appeared in the sets?
3. What if empty array appears in the processing


## 5. Longest Palindromic Substring

O(N^2) approach. Emunerate the middle position of the substring. Notice than the substring's length could be even or odd.

## 6. ZigZag Conversion

Two approaches:

1. Give each letter one serial number. Print them according to the number. Which is time consuming.
2. Find which letter to be printed next. Which will be much faster.

## 7. Reverse Integer

Tips:

1. Leetcode uses windows environment. `long long` could be used here to make this problem easier.
2. `INT_MIN` and `INT_MAX` could be used to indicate the range of int.

Faults:

1. **[WA]** Forgot to initialize the var in class


## 8. String to Integer (atoi)

Things to be noticed:

1. If it is an empty string 
2. The first non-whitespace character
3. If the string only contains whitespace
4. An optional plus or minus sign
5. Stop if invalid character appears
6. Out of range

Faults:

1. **[WA]** Even `long long` is not enough to store this number, so out of range problem should be processed during the transferring.
2. **[CE]** When you check whether the result is smaller than `INT_MIN`, `result > INT_MAX + 1` should be used. But the `INT_MAX + 1` here will exceed integer range, so use `result - 1 > INT_MAX` instead.

## 9. Palindrome Number

Noticed that the problem regards that a negative number could not be palindrome.

## 10. Regular Expression Matching

Try to transfer string p into a more standard form. Then use DP to solve this problem. The "*" condition maybe a little tricky.

Faults:

1. **[WA]** Forget to set bool var to `false` out of the `if` sentences.

## 11. Container With Most Water

My first thought was a O(Nlog(N)) approach. Maintain a increasing sequence, both forward and backward. When we try to find the answer for one bar, use binary search to find the minimum one larger than it. So is backwardly.

The best answer is the O(N) approach. Starting from the two ends, move the two ends to the middle until a new minimum height is reached.

## 12. Integer to Roman

Simple question.

## 13. Roman to Integer

First split the string into four parts. Then use multiple `if` sentence to translate them. What a pity `switch()` could not be used here.

## 14. Longest Common Prefix

Mine is O(NMlog(M)) approach. Select the shortest as the standard, and use dichotomy to enumerate the length of common prefix. Check if such a prefix is right.

## 15. 3Sum

This problem is quite complicated. My first thought was a O(N * N) approach with hash map. But it seems that the negative number couldn't be processed properly. Also, the time is not guranteed.

Then I found another approach. Sort the array, enumerate one number, and use the increasing property to find the other two. 

I try to enumerate the middle one at first, but duplicates could not be avoided. So it is better to enumerate the first one of the triplet.

Faults:

1. **[RE]** when you use "minus" after a `vector.size()`, if the vector is empty, the minus opteration will cause overflow, because the return value of `vector.size()` is unsigned type.

## 16. 3Sum Closet

This question is even simpler than the previous one. Only some little modifications are need here, like duplicates avoiding is uncessary.

Faults:

1. **[TLE]** Ignored the condition that the `tmp` just equalts to the `target`.

## 17. Letter Combiantions of a Phone Number

Build an alphabet and use DFS.


## 18. 4Sum

The same as "3Sum", but instead of enumerate only the begininng of quadruplets, enumerate the beginning and ending at the same time. When you enumerate, be sure that the ending is coming backwards. Otherwise, when you processing the duplicates, some conditions will be neglected.

Faults:

1. **[WA]** Enumerate the ending forwards.

## 19. Remove Nth Node From End of List

Simple to solve, but hard to do it in one pass.

Faults:

1. **[WA]** Think about if you have multiple elements in this link list but you want to delete the first one.

## 20. Valid Parentheses

Stack. Mind `"["` and `"]"` these two conditions.

## 21. Merge Two Sorted List

Just like merge sort, use two pointer.

## 22. Generate Parentheses

Enumerate all the conditions, at the same time, check if it is illegal.

How to check whether it is illegal? I make a silly here to use a stack. You just make sure that left brackets you have here are more than right backets.

## 23. Generate Parentheses

Easy to pass, but learn a lot. Solve with the assistance of priority queue. Learnt the construction function of struct and the override of priority queue's compare function.

    struct Node {
      int val;
      int from;
      Node(int x, int y) : val(x), from(y) {}
    };
    
    struct NodeCmp{
        bool operator()(const Node &a, const Node &b){
            return a.val > b.val;
        }
    };

**[Warning]** The first element poped out should be the last element sorted by your compare function.

## 24. Swap Nodes in Pairs

The same as #25;

## 25. Reverse Nodes in k-Group

Use a vector to record every k elements. Be careful when k equals 1.

## 26. Remove Duplicates from Sorted Array

Just as the title says.

## 27. Remove Element

Naive.

## 28. Implement strStr()

KMP.

## 29. Divede Two Integers

This is quite a good question! You will learn bit manipulation and run into lots of traps.

    const long long one = 1;
    long long c, k, result = 0;
    while (divid >= divis) {
        bool finished = false;
        for (c = divis, k = 0; divid >= c; c <<= 1, k ++) {
            if (divid - c < divis) {
                result = result + (one << k);
                finished = true;
                break;
            }
        }
        if (finished) break;
        divid -= c >> 1;
        result += 1 << (k - 1);
    }

Faults:

1. **[1-2 WA]** The numbers could also be negative. Use a `bool` type sign to solve.
2. **[3-4 WA]** Mind the overflow. Even though every input is `int` type, `-2147483648 / -1` may have a result out of range.
3. **[5-6 WA]** Even though the result is in `int` range, the variables during processing will have value out of range. `long long` will be need here.
4. **[7 WA]** `1 << k` will also causes overflow. Use:

        const long long one = 1;

## 30. Substring with Concatenation of All Words
Learned a special for sentence and the usage of unordered_map.

	for (string word : words)
		counts[word] ++;

	if (counts.find(word) != counts.end()) {
		xxxx
	} else break;

Faults:

1. **[RE]** What if there is no solution? (The length of s is not enough.)

## 31. Next Permutation

Scan elements one-by-one backwards. Stop until at some position, the element before it (a) is larger than itself (b). Then, find the minimum scaned number larger than a. Swap there position, and sort all the elements that have been scaned.

Find the minimum larger one and sort could be implemented in O(log(N)) and O(N), but O(N) and O(log(N)) approached are much easier to write: `sort()`.

Faults:

1. **[WA]** Recalled a wrong algorithm but didn't challenge it. Swaped a and b instead.

## 32. Longest Valid Parentheses

There are several solutions for this problem (A and B stands for two valid parentheses):

1. O(N^3) `bool f[i,j]` means whether i~j is valid or not. A valid parentheses can be built from `(A)` or `AB`. Another O(N) is need to enumerate `AB` condition. (Actually meaningless.)
2. O(N^2) Enumerate the beginning or ending of the parentheses, use one stack to check how long the valid parentheses could be.
3. O(N) `int f[i]` stands for the length of the longest parentheses take s[i] as ending. That could be built in following two forms: `A(B)` and `A()`.

Faults:

1. **[TLE]** Only come up with the O(N^3) approach.
2. **[WA]** Only think of the `(B)` condition but not the `A(B)` one.
3. **[WA]** No initialization for the variable `int tmp`.

## 33. Search in Rotated Sorted Array

1. O(N) scan.
2. O(log(N)) Firstly use one binary search to locate the break point. Then binary the target in left half or right half.

Faults:

1. **[1-2 WA]** When there are only two elements, and the binary stops at the second element, you don't know whether this means there is a break point or not. So the best solution here would be push another `INT_MIN` into the vector. When there is no break point at all, the pointer will stop at `INT_MIN`.

## 34. Search for a Range

Use one binary for the starting of the range, and another for the ending.

## 35. Search Insert Position

Binary search.

## 36. Valid Sudoku

Use arrays to check duplicates.

Faults:

1. **[WA]** Forget the cpp initializing.
2. **[WA]** Translate rows and columns into boxes.
3. **[WA]** Not clear about the input format.

## 37. Sudoku Solver

DFS.

## 38. Count and Say

Simulation.

## 39. Combination Sum

DFS.

Sort the candidates so that you can stop the search if there is no solutions for the smaller ones.

## 40. Combination Sum II

Comparing to the question above, there are duplicates in the candidates but no duplicates in the results.

So you should enumerate how many pieces of one element are selected.

## 41. First Missing Positive

Swap every element to its supposed position, and then the first missed placed number is the answer.

Mind that the swap may mess up the array, so research the array until there is no change any more.

Faults:

1. **[WA]** There are duplicates in the input!

## 42. Trapping Rain Water

For each bar, find the highest bar on its left side and right side, then you know how much water you could store at this position. Add them up and you will get the answer.


## 43. Multiply Strings

High precision multiply.

Faults:

1. **[WA]** The result may be zero.

## 44. Wildcard Matching

Dynamic programming program.

Three conditions for matching process:

1. Two letters.
2. One question mark.
3. One star mark.

Match one string with empty string at first.

You can add one sign at the first of each string to facilitate the processing.

## 45. Jump Game II

Lemma: If you jump to Position A with a least n steps, then you must jump to positions after A within steps no less than n.

Thus we use a queue to store the farthest we can reach within the steps. We pop out the front element if we went out of that range. We push one new element in if it has a farther range than the end.

## 46. Permutations

Start from the end, find the first continous A and B such that A < B. Then find the smallest number after A
 but larger than A. Swap their position. Reverse the whole sequence start from B.

Repeat this process until no A and B
 could be found.

## 47. Permutations II

Same as above.

## 48. Rotate Image

First reverse the matrix up to down, then swap the symmetry.

## 49. Group Anagrams

Use unordered_map and multiset:

     unordered_map<string, multiset<string>> um;

Better way to write a for sentence:

    for (auto m : um) {}

A new way to construct vector:

    vector<string> anagram(m.second.begin(), m.second.end());

## 50. Pow(x, n)

Fast Exponentiation Method.


Faults:

1. **[TLE]** Store values to reduce the times to reference functions.

## 51. N-Queens

DFS + bitwise operations.

## 52. N-Queens II

Same as above.

Faults:

1. **[WA]** Forget the initialization.

## 53. Maximum Subarray

Maintain a sum array.


Faults:

1. **[WA]** The first number may be negative.

## 54. Spiral Matrix

For Sentences.


Faults:

1. **[WA]** The input is a matrix, not square.
2. **[RE]** The input maybe empty.

## 55. Jump Game

The same as `#45 Jump Game II`

## 56. Merge Intervals

Use a sort and go through them.


Faults:

1. **[WA]** The input maybe empty.

## 57. Insert Interval

The same as above.

## 58. Length of Last Word

The true problem here is complicated cases.


Faults:

1. **[WA]** "a ".

## 59. Spiral Matrix II

The same as #54.

## 60. Permutation Sequence

The same as #46 & #47.

## 61. Rotate List

Linked list Manipulation.

Faults:

1. **[WA]** k may be non-zero even though the list is empty.

## 62. Unique Paths

The easiest dp.

## 63. Unique Paths II

The same as #62.

## 64. Minimum Path Sum

The same as #63.

## 65. Valid Number

A challengable problem. Although the test cases are quite buggy, this problem encourage you to find corner cases as many as possible. In one word, its totally worth a try, but be prepared!

However, when I finished my one-hundred-line ugly code, I found regular expression match was obviously a better solution.

    Pattern.matches("(\\+|-)?(\\d+(\\.\\d*)?|\\.\\d+)(e(\\+|-)?\\d+)?", s);

Faults:

1. **[WA]** Oh, there are '+' and '-' sign.
2. **[WA]** Some good error here, how to check if one string is empty? ` if (s == null || s.length()==0 || s.equals("") || s.trim().isEmpty());` would be the full answer. But `if(s == null || s.length() <= 0);` will be efficient and enough.
3. **[WA]** Confused with one of the True and False.
4. **[WA]** `"4e+"` There should be number followed when starts by one sign.
5. **[WA]** `"+.8"` You call this a number ???
6. **[WA]** `" -."` One good corner case.

## 66. Plus One

High precision addition with only one special conditon that all the digits are "9".

Test programming in Java. Learned how to define one array in Java.

## 67. Add Binary

Binary version high precision addition.

Learned a lot about Java string operation.

    class Solution {
        public String addBinary(String a, String b) {
            // StringBuilder
            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1, carry = 0;
            while (i > -1 || j > -1) {
                int sum = carry;
                // String.charAt(pos) function
                if (i > -1) sum += a.charAt(i --) - '0';
                if (j > -1) sum += b.charAt(j --) - '0';
                // append(int i)
                // Appends the string representation of the int argument to this sequence.
                // float, boolean are the same.
                sb.append(sum % 2);
                carry = sum / 2;
            }
            // int in java could not be trated like boolean
            if (carry != 0) sb.append(carry);
            // StringBuilder.reverse() StringBuilder.toString()
            return sb.reverse().toString();
        }
    }

## 68. Text Justification (Hard)

String processing problem with complicated cases.

Faults:
1. **[WA]** One line forget to delete in "space == 0" part, and didn't come up with test case for such condition.
2. **[WA]** Format will be different for the last line of text.

## 69. Sqrt(x)

Good problem!

Use eps and binary search. The output could be tricky.

Faults:
1. **[TLE]** Not clear about the output. Actually you could just use floor() here and then try whether (result + 1) also possible.
2. **[TLE]** Same as above.
3. **[WA]** Same as above.
4. **[TLE]** Not clear about the precision of float(6) and double(15). Double should be used here.
5. **[WA]** When try (result + 1), its sqr maybe out of integer. You should convert type at this step.

## 70. Climbing Stairs

One simple dp problem.

Stair N could be reached from (N - 1) or (N - 2), so the transfer equation is :

    f[i] = f[i - 1] + f[i - 2];

## 71. Simplify Path (Medium)

Stack.

## 72. Edit Distance (Hard)

### Approach 1

BFS. But the time performance is so poor.

### Approach 2

O(NM) DP. f[i][j] means the edit distance between the first i characters of word1 and the first j characters of word2.

    f[i][j] = min {
        f[i - 1][j] + 1, 
        f[i][j - 1] + 1,
        f[i - 1][j - 1] + 1,
        f[i - 1][j - 1] (if word1[i] == word2[j])
        }

Faults:
1. **[WA]** One line of code forgot to delete.
2. **[TLE]** Poor time performance of BFS.
3. **[TLE]** Same as above.
4. **[TLE]** Same as above.
5. **[RE]** Input may be null.

## 73. Set Matrix Zeroes (Medium)

Easy to find one solution with O(N+M) space, but a little tricky to solve it with O(1) space.

Use the first row and column as the tag for zeroes. Scan them at first and change them at last.

Faults:

1. **[WA]** If (0, 0) is zero, you don't know it comes from row or column, or it is zero from the beginning. So another two variables are need to record if the first row and column contain any zeroes.

## 74. Search a 2D Matrix (Medium)

Binary Search.

Faults:

1. **[RE]** Input array maybe empty.

## 75. Sort Colors (Medium)

### Approach 1 (2 pass)

Count the number of 0s, 1s and 2s, overwrite the array.

### Approach 2 (1 pass)

Scan the array, swap 0 to the head and 1 to tail.

### Approach 3 (1 pass O(N) O(N))

https://leetcode.com/problems/sort-colors/discuss/26700/My-C++-solution-with-one-pass-and-O(n)-time-and-O(n)-space

Faults:

1. **[WA]** Wrong for-loop range, there maybe no 2s.

## 76. Minimum Window Substring (Hard)

Use one HashMap to store the characters in target string, another HashMap to store the characters you got in the substring.

One queue to maintain the substring. Push next character in. Keep polling head character out if you got enough this character or it doesn't belong to target string.

Update answer when all characters are acquired.

Notice: There maybe duplicate characters in string t. In such condition, the substring you found should contain as many as characters as the target string.

Faults:

1. **[TLE]** Remember check whether queue is empty before poll, otherwise it maybe keep poll.

## 77. Combinations (Medium)

DFS. Be careful about corner cases like k = 0 or k > n.

## 78. Subsets (Medium)

Almost the same as #77.

## 79. Word Search (Medium)

DFS.

## 80. Remove Duplicates from Sorted Array II (Medium)

Use one variable to count how many time this number has appeared. If already twice then go to the next one. The same if question is "at most k times".

## 81. Search in Rotated Sorted Array II (Medium)

Binary search. Find the start of array (the smallest one) and use it as be base for index conversion. Be careful with cases like [0, 1, 2, 0, 0].

## 82. Remove Duplicates from Sorted List II (Medium)

Add one node to result if its value is different from last node or next one.

Faults:

1. **[WA]** I set the value for an empty head node to Integer.MIN_VALUE, but inputs also include this value. Better be careful for circumstances like this.

## 83. Remove Duplicates from Sorted List

Use one pointer to record the last distinct node. Update it until you find a distinct one.

## 84. Largest Rectangle in Histogram (Hard)

Use one stack to store rectangles. Before push one new rectangle in, pop all rectangles taller than it out, calculate the largest area at the same time.

Push another zero or minus value at last to clear the whole stack.

## 85. Maximal Rectangle (Hard)

2D version of #84. Solve this problem row by row, use the same method as #84, the height could be inheritaged from last row.

## 86. Partition List (Medium)

Another two ListNode head for classification.

## 87. Scramble String (Hard)

Recursion. But only recursion is not fast enough to pass the test. I added two HashMap, return false as long as two strings contain different characters.

However, it is still not the best solution. We repeat to check some part in the recursion, so DP could be introduced to optimize the time performance.

Faults:

1. **[WA]** There may be no swap in one subtree.
2. **[TLE]** Bare resursion is not fast enough to past the test.

## 88. Merge Sorted Array (Easy)

Merge sort. As long as the space is prepared for you in array 1, you could just merge 2 into 1. In order to avoid conflicts, the operations should be done backwards.

## 89. Gray Code (Medium)

Write the answer in binary and look for pattern.
    0000 ↑↑↑↑
    0001 ↓|||
    0011  |||
    0010  ↓||
    0110   ||
    0111   ||
    0101   ||
    0100   ↓|
    1100    |
    1101    |
    1111    |
    1110    |
    1010    |
    1011    |
    1001    |
    1000    ↓

## 90. Subsets II (Medium)

DFS. To avoid duplicates, add next[] array which points to the next distinct number's pos. If you don't choose one number, jump directly to its next. In such a way, you can always make sure you picked numbers from left to right.

## 91. Decode Ways (Medium)

DP. Be careful with '0' conditions like 10, 20 ... 

Faults:

1. **[WA]** Input could be illegal like one 0.

## 92. Reverse Linked List II (Medium)

Reverse ListNode.

## 93. Restore IP Addresses (Medium)

DFS. Mind leading zero issues.

Faults:

1. **[WA]** Leading zero.

## 94. Binary Tree Inorder Traversal (Medium)

Use stack to store nodes. When you pop one node for the first, push its right child in, push itself in, push its left child in. When you push one node for the second time, really pop it out and add it to the result.

## 95. Unique Binary Search Trees II (Medium)

First find the answer for i-1 nodes, then try to put one new TreeNode (val = i) in to makeup the answer for i nodes. The new node could be root's father, or the right child of nodes on the rightest side. If new node becomes node K's new right child, then make its original right child new node's left child.

## 96. Unique Bianry Search Trees (Medium)

DP.

## 97. Interleaving String (Hard)

DP. f[i][j] means the first i characters of s3 matches with the first j characters of s1 and (i - j) characters of s2.

BFS and DFS are not only feasible but also able to achieve a better time performance.

## 98. Validate Binary Search Tree (Medium)

DFS. Collect the maximum and minimum value of each subtree, and compare them with the subtree's root.

Faults:

1. **[WA]** Integer.MAX_VALUE and Integer.MIN_VALUE appear in the input.
2. **[WA]** Same as above.
3. **[WA]** Same as above.


## 99. Recover Binary Search Tree (Hard)

1. Recursion is never O(1) space
2. Morris Traversal http://www.cnblogs.com/AnnieKim/archive/2013/06/15/morristraversal.html

## 100. Same Tree

DFS.

Faults:

1. **[WA]** The input maybe `null`. "Given two binary trees ..." so `null` is also a binary tree ???
2. **[RE]** Same as above.

## 101. Symmetric Tree

1. Recursive solution: Build another function `mirror(l, r)` to test whether TreeNode l and r and symmetric, and do this recursively.

2. Iterative solution: Put the inorder traversal in a List or a stack, check if this list/stack is palindrome.

## 102. Binary Tree Level Order Traversal (Medium)

BFS.

## 103. Binary Tree Zigzag Level Order Traversal (Medium)

BFS. The same as #102.

## 104. Maximum Depth of Binary Tree

DFS.


## 105. Construct Binary Tree from Preorder and Inorder Traversal (Medium)

Recursion.

## 106. Construct Binary Tree from Inorder and Postorder Traversal (Medium)

Same with #105.

## 107. Binary Tree Level Order Traversal II

DFS.

Learned how to new 2-dimensional array in Java.

## 108. Convert Sorted Array to Binary Search Tree

DFS. Choose the middle one as root.

## 109. Convert Sorted List to Binary Search Tree (Medium)

Recursion. The recursion will cose O(log n) space and you will need O(n) space for the built tree. Other than these, the solution used O(1) extra space.

If you do the building in inorder, the order you create one node will be the same order as its order in the linked list.

## 110. Balanced Binary Tree

DFS. One function to return the depth of one node, return -1 instead if it is not height-balanced.

## 111. Minimum Depth of Binary Tree

DFS. If one node do not have left child, then its depth is its right child's depth plus one.

## 112. Path Sum

DFS. If you want to find a path with sum s in node r, search for s-r.val in r's child node.

Faults:

1. **[WA]** The null input with sum 0 should return false as the answer.
2. **[WA]** The value could be negative.

## 113. Path Sum II (Medium)

Recursion.

Faults:

1. **[WA]** Node's value could be negative.

## 114. Flatten Binary Tree to Linked List (Medium)

Recursion. If root has left child L, then make his right child R L's rightest node's right child.

## 115. Distinct Subsequences (Hard)

DP. F[i][j] means the answer ends with s[i] match first j characters of string t.

    f[i][j] = sum{f[k][j - 1] (k < i)}

## 116. Populating Next Right Pointers in Each Node (Medium)

Notice that only constant extra space could be used, which means neither data structures nor recursion are permitted.

We can take advantage of "next" to go through the tree. In order to know the first element in next level, we need an variable to record the first child of this level. When completing one node's next attribute, search in its father's brothers until you find a brother has at least one child.

## 117. Populating Next Right Pointers in Each Node II (Medium)

Same as #116.

## 118. Pascal's Triangle

Two for loops.

## 119. Pascal's Triangle II 

Keep modifying on the same list.

## 120. Triangle (Medium)

DP. In order to use the same array all the time, you need to update the array from back in case the element you need will be covered.

## 121. Best Time to Buy and Sell Stock (Easy)

Use one MIN to record the lowest price and one MAX to record the highest profit.

## 122. Best Time to Buy and Sell Stock II (Easy)

Add (prices[i] - prices[i - 1]) when it is positive.

## 123. Best Time to Buy and Sell Stock III (Hard)

1. O(N^2) DP.
2. O(N) + O(N) Scan.
3. O(N) + O(1) Scan. https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1).

## 124. Binary Tree Maximum Path Sum

Recursion. Merge two path from its children or carry one path to its father.

Faults:

1. **[WA]** You can choose to obtain no value from children because the value maybe negative.

## 125. Valid Palindrome

### Corner case
1. Input string is empty.
2. Input contains only one character.
3. Input maybe odd or even.

### Bugs

1. **[WA]** Alphanumeric characters include both letters and numbers.
2. `Character.isLetterOrDigit(ch)`

### Solution
#### Solution 1 - StringBuilder

Append characters into StringBuilder and compare it with its reverse.

#### Solution 2 - two pointers

One forewards another backwards.

## 126. Word Ladder II (Hard)

BFS + DFS.

BFS search for shortest path and DFS print out all paths with such a length.

Build reverted edges during BFS, and search from end to start in the DFS.

(I think two-end BFS is too complicated here, and time performance improvement it brings is not very obvious.)

Faults:

1. **[TLE]** It will be too slow if do not clear the way (build new edges).
2. **[TLE]** Same as above.

## 127. Word Ladder (Medium)

Learned how to write two-end BFS.

Faults:

1. **[WA]** The endWord maybe not in the wordList.

## 128. Longest Consecutive Sequence (Hard)

Use a HashMap, for some number num, search for (num + 1). 
1. If (num + 1) not exists, return 1;
2. If (num + 1) exists and has not been searched, search (num + 2);
3. if (num + 1) has been searched, return len(num + 1) + 1;

Faults:

1. **[WA]** Not enough corner case: the number could be the same.

## 129. Sum Root to Leaf Numbers (Medium)

Recursion.

## 130. Surrounded Regions (Medium)

BFS.

Always mind wether the array will be empty when you get a 2D array's length.

Faults:

1. **[RE]** Input 2D array maybe empty.

## 131. Palindrome Partitioning (Medium)

DP + BFS.

## 132. Palindrome Partitioning II (Hard)

DP + DP.

## 133. Clone Graph (Medium)

BFS.

Faults:

1. **[CE]** Queue.
2. **[RE]** Input maybe null.

## 134. Gas Station (Medium)

### 1. Deque (My solution, O(N) + O(N))

Calculate price[] at first, according to `price[i] = price[i - 1] + gas[i] - cost[i]`.

Maintain an ascending deque for the least price[i]: before push in some value price[i] at back, pop out any value larger than price[i]; index i of price[i] should also be recorded.

First scan: push all price[] into deque.

Second scan: If i is the head of the deque, pop it out. Push it to the back of the deque. Update all prices by one variable bias.

### 2. Scan (Best solution, O(N) + O(1))

Record `tank += gas[i] - cost[i]`, if `tank < 0` then `tank = 0, start = i + 1`.

One question is, could some station k between the oldStart and newStart become the start of the solution? Answer is no. If k is the solution instead of oldStart, which means the sum between oldStart and k is negative, then k will become our newStart, which draws contradiction.

Faults:

1. **[WA]** The ascending order should also be maintained when you push one element in the second time.

## 135. Candy (Hard)

Scan from left to right to make sure the number on the right is larger than left.

Scan again from right to left to make sure number on the left is larger than right.

## 136. Single Number

XOR! Amazing solution!

## 137. Single Number II (Hard)

Learn how to solve all this kind of problems by this analysis:

https://leetcode.com/problems/single-number-ii/discuss/43296/An-General-Way-to-Handle-All-this-sort-of-questions.

## 138. Copy List With Random Pointer (Medium)

### 1. HashMap (O(N), O(N))

The most obvious solution is to use a HashMap to store the map between original node and duplicated node.

### 2. Scan and Modify the Original Linked List (O(N), O(1))

This approach is much more interested. In order to save space, we modify the original linked list instead. 

When copy a node, insert it into the linked list just after its origin. `dup = iter.next, iter.next = dup;` In such a way, the odd nodes in the list are original and the even nodes are duplicates.

Next, complete the random pointers of the duplicates.

At last, extract new list and restore the origin list.

### Faults:

1. **[TLE]** You need go to `iter.next.next` when you add a new node after `iter`.
2. **[RE]** Forget to make a copy before some node is changed.
3. **[RE]** Same as above.


## 139. Word Break (Medium)

(S is the length of string s, W is the longest length of words, and N is the number of words.)

### 1. KMP + DP (O((S+W)\*N, O(S\*N))

This is my solution.

First use KMP to match each word and string s to calculate array m[k][i], which means  whether the k-th word will match the substring end by position i in string s.

Then use DP to calculate f[i] (wether the first i characters in string could be matched) by enumerate the words in the wordDict.

Array m[k][i] could be replaced by HashMap<String, HashSet>

### 2. HashSet + DP (O(S\*S), O(W\*N))

Instead of enumerate words during DP, this approach enumerate the length of substring to be matched. In such a way, you don't need to pretreat the strings by KMP, and you should put all the strings in a HashSet.

Which solution's performance is better depends on the distribute of the data.

### 3. DP (O(S\*S\*N), O(S))

This approach is even more violent. Don't use HashSet, just let the List provided by the system to do the searching.

## 140. Word Break II (Hard)

Memorized DFS.

### Faults:

1. **[WA]** Extra space in the output.
2. **[TLE]** Not enough optimization.
3. **[TLE]** Same as above.

## 141. Linked List Cycle (Easy)

### 1. Modify the linked list (O(N), O(1))

Set one node's value to 0 after you visited it. When you visit one node that has been visited before, that means you reached one cycle.

### 2. Two pointers with different speed (O(N), O(1))

Two pointers, one fast one slow. The fast one move two steps forward at a time and the slow one move only step. If the two pointers meet together again, which means the fast pointer must walk through the cycle.

### Faults:

1. **[WA]** There is -1 but no 0 in this list.

## 142. Linked List Cycle II (Medium)

### Two pointers with different speed + (O(N), O(1))

Based on approach 2 from problem 141. 

    S         P     M         P
    |---------|-----+---------|
    |←   a   →|← b →|← (c-b) →|

S is the head of the linked list. P is the position where the cycle starts. M is the position where the fast pointer  meets the slow pointer.

The dist from S to P is a. The length of the cycle is c. The dist from P to M is b.

Because the speed of fast pointer is twice as the slow one, we have `a + b + c = 2a + 2b`. Thus, `a = c - b`. Which means if we start from S and M with the same speed, they will meet at P, the answer we want.

(Only illustrated fast pointer passed one cycle. It may cost several cycles for the two pointers to meet, but the conclusions are the same.)

### Faults:

1. **[RE]** Input node maybe null.

## 143. Reorder List (Medium)

Three steps:

1. Split the list into two.
2. Reverse the second list.
3. Merge two lists together.

## 144. Binary Tree Preorder Traversal (Medium)

Stack.

## 145. Binary Tree Postorder Traversal (Hard)

Stack with some modification.

## 146. LRU Cache (Hard)

### 1. HashMap + Queue

This is my solution. Record the number of operations on the side. 

Whenever you do some operation, update the element in the HashMap to show when this element was visited lately, and push this key into the queue. 

When the space is not enough and you poll one key out of the queue, check whether the time stamp is the latest. If so, set the value of the key to -1.

### 2. HashMap + Double Linked List

Use HashMap to store the map from key to  node in double linked list. If you visit one node, delete it from the list (O(1) because it is a double linked list) and add it to the tail. When size is not enough, delete from the head of the list.

### 3. LinkedHashMap

https://leetcode.com/problems/lru-cache/discuss/45939/Laziest-implementation:-Java's-LinkedHashMap-takes-care-of-everything

## 147. Insertion Sort List (Medium)

Linked list operation.

## 148. Sort List (Medium)

Merge sort.

### Faults:

1. **[RE]** Wrong if statement.

## 149. Max Points on a Line (Hard)

### HashMap (O(N * N), O(N))

Use gradient as the key of HashMap, enumerate the start point of the line, points with the same gradient will fall on the same line.

But after added the latest test case, double gradient will not pass. Either use BigDecimal instead, or store both x0 and y0 at the same time, which means HashMap in a HashMap.

### Faults:

1. **[WA]** x 7.

## 150. Evaluate Reverse Polish Notation (Medium)

Stack.

## 151. Reverse Words in a String (Medium)

String.trim()
String.split("\\s+")
StringBuilder

### Faults:

1. **[CE]**
2. **[CE]**
3. **[RE]**
4. **[WA]** 

## 152. Maximum Product Subarray (Medium)

Calculate the prefix product.

Pay attention to zeros.

Faults:

1. **[WA]** One single zero maybe the answer.

2. **[WA]** Same as above.


## 153. Find Minimum in Rotated Sorted Array (Medium)

Binary search.

## 154. Find Minimum in Rotated Sorted Array II (Hard)

At lease O(N).

### Faults:

1. **[WA]** Binary search is not avaliable here.
2. **[WA]** Same as above.
3. **[WA]** Same as above.

## 155. Min Stack (Easy)

Nice problem! How to get the min value in O(1) time without another stack is the tricky here.

Use one variable to store the min value. If a new coming number change the min value, push the old min into stack together with the coming number.

Faults:

1. **[WA]** Should update the min value if it is the same as the coming letter. Whether you could not tell if the coming number changes min.

## 156.

## 157. Read N Characters Given Read4 (Easy)

### Corner cases
1. Input is longer than n.
2. Input is shorter than n.

### Bugs
1. How to represent an empty char? `Character.MIN_VALUE`;

### Solution
#### Best solution

The most difficult part of this problem is the description itself. Actually the task is using function to read characters into buffer. You need to return the right `length` to control the length of answer.

- Time complexity: O(n)
- Space complexity: O(1)

## 158. Read N Characters Given Read4 II - Call multiple times (Hard)

### Corner cases
1. Will the input be the same one or refreshed for different call?
2. If you read too much last read(), you need to save them for next ones.
3. You may cover all 4 read(1) with only one read4() operation.

### Bugs
1. How to store characters between reads? There are several choices here ...

### Solution
#### Best solution

Still, the first trouble here is the description ... You continue reading on the same input string, but if you read too much in the previos read(), you need to save characters down for next queries.

- Time complexity: O(n)
- Space complexity: O(1)

## 159.

## 160. Intersection of Two Linked Lists

Start from headA and change all value to negative. Then start from headB and find the first negative one. Remember to change all value in listA back to positive.

But a better solution here is use two pointer and start for the same length left. Check one by one at the same time until find a same one.

### Faults:

1. **[CE]** 
1. **[WA]** Two lists should not be changed.
1. **[CE]**

## 161.

## 162. Find Peak Element (Medium)

Binary Search.

## 163.

## 164. Maximum Gap (Hard)

Bucket sort.

https://leetcode.com/problems/maximum-gap/discuss/50643/bucket-sort-JAVA-solution-with-explanation-O(N)-time-and-space

## 165. Compare Version Numbers (Medium)

String.split("\\.");

### Faults:

1. **[WA]** Different read the question description carefully.

## 166. Fraction to Recurring Decimal (Medium)

Use a hashtable to record where the remain appeared.

This problem's test cases are quite strong.

### Faults:

1. **[WA]** Input integer may be negative.
2. **[WA]** Answer maybe zero.
3. **[WA]** Input value maybe Integer.MIN_VALUE which could not be stored in an integer if you transfer it to positive.

## 167. Two Sum II - Input array is sorted

Let l start from head and r from tail. Just keep increasing l and decreasing r.

## 168. Excel Sheet Column Title

Divide and mod.

Use StringBuilder with reverse and toString.

## 169. Majority Element

Good problem!

``` java
for (int num : nums)
    if (cnt == 0) {
        cnt = 1;
        maj = num;
    } else if (num == maj)
        cnt ++;
    else cnt --;
```

## 170.

## 171. Excel Sheet Column Number

The opposite of #168.

## 172. Factorial Trailing Zeroes

In other words, we are going to find how many 5s are there in n!.

Faults:

1. **[WA]** When you try to find how many 5 are there in n, remember to keep tmp >= 5.

## 173. Binary Search Tree Iterator (Medium)

Use one stack to store the TreeNodes. First push the root and all its left children down to the bottom into to the stack. Every time you pop one element, push all the left children of its right child into the stack. This could make sure the length of stack will not surpass O(h).

## 174. Dungeon Game (Hard)

### 1. DP 

### 2. Binary Search + DP

### Faults:

1. **[WA]** Knight may not survive the first block.

## 175. Combine Two Tables

Try to solve a Mysql problem!

Faults:

1. **[WA]** `ON Person.PersonId = Address.PersonId`.

## 176. Second Highest Salary

``` sql
SELECT MAX(Salary)
AS SecondHighestSalary
FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee)
```

### Faults:

1. **[WA]** The header should be renamed.

## 177. Nth Highest Salary (Medium)

    SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT M, 1

## 178. Rank Scores (Medium)

    SELECT
        Score,
        (SELECT COUNT(DISTINCT Score) FROM Scores WHERE Score >= s.Score) Rank
    FROM Scores s
    ORDER BY Score DESC

## 179. Largest Number (Medium)

### LCM (My solution)

Extend two strings to their lcm length then compare them.

### Connect

Compare (s1 + s2) with (s2 + s1).

### Faults:

1. **[WA]** Compare until one string ends is not enough.
2. **[WA]** The result maybe "00000..." but you should output "0" instead.

## 180. Consecutive Numbers (Medium)

    SELECT DISTINCT l1.Num AS ConsecutiveNums FROM Logs l1, Logs l2, Logs l3
    WHERE l1.Id = l2.Id - 1 AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num AND l2.Num = l3.Num

## 181. Employees Earning More Than Their Managers

    SELECT E1.Name AS Employee
    FROM Employee AS E1, Employee AS E2
    WHERE E1.ManagerId = E2.Id and E1.Salary > E2.Salary

## 182. Duplicate Emails

Three ways:

1. WHERE with distinct
1. INNER JOIN with distinct
1. GROUP with COUNT(*) > 1

## 183. Customers Who Never Order

JOIN there together and SELECT one of which the CustomerId is NULL.

## 184. Department Highest Salary (Medium)

    SELECT D.Name AS Department ,E.Name AS Employee ,E.Salary 
    FROM
        Employee E,
        (SELECT DepartmentId,max(Salary) as max FROM Employee GROUP BY DepartmentId) T,
        Department D
    WHERE E.DepartmentId = T.DepartmentId 
    AND E.Salary = T.max
    AND E.DepartmentId = D.id

## 185. Department Top Three Salaries (Hard)

    SELECT D.Name AS Department, E.Name AS Employee, E.Salary 
    FROM Department D, Employee E, Employee E2  
    WHERE D.ID = E.DepartmentId AND E.DepartmentId = E2.DepartmentId AND 
    E.Salary <= E2.Salary
    GROUP BY D.ID,E.Name HAVING COUNT(DISTINCT E2.Salary) <= 3
    ORDER BY D.Name, E.Salary DESC

## 186.

## 187. Repeated DNA Sequences (Medium)

Store the string into hash tables. Both HashSet or HashMap is enough.

## 188. Best Time to Buy and Sell Stock IV (Hard)

e[i][k] means how much we can earn if we had k transactions and finished the lastest one on day i.

e[i][k] = max{max(e[j][k - 1]) - prices[l]} (j < l < i)

However the input K maybe meaningless large. So we need to firgure out whats the largest number of transactions we could have? The answer is (prices.length / 2). In such a condition, there in no consecutive increasing prices in the input.

### Faults:

1. **[TLE]** K too large.
2. **[TLE]** K too large.
3. **[TLE]** K too large.

## 189. Rotate Array

This solution is amazing!

If you want to rotate with k steps, first reverse the whole array, then reverse (0, k-1) and (k, length - 1) seperately.

## 190. Reverse Bits

Use bit computing will speed up the processing.

Faults:

1. **[WA]** 
1. **[WA]** 
1. **[WA]** 
1. **[WA]** 
1. **[WA]** 
1. **[WA]** The input is actually unsigned int.

## 191. Number of 1 Bits

If you want to trade int as unsigned int, then no sign related operator should be used.

Faults:

1. **[WA]** We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
1. **[WA]** `n != 0` should be used instead of `n > 0`.

## 192. Word Frequency (Medium)

    cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -r | awk '{ print $2, $1 }'

https://leetcode.com/problems/word-frequency/discuss/55443/My-simple-solution-(one-line-with-pipe)

## 193. Valid Phone Numbers

    grep -P '^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$' file.txt

Faults:

1. **[WA]** 
1. **[WA]** 
1. **[WA]** 
1. **[WA]** 
1. **[RE]** 
1. **[RE]** Grammar errors.

## 194. Transpose File (Medium)

    awk '
    {
        for (i = 1; i <= NF; i++) {
            if(NR == 1) {
                s[i] = $i;
            } else {
                s[i] = s[i] " " $i;
            }
        }
    }
    END {
        for (i = 1; s[i] != ""; i++) {
            print s[i];
        }
    }' file.txt

## 195. Tenth Line

    sed -n 10p file.txt


## 196. Delete Duplicate Emails

DELETE operation.

## 197. Rising Temperature

TO_DAYS() operator.

Faults:

1. **[WA]** If use minus directly, there will be conditions like 2015-1-31 and 2015-2-1. So TO_DAYS is the best tool here.

## 198. House Robber

A basic dp.

## 199. Binary Tree Right Side View (Medium)

Recursion.

Always keep updating because the node you visit later will always be on the right.

## 200. Number of Islands (Medium)

FloodFill.

## 201. Bitwise AND of Numbers Range (Medium)

``` java
int offset = 0;
while (m != n) {
    m >>= 1;
    n >>= 1;
    offset ++;
}
return m <<= offset;
```

### Faults:

1. **[TLE]** 
2. **[TLE]**


## 202. Happy Number

While loop.

## 203. Remove Linked List Elements

I was asked about this question in interviews for two times.

Use one pointer (l) to point to last ListNode and another point (n) to this ListNode. If this ListNode needs to be deleted, points l to n's next.

Add another blank ListNode to this list's head to facilitate processing.

## 204. Count Primes

Count primes.

Faults:

1. **[TLE]** Optimization from O(N*N) to O(N).

## 205. Isomorphic Strings

Practice to use HashMap.

## 206. Reverse Linked List

Remember to set the next of head to "null".

## 207. Course Schedule (Medium)

First turn the input list of edges into Map from courses and List.

Then use topo sort with queue to proceed all courses. If the number of courses we polled out of queue equals to the number of courses, the answer is "true".

## 208. Implement Trie (Prefix Tree) (Medium)

Trie.

## 209. Minimum Size Subarray Sum (Medium)

Slide window.

## 210. Course Schedule II (Medium)

Same as #207.

### Faults:
1. **[CE]** Extra bracket.

## 211. Add and Search Word - Data structure design (Medium)

Same as #208.

## 212. Word Search II (Hard)

Search the trie while go through the board.
Break when there is no succeeding node in the trie. 

### Faults:
1. **[WA]** Confusing DFS code.
1. **[WA]** Return before recover the array.

## 213. House Robber II (Medium)

Same as #198. Do the same process for twice, once rob the first houst, once not.

## 214. Shortest Palindrome (Hard)

Match string s with its reverse r.

The length of matched string till the last char of t will be the part of palindrome we could make use of. Add the left part.

## 215. Kth Largest Element in an Array (Medium)

### 1. QuickSort O(nlogn) + O(1)
### 2. Heap O(nlogn) + O(n)
### 3. QuickSelect O(n) + O(1) 
Kind of like QuickSort. Instead of sorting both half sides, we only sort the half which k falls in.

## 216. Combination Sum III (Medium)

Recursion.

## 217. Contains Duplicate

Use HashSet in Java. 
Set.add(num) will return false if num already exists.

## 218. The Skyline Problem (Hard) 

The turn points appear only when one building starts or ends. So we split each building into two turn points. And use priority queue to maintain the highest height. When one building start, push it into heap. When the heap top building has already ended, pop it out.

## 219. Contains Duplicate II (Easy)

Distinguish between Set (HashSet) and Map (HashMap).

## 220. Contains Duplicate III (Medium)

### TreeSet O(NlogN)

### Bucket Sort O(N)

### Faults:
1. **[WA]** The divider should also be long type, otherwise error will appear.

## 221. Maximal Square (Medium)

Dynamic Programming.

## 222. Count Complete Tree Nodes (Medium)

### Iteration O(N)

Somtimes iteration will be faster than recursion, and somtimes just the opposite.

### depthLeft & depthRight O(logN * logN)

If one tree is full binary tree (depthLeft == depthRight, which are all the way down to left and all the way down to right), return ((1 << depth) + 1). Else return countNodes(leftChild) + countNodes(rightChild) + 1.

## 223. Rectangle Area (Medium)

The sum of two rectangles minus the overlap part.

## 224. Basic Calculator (Hard)

Convert the infix expression to postfix expression (with stack), then calculate the value of this postfix expression.

This approach maybe complicated, but it could achieve a much more powerful calculator in a practical way.

``` java
for (char ch : s.toCharArray())
```

## 225. Implement Stack using Queues (Easy)

Operation of LinkedList. O(n) to push or poll, kind of stupid.

## 226. Invert Binary Tree (Easy)

Easy one.

## 227. Basic Calculator II (Medium)

Same as #224.

## 228. Summary Ranges (Medium)

Scan.

## 229. Majority Element II (Medium)

Boyer-Moore Majority Vote

https://leetcode.com/problems/majority-element-ii/discuss/63520/Boyer-Moore-Majority-Vote-algorithm-and-my-elaboration

## 230. Kth Smallest Element in a BST (Medium)

### 1. count nodes of each subtree
### 2. recursion
### 3. iteration

## 231.

## 232. Implement Queue using Stacks

The inverted version of #225.

## 233. Number of Digit One (Hard)

Count the ones bit by bit.

### Faults:
1. **[WA]** Will not be negative necessarilly after overflow.

## 234. Palindrome Linked List

> Could you do it in O(n) time and O(1) space?

Reverse the first half or last half, then compare each half front to end.

## 235. Lowest Common Ancestor of a Binary Search Tree

The given BST structure makes it easy to solve.

## 236. Lowest Common Ancestor of a Binary Tree (Medium)

### 1. Recursion O(N) + O(1)

Like #235, if p and q appear in two different children of root, then root is the answer. Otherwise search for answer in its children.

### 2. Fathers O(N) + O(N)

First find all nodes' fathers and store them in a map. Then keep going up from p and q until meet at some node (adjust them to the same depth at first).

### Faults:
1. **[WA]** Stop when p and q are the same, not the depth is zero.

## 237. Delete Node in a Linked List

Just move the val and next from next node to this one.

Actually I was asked about this question for twice during auditions.

## 238. Product of Array Except Self (Medium)

Scan twice.

## 239. Sliding Window Maximum (Hard)

### 1. Deque O(N) + O(N)

Maintain a descending deque with capacity k. Push new element into the end, pop smaller elements out before. Pop out the head element if its index is out of size k.

Finally, the element at head will be our answer here.

### 2. LeftMax[] & RightMax O(N) + O(N)

Cut the array into blocks with size k. Use leftMax[i] and RightMax[i - k + 1] to make up the window we want.

https://leetcode.com/problems/sliding-window-maximum/discuss/65881/O(n)-solution-in-Java-with-two-simple-pass-in-the-array (One reply below with graph is much more clear than the post itself.)

### Faults:
1. **[WA]** Stupid question description. Input maybe invalid even guranteed in the description.

## 240. Search a 2D Matrix II (Medium)

> We start search the matrix from top right corner, initialize the current position to top right corner, if the target is greater than the value in current position, then the target can not be in entire row of current position because the row is sorted, if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too. We can rule out one row or one column each time, so the time complexity is O(m+n).

### Faults:
1. **[WA]** Wrong while loop range.

## 241. Different Ways to Add Parentheses (Medium)

### 1. Recursion O(N^2) + O(N^2)

### 2. DP O(N^2) + O(N^2)

``` java
ArrayList<Integer>[][] rec = (ArrayList<Integer>[][]) new ArrayList[len][len];
```

## 242.

## 243.

## 244.

## 245.

## 246. Strobogrammatic Number (Easy)

### Corner cases
1. When input is empty the answer is true

### Solution

### Bugs
1. `setCharAt()` is only available in `StringBuilder`
2. Case sentence
3. 2 and 5 are not a pair

### Test case

## 247. Strobogrammatic Number II (Medium)

Done

## 248.

## 249.

## 250.

## 251.

## 252. Meeting Roome (Easy)

### Corner cases
1. What if input is empty?
2. Could the intervals be reversed?
(Not possible.)
3. Of course the input is not guranteed with order.
4. Could the time be negative?

### Bugs
1. `Arrays.sort(arr, Collections.reverseOrder());`

### Solution
#### Best solution

Sort the intervals by start and record the farthest end by far, check if it overlap with next start.

- Time complexity: O(n log(n))
- Space complexity: O(1)

## 253. Meeting Rooms II (Medium)

### Corner cases
1. Input maybe empty.

### Bugs

### Solutions
#### Solution heap

Use MinHeap to store the ending time for each rooms' meeting. The size of heap equals to the number of rooms we had. When the top is larger then the starting time of next task, increase room size (heap size) by one.

- Time complexity: O(n log(n))
- Space complexity: O(n)

#### Solution two sorts

In this solution, you don't care when one specific meeting starts or ends, you just care when some some meeting starts and when some meeting ends.

Sort the starting times and ending times separately, one pointer for each. If the pointed starting time is less than ending point, means some new meeting start and we need to open a new room for it. When starting time is larger than ending time, it means one meeting is end and we have spare room for next meeting.

- Time complexity: O(n log(n))
- Space complexity: O(n)

## 254.

## 255.

## 256.

## 257. Binary Tree Paths

DFS. Update List<String> in the DFS function.

## 258. Add Digits

> Output sequence for decimals (b = 10):

> ~input: 0 1 2 3 4 …
> output: 0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 …

## 259.

## 260. Single Number III (Medium)

Amazing solution!

https://leetcode.com/problems/single-number-iii/discuss/68900/Accepted-C++Java-O(n)-time-O(1)-space-Easy-Solution-with-Detail-Explanations

## 261.

## 262. Trips and Users (Hard)

``` sql
SELECT Request_at as Day,
       ROUND(COUNT(IF(Status != 'completed', TRUE, NULL)) / COUNT(*), 2) AS 'Cancellation Rate'
FROM Trips
WHERE (Request_at BETWEEN '2013-10-01' AND '2013-10-03')
      AND Client_id NOT IN (SELECT Users_Id FROM Users WHERE Banned = 'Yes')
GROUP BY Request_at;
```

## 263. Ugly Number (Easy)

Divide all 2, 3 and 5 then check whether the remaining is 1.

## 264. Ugly Number II (Medium)

Hold all ugly numbers we got in a list. Use three different pointers for 2, 3 and 5 point to the list seperately. Every time add min{ugly[2] * 2, ugly[3] * 3, ugly[5] * 5} to the list and update these pointers.

## 265.

## 266.

## 267.

## 268. Missing Number

Xor 0~n with all numbers in nums, the number left will be the result.

## 269. Alien Dictionary (Hard) 

### Corner cases
1. Input is empty
2. There is no valid order

### Solution
1. Toposort: abstract the relationships from input, use toposort to construct the order string
    - Time complexity: O(sl)
    - Space complexity: O(1) (26 * 26)
    
### Bugs
1. RE will happen if trying to remove key when visiting keySet

### Test cases

## 270.

## 271.

## 272.

## 273. Integer to English Words (Hard)

### Corner cases
1. Input maybe zero
2. 11-19
3. 1000

### Solution
#### Best solution

Nothing special. Some of my tricks:
1. Write all the words in `final static`.
2. Put all strings in list and use `String.join(" ", ans)` to connect them together without worry about spaces.

## 274. H-Index (Medium)

Sort the array. Scan the array to find some entry that its value equals to the number of entries larger or equal to it.

### Faults:
1. **[WA]** The ans h may not appear in the array.

## 275. H-Index II (Medium)

Easier than #274.

## 276.

## 277. Find the Celebrity (Medium)

### Corner cases
1. Input maybe empty
2. Only one people there, then he is celebrity
3. Celebrity may do not exist 

### Solution 
1. Solution
One variable "cand", if cand doesn't know B, B cannot be celebrity, everything fine. If cand knows B, cand is not celebrity anymore, B maybe celebrity, change value of cand to B.
Then check whether everybody knows cand and cand doesn't know any of them.

### Bugs

### Test cases

## 278. First Bad Version

Binary search. But the choose of l and r could be tricky here.

Faults:

1. **[TLE]** [,) will loop by [1,3)
1. **[WA]** Change to (,] but with a wrong l to start. (Should be 0)
1. **[TLE]** Test with [,) again and figure out the [1,3) problem.
1. **[TLE]** When calculating mid = (l + r) / 2, overflow maybe happen.
1. **[TLE]** Typo.

## 279. Perfect Squares (Medium)

Dynamic programming.

``` java
ans[k] = Math.min(ans[k], ans[k - j * j] + 1)
```

## 280.

## 281.

## 282. Expression Add Operators (Hard)

### 1. Recursion with the record of last successive multiplys

Easier and clearer way.

### 2. Generate the whole and calculate by convert infix to postfix

One recursion to cut the nums, another recursion to generate operators.

Then use convert infix expression to postfix to calculate the value.

Compared with above solution, this one is quite complicated. I spent a lot of time on nearly 100 lines of code.

## 283. Move Zeros

Two pointers, one to find the non-zero numbers and one to store them from the beginning.

## 284. Peeking Iterator (Medium)

When you do peek(), just do next(), but use a variable to store the value. Keep returning this value to peek() until next next() request appears.

### Faults:
1.**[CE]** Confused 'left' and 'flag'.

## 285.

## 286.

## 287. Find the Duplicate Number (Medium)

Consider each number an linkedlist from the value of its index to the number. Then there will be several linkedlists point to the same node. In other words, we need to find a cycle in a linked list.

Then it is the same as #142.

## 288.

## 289. Game of Life (Medium)

The problem is we could not display the two status with one bit at the same time.

Then we could use two bits! Last bit for status at this turn, and first bit for status at next turn!

## 290. Word Pattern

When comparing two Strings, String.equals(s) should be used.
Also notice that the match should be a bijection.

## 291.

## 292. Nim Game

Check whether n % 4 equals 0.

## 293.

## 294.

## 295. Find Median from Data Stream (Hard)

### 1. Two Priority Queue

Two priority queue, one for the left half and one for the right.
Maintain the capacity of each priority queue according to sum size.

### 2. Binary Search Tree

Always search for the middle one or two in the BST.

## 296.

## 297. Serialize and Deserialize Binary Tree (Hard)

Convert the tree to preorder traversal, put "null" for null TreeNodes.

## 298.

## 299. Bulls and Cows (Medium)

Use one array to count characters.

## 300. Longest Increasing Subsequence (Medium)

The classical optimization (nlog(n) by binary search) for longest increasing subsequence.

## 301. Remove Invalid Parentheses (Hard)

### Corner Cases
1. The input string maybe valid itself.
2. Input string maybe empty.
3. There could be other characters in input.

### Bugs
1. `int len = s.length()`
2. Typo in variable names.
3. Forget to add methods together when two answers are the same.
4. Duplicate answers.

### Solutions

#### BFS:

#### DFS:

#### DP:

Dynamic prgramming. Every valid string could be made up by at most two ways: concatenate two valid strings together, or add ( and ) outside a valid string. We do DP based on these. 

Several special occasions need handle:
1. String length of one. If it is ( or ), we need to remove it. If it is other characters, we keep it and let the cost be 0.
2. When we get the same cost from two different ways, we need to add answer collections together.
3. There maybe duplicated in answers (e.g. "()()()"), so the collections should be stored in `HashSet`.

## 302.

## 303. Range Sum Query - Immutable

Prefix sum array.

## 304. Range Sum Query 2D - Immutable (Medium)

Including excluding principle.

## 306. Additive Number (Medium)

These methods are all very useful here:

```java
last = Long.parseLong(sa);
next = Long.parseLong(sb);

String tmps = Long.valueOf(tmp).toString();

if (!num.substring(base, num.length()).startsWith(tmps))
    break;
```

### Faults:
1. **[RE]** Input maybe larger than integer.

## 307. Range Sum Query - Mutable (Medium)

Binary indexed tree.

## 309. Best Time to Buy and Sell Stock with Cooldown (Medium)

``` java
for (int i = 0; i < prices.length; i ++) {
    int tmpCool = Math.max(cool, sell);
    sell = buy + prices[i];
    buy = Math.max(cool - prices[i], buy);
    cool = tmpCool;
}
```

## 310. Minimum Height Trees (Medium)

For every node, to calculate its depth, there are two depths to compare with: the bottom-up depth of its deepest son, or the top-down depth from its father. The top-down depth of its father may come from two ways: its own father, or another child.

Here is own solution:

1. One DFS, calculate all bottom-up depth, record the deepest child and second deepest child for each node.
2. Another DFS, calculate the top-down depth for each node and get the final depth. For each node, compare its top-down depth and bottom-up depth. And we need to pass its top-down depth to its children: the top-down depth of its own, or the depth of its son's brother. We recorded the two deepest children for each node, so the brother's depth will always be avaliable.

Finally, find the nodes with shallowest depth.

## 312. Burst Balloons (Hard)

Dynamic programming.

f[a][b] means all the balloons between a and b are burst. The last balloon be burst would be any balloon c between a and b. So we have:

```java
f[a][b] = Math.max(f[a][c] + f[c][b] + nums[a] * nums[c] * nums[b]);
```
nums[-1] and nums[n] would be helpful, add them in!

## 313. Super Ugly Number (Medium)

The same as #264 but we got k primes here other than 3 primes. So instead of compare them by hand, we will use a priority queue to maintain the minimum next answer. Be careful will the duplicates.

## 315. Count of Smaller Numbers After Self (Hard)

Sort numbers by them value and build binary indexed tree on there original index.

## 316. Remove Duplicate Letters (Hard)

Scan backwards. If every character already appeared at least once starts from position P, then any position before P is avaliable for an answer. So try to find the smallest character before P to get the best answer. After fix the position of this character, call the solve function again to fix the other ones.

## 318. Maximum Product of Word Lengths (Medium)

Use bit to stand wether one word contains some characters or not (26 bits which is less than 31 bits).
When comparing two words, just do and operation to these two numbers.

## 319. Bulb Switcher (Medium)

All the numbers with even factors will be off at last, left only those odd factors ones: square numbers.

## 321. Create Maximum Number (Hard)

Enumerate how many digits we select from each array and merge them together. During merging, we should compare whole postfix subarray instead of two single digits.

## 322. Coin Change (Medium)

The classic packback problem.


## 324. Wiggle Sort II (Medium)

### 1. Sort O(nlogn) + O(1)

### 2. findKthNumber + 3Partition O(n) + O(n)

### 3. findKthNumber + 3Partition + IndexMap O(n) + O(1)

## 325. Maximum Size Subarray Sum Equals k (Medium)

### Corner cases
1. Array element could be negative or zero
2. Target could be negative or zero

### Solution
1. HashMap
    - Time complexity: O(n)
    - Space complexity: O(n)

### Bugs

### Test cases

## 327. Count of Range Sum (Hard)

Obviously, we first transfer the array into prefix sum array sum[]. Then what we want to find here is two index i, j (i < j) in sum[] such that sum[j] - sum[i] is in the required range.

We solve this problem by merge sort.

To merge sort sum[l, r], we first merge sort recursively the left half sum[l, mid] and right half sum[mid, r]. Then we need to count pair i, j than cross mid, which means i fall in [l, mid) and j falls in [mid, r). We only need to count such pairs because pairs with i, j within the same region have been counted when merge sorting each half.

After count the pairs, merge left and right half together.

### Faults:

1. **[WA]** Sum may be long type.
2. **[TLE]** It will cost too much time and memory if you new a whole array during merging. Just new the part of array you need.

## 328. Odd Even Linked List (Medium)

Use two linked list head to store odd list nodes and even ones seperately, then combine them together.

## 329. Longest Increasing Path in a Matrix (Hard)

### 1. Memory Search O(NM)

But have the risk of stack overflow.

### 2. Dynamic Programming O(NM*log(NM))

Sort the elements and then do DP from the least to the largest.

### Faults:

1. **[RE]** `nums[i * col + j]` when you calculate the index of `matrix[i][j]` in 1-D array.

## 330. Patching Array (Hard)

We use one integer `found`, `found = i` indicates that 1 to i could all be made up. Then the next number we want to find is `found + 1`.

The next element in `nums[]` is `k` (`nums[]` is sorted), if `k <= found + 1`, we could have 1 to `found + k` all be made up. Otherwise, we need to add `found + 1` into the group, then the range we could make up will be 1 to `2 * found + 1`.

Why `found + 1`? If larger than `found + 1`, we still need one integer for `found + 1`. If less than `found + 1`, the range we get after insertion will be less.

## 331. Verify Preorder Serialization of a Binary Tree (Medium)

Simulate the process by a stack or one integer.

Notice that the tree maybe null.

## 332. Reconstruct Itinerary (Medium)

What we need to do here is actually find the "Euler Path".

We use a stack to find euler path. If the node at the top of stack has some edge that we have not visited, push the other end in. Otherwise, pop the top out, and push it into the answer list.

Reverse the answer list, then you will get the path we want.

## 334. Increasing Triplet Subsequence (Medium)

We use two variables to store the smallest element and second smallest during scanning. Update the `second` if element is bigger than `first` and smaller than `second`. But if element is smaller the `first`, we only update the `first`. 

This is because we must make sure `first` appears before `second`, we will not update `second` until some new suitable element appears after new `first`.

## 335. Self Crossing (Hard)

### 1. Queue and Intersect O(n) + O(1)

Use queue to store the six newest edges and use cross to judge if the newly added one intersects with any of them.

### 2. Improvement O(n) + O(1)

Don't use queue and cross anymore, just use the length of edges to judge.

### Faults:

1. **[WA]** The edges may run to (0, 0) again.

## 336. Palindrome Pairs (Hard)

### Enumerate two strings and test the combination O(N*N*L)

### Enumerate one string and length of the other string O(N*L*L)

### Faults:

1. **[TLE]** Solution 1 is not fast enough.
2. **[WA]** There maybe empty string in the input.

## 337. House Robber III (Medium)

TreeDP.

## 338. Counting Bits (Medium)

All the bits from (1 << k) to (1 << (k + 1) - 1) are the same as the bits from 0 to (1 << k - 1) except the highest bit.

## 341. Flatten Nested List Iterator (Medium)

Use stack to store elements. When list appears, the list should be opened to take out integer elements. As long as stack is not empty, there will be next element.

### Faults:
1. **[RE]** As there are empty lists, you should open the list before next `hasNext()` inquiry.

## 343. Integer Break (Medium)

Dynamic programming. The classic backpack problem.

## 344. Reverse String

StringBuilder.reverse().toString()

## 345. Reverse Vowels of a String

Two pointers, one points to vowels forwards and another backwards. Swap them pair by pair.

Faults:

1. **[WA]** Forgot to minus the back pointer after swapping.

## 346.

## 347. Top K Frequent Elements (Medium)

The problems asks for a O(n) solution.

The first step is all the same: calculate how many times each number appears which cost O(n).

Sorting them and getting the top K ones is the key point here. If we sort it normally then the complexity will be O(nlogn). But we can use bucket sort here since the largest times here will be `nums.length`.

## 348.

## 349. Intersection of Two Arrays
Use HashSet.

## 350. Intersection of Two Arrays II
Use HashMap. The times of num should be right.

Faults:

1. **[WA]** Used HashSet.

## 351.

## 352. Data Stream as Disjoint Intervals (Hard)

Union-Find.

Every numbers' father points to itself at first. When some number `val` is taken, point its father to `val + 1`. 

Start every number `val`, find its final father `fa`. If `fa == val` then it's empty. Else `[val, fa - 1]` will be an interval.

## 353.

## 354. Russian Doll Envelopes (Hard)

Sort the array accordig to widths increasingly then according to heights decreasingly. Then the problem is transfered into "finding the longest increasing subsequence" on heights dimension.

### Improvements:
1. `Arrays.sort(envelopes, new Comparator<int[]>(){});`
2. `Arrays.binarySearch();`

## 355. Design Twitter (Medium)

One list to store all the tweets.
One `Map<Integer, Set>` to store the maps from follower to followee.
Scan the tweets list backwards and check if the author of that tweet is followed by the user in query.
Remember to check if the user exists all the time.

### Faults:
1. **[WA]** User may unfollow himself in the input but his own tweet should always be showed.

## 356.

## 357. Count Numbers with Unique Digits (Medium)

Permutation and combination.

### Faults:

1. **[WA]** The answer should be one when n equals zero.

## 358.

## 359.

## 360.

## 361.

## 362.

## 363. Max Sum of Rectangle No Larger Than K (Hard)

As long as row numbers are much larger than column, we can enumerate the staring and ending column index of such rectangles. Then the sum of rectangle will become sum of 1-D array.

The problem is then transferred into: for index i, finding index j such that prefix sum of i minus prefix sum of j is the largest smaller or equal to k. For such index i, we can to find the smallest sum(j) that `sum(j) >= sum(i) - k`. We can use one TreeSet and its method `TreeSet.ceiling(num)` to find this sum(j).

## 364.

## 365. Water and Jug Problem (Medium)

### 1. BFS: Enumerate Jug X and Y Seperately (TLE)

### 2. BFS: Enumerate the Sum of Jug X and Y

### 3. Math Approach

`ax + by = kd` which means all the answers could be made from x and y must be  multiple of d, the GCD of x and y.

### Faults:

1. **[TLE]** Solution 1 turns out TLE.

## 366.

## 367. Valid Perfect Square

Binary search.

Faults:

1. **[TLE]** r + 1 and num * num maybe out of range. So use long instead.


## 368. Largest Divisible Subset (Medium)

Sort the array and then use quadratic DP.

## 369.

## 370.

## 371. Sum of Two Integers

Bit manipulation.

One short but meaningful code.

```
    while (b != 0) {
        int c = a & b;
        a ^= b;
        b = c << 1;
    }
```

## 372. Super Pow (Medium)

High precision and fast modular exponentiation.

## 373. Find K Pairs with Smallest Sums (Medium)

(i, j) means index pair in this solution. Build a minimum Priority Queue, add all (i, 0) pairs into PQ. Whenever you poll (i, j) out of the Priority Queue, try to push (i, j + 1) into to the PQ (if j + 1 is valid).

## 374. Guess Number Higher or Lower

Binary search.

## 375.

## 376.

## 377.

## 378.

## 379.

## 380.

## 381,

## 382.

## 383. Ransom Note

Use an array to count the numbers of characters.

## 384.

## 385.

## 386. Lexicographical Numbers (Medium)

DFS.

## 387. First Unique Character in a String

Use an array to count the numbers of characters.

## 388. Longest Absolute File Path (Medium)

Use a stack to store the structure.

Learn how to handle '\n' '\t' and '\\' in java.

### Faults:
1. **[WA]** The input is so disgusting that it mixed '\t' with "    ". And sometimes there maybe "    " in directory name.

## 389. Find the Difference

Use an array to count the numbers of characters.

## 390. Elimination Game (Medium)

Record the head position. Head position changes only when it is the odd turn or even turn but odd number of numbers left.

Move head position for `shift`. `shift` doubles every turn.

## 391. Perfect Rectangle (Hard)

I learnt so much from this problem !

In order to check if it is perfectly covered, we need to make sure:
1. The sum of all rectangles' area equals the covered area.
2. No rectangles are intersected.

The first condition is easy to check. To check the second condition, we have three solutions:

### Scan O(N * N)

Enumerate two rectangles are check if they are intersected.

### Calculate the corners O(N)

If the area is perfectly covered, then evey corner in this area is covered by even times. 
We can use a set to record times. But how could we know two corner object equals? We could store their values in string.

### Scan line O(N * log(N)) 

Split each rectangle into two parts: the starting part and ending part. Sort all of them according to x value, insert the rectangle into treeset when you meet the starting part and remove when meet the ending part. If the y values of two rectangles intersect with each other, which means the rectangles themself intersect.

#### Why TreeSet?

TreeSet is like set but with order. We can compare two elements during adding. 

#### Comparison method violates its general contract!

In java7, TimSort is used in `Arrays.sort()`. There are three must be obeyed:

> 1. The implementor must ensure that sgn(compare(x, y)) == -sgn(compare(y, x)) for all x and y.

> 2. The implementor must also ensure that the relation is transitive: ((compare(x, y)>0) && (compare(y, z)>0)) implies compare(x, z)>0.

> 3. Finally, the implementor must ensure that compare(x, y)==0 implies that sgn(compare(x, z))==sgn(compare(y, z)) for all z.

### Faults:
1. **[TLE]** Scan is not fast enough;
2. **[RE]** Wrong comparator.
3. **[WA]** Wrong ry calculation.

## 392. Is Subsequence (Medium)

One easy dynamic programming problem.

One array `match[]`, `match[j] = k` means `s[0:k] could be the subsequence of t[0:j]`.

`match[j] = match[j - 1] + 1` if `t[j] == s[match[j - 1] + 1]` else `match[j] = match[j - 1]`.

### Faults:

1. **[RE]** S and T could be empty string.

## 393. UTF-8 Validation (Medium)

String manipulation.

### Faults:

1. **[WA]** The input array may contain more than one character.

## 394. Decode String (Medium)

Almost the same as #224.

### Faults:

1. **[WA]** The inputs include not only lower cases but also upper cases.

## 395. Longest Substring with At Least K Repeating Characters (Medium)

The two ends of the answer must be letters appears less than k times in some substring. So we first mark out all letters with apperance less than k times in string s and check the substrings between. If it is illegal, then allow it to compete for the best answer. If not, check the substrings of it recursively.

### Faults:

1. **[WA]** Forget to check the substring between last marked letter and `end`.

## 396. Rotate Function (Medium)

If you write down the process for several steps, you will find the pattern.
```
    0 1 2 3 4
    1 2 3 4 0
    2 3 4 0 1
    3 4 0 1 2
    ...
```
```
F(p) = F(p - 1) + sum - n * A(n - p)
```

## 397. Integer Replacement (Medium)

Change the number `n` to binary. Then what we need to do now is to transfer this binary string to 1. 

We do this in three steps:
1. If the last bit is 0, divide number `n` by 2;
2. If the last bit is 1 and the second last is also 1, add `n` by 1;
3. If the last bit is 1 but the second last is 0, minus `n` by 1.

### Faults:
1. **[WA]** Number 3 is very special here.
2. **[RE]** The number maybe larger than `Integer.MAX_VALUE` after add one.

## 398. Random Pick Index (Medium)

Binary search the interval and random pick one from them.

### Faults:
1. **[RE]** Out of range may happen if you override compare function by `a.val - b.val`.

## 399. Evaluate Division (Medium)

The equations are actually path and the queries are for the distance between two nodes.

Use HashMap to store the paths and DFS to calculate the distance.

## 400. Nth Digit

There are 9 numbers with 1 bit, 90 with 2 bits, etc.

## 401. Binary Watch

Enumerate all the time expression and calculate its bits.

## 402. Remove K Digits (Medium)

Use a stack to store the characters. If the new input one is less than top, then top could be popped out. Our answer could even be an empty string, so input another '0' by the end.

## 403. Frog Jump (Hard)

1. DFS: Actually, most of the fastest solutions are in DFS.
2. DP: i(the i-th stone), k(width of the last step is k), reach[i][k] is true when such a condition is reachable. You have i and k, you can use a map to check whether the stone at (stones[i] - k) exists. Notice that the step increase at most 1 each time, so the largest jump width is (stones.length).
3. Better DP: Use a map of sets to record the steps to each stone, we don't need to enumerate the width anymoew. If one stone's set is empty, then it is unreachable, which replaces the reach[][].

## 404. Sum of Left Leaves

DFS.

Faults:

1. **[WA]** The left son should also be searched if it is not a leaf.

## 405. Convert a Number to Hexadecimal

When you want to get a long by 1 << 32, should use (long)1 << 32, because number is default int.

Faults:

1. **[WA]** Two’s complement should not be used on zero.

## 405.

## 406. Queue Reconstruction by Height (Medium)

Sort elements with height as the first keyword and k as the second keyword. Then always try to insert the element a[j] to position a[j].k. If such place has already been taken, then move forward. 

## 407. Trapping Rain Water II (Hard)

Priority Queue.

The heap holds elements with their position and the height of water they can hold. Whenever you pop out the heap top `cur`, try to visit the elements next to it that has not been visited. If the neighbour's height is larger than `cur.hold`, then the neighbour's `hold` is its own height. Otherwise, its `hold` equals to `cur.hold` (becaused we have already visited all paths with a less hold, so `cur.hold` is the least `hold` path it could be reached).

### Faults:
1. **[RE]** Input matrix maybe empty.

## 408.

## 409. Longest Palindrome

Calculate the number of letters.

## 410. Split Array Largest Sum (Hard)

Dynamic programming.

`f[a][k]` means the minimum value of largest sum of the k subarrays until position a. Calculate the prefix sum beforehand, and you will get the equation:
```
f[a][k] = Min{f[c][k - 1] + sum[a] - sum[c]} (c < a)
```

### Faults
1.**[WA]** The `Integer.MAX_VALUE` will appear in the input.

## 412. Fizz Buzz

For-loop.

## 413.

## 414. Third Maximum Number

Record m1, m2 and m3.

Faults:

1. **[WA]** The minimum could me Integer.MIN_VALUE, so the default value should be less than Integer.MIN_VALUE.
2. **[CE]** Type conversion errors.

## 415. Add Strings

High precision plus.

Faults:

1. **[RE]** When the length of the two strings are not the same, index out of range may happen.

## 416.

## 417.

## 418.

## 419.

## 420.

## 421.

## 422.

## 423.

## 424.

## 425.

## 426. Convert Binary Search Tree to Sorted Doubly Linked List (Medium)

### Corner cases
1. Input is empty
2. Input has only one node (point to itself?)
3. Is head the first or fakehead?

### Solution
1. Stack -> successor all the way down
    - Time complexity: O(n)
    - Space complexity: O(n)
2. DFS() with a node cur to record the last Node from left son
    - Time complexity: O(n)
    - Space complexity: O(1)

### Bugs
1. Input is empty! I wrote it in the corner cases but forget to test it.


### Test cases

## 427.

## 428.

## 429.

## 430.

## 431.

## 432.

## 433.

## 434. Number of Segments in a String

String.trim()
String.split("\\s+")

## 435.

## 436.

## 437. Path Sum III

Use DFS to push one element into the stack and poll it out.

Use a mapset to find the prefix sum would achieve a better performance.

Faults:

1. **[WA]** If the sum is 0, you could not choose nothing.

## 438. Find All Anagrams in a String (Easy)

### Corner cases
1. Could input string be empty?
(No, input strings are non-empty.)
2. Input p is one characters and string s consists of only character p.
3. Two string s and p are the same.
4. Upper case or lower case? 
(Lower case letters only.)
5. S is shorter than p.

### Bugs

### Solution
#### Best solution: slide window

Maintain a sliding window with size p.length(). One array head[] record the number of prefix characters to the end of this window, another array tail[] record prefix characters numbers before the slide window. Check if the difference equals to p.

- Time complexity: O(n)
- Space complexity: O(1)

## 461. Hamming Distance (Medium)

Bit Manipulation.

## 523. Continuous Subarray Sum (Medium)

### Corner cases
1. Element maybe zero 
2. Input could be empty
3. K maybe zero or negative

### Solution
1. We store the prefix sum mod k rather than prefix sum. When two prefix sum with the same remainder appears, we got our answer. In other word, if `nums.length > k` the answer is definitely true.
- Time complexity: O(n)
- Space complexity: O(k)

### Bugs
1. Should check whether k is negative before `nums.length > k`.

### Test cases


## 543. Diameter of Binary Tree (Easy)

### Corner case
1. Input maybe empty
2. Path may or may not go through the root
3. Only one node: root

### Solution
1. Recursive
    - Time complexity: O(n)
    - Space complexity: O(1)

### Bugs

### Test cases

## 560. Subarray Sum Equals K (Medium)

### Corner cases

### Solution
1. HashMap(prefixSum, times)

### Bugs
1. Add (0, 1) into map if subarray starts from the first element
2. `Map.getOrDefault(Object key, V defaultValue)`

### Test case

## 621. Task Scheduler (Medium)

### Corner cases
1. One specific task has much more duplicates that it should be executed as soon as cooling is done.
2. All kinds of interval should be done in turn though the waiting time between the same task is larger than cooling interval.
3. Input is empty.

### Bugs
1. The cool interval is n, so when you calculate, you need to add (n + 1).

### Solutions
#### Solution scan

Every time, choose the task which is available and with the largest amount left, put it in CPU and add (n + 1) to its next available time.

- Time complexity: O(n)
- Space complexity: O(1)

#### Best solution

Arrange the tasks with greatest amount by the cooling interval, and assume there will be less different than the interval length. If the assume is not possible, the length of tasks itself will become the answer. So return `Math.max(ans, tasks.length)` as the answer.

## 680. Valid Palindrom II (Medium)

### Corner cases
1. Input string is palindrome
2. Input string is empty
3. Only two characters in input: "ab"
4. Odd or even

### Solutions
1. ABA, check B (i, j): (i + 1, j) or (i, j - 1)
    - Time complexity: O(n)
    - Space complexity: O(n)

### Bugs
1. `String.substring(int beginIndex, int endIndex)` with `endIndex` exclusive

### Test cases
1. "abac"
    i = 0, j = 3  (1, 3) or (0, 2)
    (0, 2) -> true
2. "abca"
    i = 1, j = 2  (2, 2) or (1, 1)
    both true

## 689. Maximum Sum of 3 Non-Overlapping Subarrays (Hard)

### Corner cases
1. nums.length < 3 * k
2. nums[i] <= 0

### Solution 
1. DP
    f[n][3] 
    f[i][j] = Math.max(f[i - 1][j], f[i - k][j - 1] + sum[i] - sum[i - k])
    - Time complexity: O(n)
    - Space complexity: O(n)

### Bugs
1. Return the result as a list of indices representing the starting position of each interval.
2. If there are multiple answers, return the lexicographically smallest one.

### Test cases
1. 
    
    [1, 2, 1, 2, 6, 7, 5, 1]
        3  3  3  8 13 13 13
                6 11 16 21 21
                    19 23 23

## 703. Kth Largest Element in a Stream

Could be solved by all kinds of data structures.

I used this problem to practice heap.

## 721. Accounts Merge (Medium)

### Corner cases
1. Same name but two different people
2. Same people but different name

### Solution 
1. Union-find, use HashMap to store parents

### Bugs
1. Alice mail1 mail2; Alice mail3 mail4; Alice mail2 mail3 <- should be only one person

### Test cases

## 785. Is Graph Bipartite


### Corner cases
1. Only one point
2. No self edge
3. Some node may not be connected

### Solution
1. BFS
    - Time complexity: O(n)
    - Space complexity: O(n)
2. DFS
    - Time complexity: O(n)
    - Space complexity: O(n)

### Bugs

### Test cases
    0   false -> 1  true -> 3 true
    1   true  -> 2  false-> 0 false
    3   true  -> 2  false-> 0 false

## 786. Kth Smallest Prime Fraction (Hard)

This is a classic interview question from PonyAI.

### Corner Cases
1. Cases like [1, 3000] is strong enough.

### Bugs
1. Eps related operations are very delicated.
2. `Math.floor()` and `Math.ceil()` operations.

### Solutions
#### 1. Sort

N prime numbers in the array, then there will be at most n^2 fractions. Sort all of them and pick out the kth smallest one.

- Time complexity: o(n^2 log(n^2))
- Space complexity: o(n^2)

### HeapSort

Firstly add the smallest fraction into heap. Everytime you pop the top out of heap, push fractions next to it into the heap. Repeat this operation for K times.

- Time complexity: O(K log(n^2))
- Space complexity: O(n^2)

### Binary Search + TreeSet

Use binary search to enumerate the fractions from [0, 1], check if there is exactly K fractions from the array less than it (O(n) for each check). If so, find the greatest fractions less than it from the array. Such a operation could be done easily with the help of `TreeSet.floor()`.

- Time complexity: O(n log(1 / eps)) (1 / eps is nearly 10^7)
- Space complexity: O(n ^ 2)

## 792. Number of Matching Subsequences

Subsequences matching.

``` java
    public boolean match(String S, String str) {
        int i = 0, j = 0;
        while (i < S.length() && j < str.length()) {
            if (S.charAt(i) == str.charAt(j)) {
                i ++; j ++;
            } else i ++;
        }
        return j == str.length();
    }
```

## 793. Preimage Size of Factorial Zeroes Function

Multiples of 5 may have one 5 or several 5s. Check wether the number will drop at the number with one 5 or several 5s.
...
mod 156
mod 31
mod 6

## 794. Valid Tic-Tac-Toe State

Easy one.

## 795. Number of Subarrays with Bounded Maximum

O(n * n) Enumerate.

## 796. Rotate String

StringBuilder.substring(start, end + 1);

## 797. All Paths From Source to Target

DFS.

## 798. Smallest Rotation with Highest Score

For each a[i], there is an interval [l, r] in which the value of K drops will bring one point. So the problem changes into: for [l1, r1], [l2, r2], [l3, r3] ... find the value of K could drop in the intervals as many as possible.

Solution is quite tricky: use one array tag[]. For interval [li, ri], `tag[li] ++`, `tag[ri + 1] --`. Scan from left to right, add the value of tag[i], the result will be number of intervals collapse at this point.

Faults:

1. **[TLE]** Tried whether the O(N^2) solution would pass.

## 799. Champagne Tower

The same as number pyramid:
    1
    1 1
    1 2 1
    1 3 3 1
    ...

Faults:

1. **[RE]** When pour the bottom layer of the glasses, index may be out of range if the array is not big enough.


## 800. Similar RGB Color (Easy)

The conversion between string, hexadecimal number and decimal number.

Two useful method in java:
1. `Integer hexNum = Integer.parseInt(st, 16);`
2. `String hexStr = Integer.toHexString(num);`

Faults:

1. **[WA]** Inadequate description about output format.
2. **[WA]** Inadequate description about output format.
3. **[WA]** Inadequate description about output format.


## 801. Minimum Swaps To Make Sequences Increasing (Medium)

An obvious dynamic programming problem. (The problem could be devided into different stages. The best solution from last stage could serve in best solution for next stage.)

u[i] means minimum swaps if i-th elements are not swapped
s[i] means minimum swaps if i-th elements are swapped

    u[i] = min{c[i - 1], u[i - 1]}
    c[i] = min{c[i - 1] + 1, u[i - 1] + 1}

**Remember to check whether the strictly increasing rule is satisfied.**


## 802. Find Eventual Safe States (Medium)

### Approach 1

Find all nodes in a cycle and nodes could walk to a cycle, delete them from answer.

There are several mature solutions to find cycles in both BFS and DFS. You should pay more attention when using a DFS approach.

### Approach 2

Start from definite safe nodes (has no outgoing edge), use reversed edges to find safe nodes connected to these node. Implemented by BFS. (Detail: https://leetcode.com/articles/find-eventual-safe-states/)

Faults:

1. **[TLE]** Not enough optimization for DFS.


## 803. Bricks Falling When Hit (Hard)

A complicated and challengable problem.

### Approach 1

BFS. (My Solution https://github.com/mintycc/OnlineJudge-Solutions/blob/master/Leetcode/%23803_Bricks_Falling_When_Hit.java)

### Approach 2

Add bricks reversely and use disjoint-set-union to maintain the combination. (Detail: https://leetcode.com/articles/bricks-falling-when-hit/)

Faults:

1. **[WA]** Even though a brick will be erased, it may drop before the erasion.
2. **[TLE]** Use one boolean array to record visited bricks.

## 804. Unique Morse Code Words (Easy)

HashSet.

## 805. Split Array With Same Average (Hard)

DFS. I didn't find strong enough optimization during the contest. 

Notice that:
    (avg * B + avg * C) / (B + C) = avg

So both the two lists' average equals to the average of A.

One feasible optimization is like IDDFS, set the sum and num (sum = num * avg) of one list, try to find the answer. If no answer exists, try another range.

Faults:

1. **[WA]** Misunderstand the problem description.
1. **[WA]** x 4, test optimization.
1. **[TLE]** x 3, test optimization.

## 806. Number of Lines To Write String (Easy)

Easier than #68.

## 807. Max Increase to Keep City Skyline (Medium)

Find the largest value in one row and column.

## 808. Soup Servings (Medium)

DP.

The most conclusion in this problem is, when the N is so large (N / 25 > 500), the probability could be seen as 1

## 809. Expressive Words (Medium)

Could construct one regex and then use String.matches(regex) to match them.

Faults:

1. **[WA]** Didn't process the last character of S.
1. **[WA]** Didn't process the last character of word.

## 810. Chalkboard XOR Game (Hard)

https://leetcode.com/problems/chalkboard-xor-game/solution/

## 811. Subdomain Visit Count (Easy)

Two ways to go through a HashMap:

    for (Map.Entry<String, Integer> entry : map.entrySet())
        result.add(entry.getValue() + " " + entry.getKey());

    Iterator iter = map.entrySet().iterator(); // map.ketSet().iterator()
    while (iter.hasNext()) {
        Map.Entry entry = (Map.Entry) iter.next();
        result.add(entry.getValue() + " " + entry.getKey());
    }

Faults:

1. **[WA]** Misplace key and value.

## 812. Largest Triangle Area (Easy)

Both Heron Formula and determinant are okay.

Faults:

1. **[WA]** Something wrong with `Math.max(double, double)`? Use `Double.max(double, double)` next time.

## 813. Largest Sum of Averages (Medium)

O(N*N) DP.

1. Calculate prefix sum[];
2. Calculate avg[][] by sum[];
3. DP: res[i][k] k groups until the i-th number.

## 814. Binary Tree Pruning (Medium)

Recursion.

## 815. Bus Routes (Hard)

Convert the input array into map, then BFS.

**The most important optimization:** once you took some route, you will never take this route again in the best answer.

### Faults:

1. **[TLE]** Not fast enough.
2. **[TLE]** Not fast enough.
3. **[TLE]** Not fast enough.

## 816. Ambiguous Coordinates (Medium)

String manipulation.

### Faults:

1. **[WA]** Wrong range to add the decimal point.

## 817. Linked List Components (Medium)

HashSet + Iteration.

### Faults:

1. **[RE]** Stack overflow if recursion.

## 818. Race Car (Hard)

https://leetcode.com/problems/race-car/solution/

Tricks:
    
    Arrays.fill(dp, Integer.MAX_VALUE);
    int k = 32 - Integer.numberOfLeadingZeros(t);

## 819. Most Common Word (Easy)

HashMap.

## 820. Short Encoding of Words (Medium)

Arrays.sort()
String.endsWith(StringB)

## 821. Shortest Distance to a Character (Easy)

Scan forwards and backwards.

## 822. Card Flipping Game (Medium)

Problem description is crap.

Find the smallest number which doesn't appear on the front and back of the same card.


### Faults:

1. **[WA]** Crap description.
2. **[WA]** Crap description.

## 823. Binary Trees With Factors (Medium)

Dynamic programming.

wasy[i] means the ways of binary trees with i-th (sorted) value as the root.

ways[i] += ways[j] * ways[i / j];

## 824. Goat Latin (Easy)

StringBuilder.

## 825. Friends Of Appropriate Ages (Medium)

### 1. Scan O(N * N)
### 2. Queue Optimization O(N)

Special treatment for the same ages.

## 826. Most Profit Assigning Work (Medium)

Sort + Delete Duplicates + Binary Search.

## 827. Making A Large Island (Medium)

Floodfill, dye the islands with different colors, use one map to record the size of each island, then enumerate the block to change.

## 828. Unique Letter String (Hard)

For character ch, find the nearest same letter before it and after it, then all substrings between these two letters will have ch as unique letter. How to calculate it? Multiply the length on left and right together.

## 829. Consecutive Numbers Sum (Medium)

Actually we need to find x, y such that x * y == N.

## 830. Positions of Large Groups (Easy)

Scan.

## 831. Masking Personal Information (Medium)

String processing.

## 832. Flipping an Image (Easy)

Swap an array.

## 833. Find And Replace in String (Medium)

The only problem is if you replace some substring and its length is not the same, it will effect other replacements after.

So we could do the replacments backwards, just sort the index in ascending order in advance.

## 834. Sum of Distances in Tree (Hard)

Firstly, calculate `size[r]` (the size of subtree which has r as the root) and `collect[r]` (sum the distance from each node to root r) through recursion from bottom to top. Notice that `collect[r] += collect[son] + size[son]`.

Then, we could calculate the answer `dist[]` by `size[]` and `collect[root]` (`collect[root] == dist[root]`). Here is one important conclusion (`son` is one child of `r`'s ):

``` java
dist[son] = dist[root] - size[son] + (N - size[son]);
dist[son] = dist[root] + N - 2 * size[son]; // they are the same
```

## 835. Image Overlap (Medium)

Damn question.

### Faults:
1. **[WA]** Mind the difference between sliding, translation and rotation.

## 840. Magic Squares In Grid (Easy)

Scan.

### Faults:
1. **[WA]** Input maybe larger than 9.
2. **[WA]** Input maybe smaller than 1.

## 841. Keys and Rooms (Medium)

BFS.

## 842. Split Array into Fibonacci Sequence (Medium)

Same as #306.

### Faults:
1. **[RE]** Input maybe larger than long.

## 843. Guess the Word (Hard)

Record all the tries and randomize.

## 844. Backspace String Compare (Easy)

Use a stack for the two strings, pop the top out when you run into backspaces.

## 845. Longest Mountain in Array (Medium)

For each element, calculate the longest ascending subarray on its left side and right side, then combine them together.

## 846. Hand of Straights (Medium)

Use the sorted array to search what's the start of next group and hashmap to check if you still get some number left.

## 847. Shortest Path Visiting All Nodes (Hard)

State compression + dynamic programming.

f[status][pos] means the least step to achieve status `status` with ending at node `pos`. How we describe the whole status in an integer? Notice than there are at most 12 nodes in the test cases. We could use each bit of the integer to show whether one node has been visited. Then an integer with 12 bits is enough for show all of the status.

f[status][pos] may comes from f[status][posPre] or f[statusPre][posPre]. `posPre` and `pos` are connected and `statusPre = status xor (1 << pos)` which is the status than node `pos` has not been visited.

Notice than you may revisit node within the same status which means the f[status] array maybe updated in different directions. The solution is keep this update loop until no update was made.

## 848. Shifting Letters (Medium)

Shift the characters.

### Faults:
1. **[TLE]** You could not shift one character again and agian,  you should add all shifts together and do the shift in one time.
2. **[RE]** The shift distance itself maybe too large, you should mod 26 during the adding.

## 849. Maximize Distance to Closest Person (Easy)

Scan forwards and backwards.

## 850. Rectangle Area II (Hard)

Scan line.

Scan the area vertically. For the y-axis that some rectangles appear or disappear, calculate the length of x-axis that has been covered. The length of covered x-axis multiples the y-axis without rectangle appears or disappears, will be the area in this part.

## 851. Loud and Rich (Medium)

BFS.

## 852. Peak Index in a Mountain Array (Easy)

Scan.

## 853. Car Fleet (Medium)

Calculate the final time of each car's arrival ignoring the car fleet condition. Then find the increasing sequence in the time table. Only when the arrival time is larger the largest time arrived, a new car fleet will start.

## 854. K-Similar Strings (Hard)

Iteritive Deepening DFS. Enumerate how many swap should be taken at least, then DFS within this limitation.

## 855. Exam Room (Medium)

The problem description doesn't hold water because even though the range of n is 10^4 which requires a O(n * log(n)) solution, the actual range is 10^3 and one can pass with a O(n * n) solution.

### TreeSet O(n) Insert and O(log(n)) Remove

Scan all existed students while inserting and use treeset's remove while leaving.

### PriorityQueue without Map O(log(n)) Insert and O(n) Remove

Sort the gaps in the PriorityQueue. Split one gap when inserting one student and merge two gaps together when one student leaves.

The remove process here is O(n) because we don't have one map here the default remove in PriorityQueue is O(n).

### PriorityQueue with Map O(log(n)) Insert and O(log(n)) Remove

One HaspMap to map from the gap to its position in the PriorityQueue. Obviously we couldn't use the PriorityQueue provided by Java anymore and need to write by ourselves.

## 856. Score of Parentheses (Medium)

2-D for-loop.
`f[p][q]` stands for the value from pos p to pos q. Its value is larger than 0 if it is valid, less than 0 if not.

## 857. Minimum Cost to Hire K Workers (Hard)

First we define ratio = wage / quality.

What we want to achieve here is to find K workers so than the product of largest ratio and quality sum is the smallest.

We can sort all workers by their ratios, then enumerate the ratio from smallest to largest. If the ratio now is ratio[p], then we need to find the smallest k qualities from 1-p.

When p increases, how to find the k smallest qualities quickly? Use PriorityQueue.

## 858. Mirror Reflection (Medium)

If the light hits on the wall between 1 and 2, it will reflect back. But imagine instead let the light reflect, we extend the room infinitely. Then the width that light will pass will be the lcm of p and q.

## 859. Buddy Strings (Easy)

Calculate different letters and check if they are the same.

## 860. Lemonade Change (Easy)

Greedy problem. Each time use the largest possible bill for change.

## 861. Score After Flipping Matrix (Medium)

The leftest column is the most significant. The sum of all bits after the first bit is less than the one bit.

So we must make sure the first bit of each row is 1. The we check column by column to see whether flip this column will bring us more 1s.

## 862. Shortest Subarray with Sum at Least K (Hard)

As usual, we transfer then subarray problem to 'find two prefix sum'. Now the problem is finding two nearest index such that the difference between their prefix sum is larger than K.

We use a stack to maintain an ascending array while scaning the values. Once we have a index with a smaller prefix sum, the index before with larger prefix sum will never be our best answer. Once we got this ascending array, we could use binary search to find the best answer.

## 863. All Nodes Distance K in Binary Tree (Medium)

Notice that n is very small (n <= 500), we could use DFS or BFS to find the distance of all nodes directly.

## 864-. Random Pick with Blacklist (Hard)

Suppose the range is [0, n) and m of them are in the black list. We use a map to map these m numbers to the last m numbers in n. The produce the random number in range [0, n - m).

## 864. Shortest Path to Get All Keys (Hard)

BFS with Status Compression.

## 865. Smallest Subtree with all the Deepest Nodes (Medium)

Two DFS, one to calculate the depth and another to return subtrees.

## 866. Prime Palindrome (Medium)

Enumerate length of the number, then enumerate the first half of it. Produce the whole number and check whether it is a prime.

### Faults:
1. **[WA]** Input maybe 1.
1. **[WA]** Input maybe 2.

## 867. Transpose Matrix (Easy)

For-loop.

## 868. Binary Gap (Easy)

Nothing to say here.

## 869. Reordered Power of 2 (Medium)

Enumerate the power of 2 with the same length as input, then check if they have the same digits.

## 870. Advantage Shuffle (Medium)

Greedy solution.

Sort array A and B seperately. For each element in B, find the smallest possible element in A which is larger. 

## 871. Minimum Number of Refueling Stops (Hard)

### DP O(N^3)

`f[a][k] = max{f[b][k - 1] + fuel - dist}`, `f[a][k]` means we refuels at station a and we have refueled k times in total. Our last stop is station b.

### DP O(N^2)

`f[a][k][0] = f[a-1][k][0] or f[a-1][k][1] - dist`, `f[a][k][1] = f[a-1][k-1][0] or f[a-1][k][1] + fuel - dist`

### Priority Queue (NlogN)

We first dont refuel at any stop but push them into heap. When out fuel is not enough to get to the next stop, add the stop we have visited with the largest fuel into our answer.

### Faults:
1. **[TLE]** O(N^3) is not fast enough to pass.

## 872. Leaf-Similar Trees (Easy)

DFS.

## 873. Length of Longest Fibonacci Subsequence (Medium)

DP + HashMap.

## 874. Walking Robot Simulation (Medium)

Simulation + HashMap.

### Faults:
1. **[WA]** The problem wants the farthest distance from the origin, not the final position.

## 875. Koko Eating Bananas (Medium)

Binary search.

## 876. Middle of the Linked List (Easy)

Two node, one fast and one slow.

## 877. Stone Game (Medium)

Quadratic DP. Or just return true.

## 878. Nth Magical Number (Hard)

### Enumerate the madical number one by one (TLE)

### LCM

First calculate the LCM of A and B, and figure out k, the number of magical numbers in the range of LCM. Divide N by k, then we need that much LCM in the ans. Mod N by k, and enumerate the remaining part one by one, add that to the answer.

### Faults:
1. **[TLE]** Solution 1 will TLE.

## 879. Profitable Schemes (Hard)

Classic backpack problem. Regard number of people and profit as the two dimension volume limitation.

## 904. Fruit Into Baskets (Medium)

### Corner cases

1. Input maybe empty.
2. Input may have only one tree.
3. Input may have only one kind of trees.

### Bugs

1. [WA] After you clear one basket and put new fruit in, the new length should be the length of the subarray starting from last position of the eliminated fruit + 1 to the position now.

### Solution

#### Best Solution

The algorithm seems like LRU. Use pointers to record the two kind of fruits in your baskets and their recently visited position. When you facing a new tree, first check whether you already got this kind of fruit in you basket. If the answer is yes, increase your length and update recently visited position of this kind (basket). If the answer is no, clear the basket with the oldest recently visited position and put the new fruit in.

- Time complexity: O(n)
- Space complexity: O(1)

## 905. Sort Array By Parity (Easy)

### Corner Cases
1. Input array is empty.
2. All elements are odd or even.
3. Only one element in array.

### Bugs
1. Nope.

### Solution
#### Best Solution

One pointer i forwards and another pointer j backwards. Pointer i stops when it finds an odd number and pointer j stop when it find an even number. Swap elements at i and j. Continue.

- Time complexity: O(n)
- Space complexity: O(1)

## 906. Super Palindromes (Hard)

### Corner Cases
1. Use [L, L] on some specific number to test your program.
2. [1, 10^18 - 1] to test your time complexity.

### Bugs
1. [WA] `StringBuilder.reverse()` change the `StringBuilder` itself other than generate a new one.
2. [WA] The same as `StringBuilder.append()`.
3. Several trasfer functions between `String` and `Integer` does not support `StringBuilder` or `Long`.

### Solution 
#### Best Solution

Enumerate a Integer, make a palindrome from it, get check wether the square of that palindrom is also a palindrome and falls into the right range. The range of square is [1, 10^18], so it would be enough for us to enumerate to 10^5.

Also, Long type would be enough to store those two inputs.

The question would be a nice practice to check if you are clear about the conversion between number, string and stringbuilder.

## 907. Sum of Subarray Minimus (Hard)

### Corner Cases
1. Input is empty.
2. Only one element in input.
3. All the elements in input are the same.

### Bugs
1. [WA] First time try to find out all `left[]` and `right[]` by one scan without any data structures.

### Solutions
#### Best Solution - Stack

Actually, the problem is trying to find the range for each number, for every subarries in this range, the number will be the subarray's minimum.

Then, the question is transferred into finding such `left[]` and `right[]` standing for the left and right side of each number's range, with the initial value the position of the number itself.

We utilize a stack here, scan the array forwards. Before you push a new element in, pop out all elements greated than it. The farthest `left[]` of the elements it poped out will be its `left[]`.

One special occasion is if there are duplicates in the array. The subarray including both of them should only be calculated once. The solution is: in one direction, we pop out all elements greater than new element in the stack; in the other direction, we pop out all elements greater than or equal to the new element.