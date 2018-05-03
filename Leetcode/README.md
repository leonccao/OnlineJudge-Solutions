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

First change all characters to uppercase or lowercase, then check characters one by one.

Faults:

1. **[WA]** Alphanumeric characters include both letters and numbers.

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

## 157.

## 158.

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

### 1. QuickSort O(nlogn)
### 2. Heap O(nlogn)
### 3. QuickSelect O(n) https://en.wikipedia.org/wiki/Quickselect

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

## 225. Implement Stack using Queues (Easy)

Operation of LinkedList. O(n) to push or poll, kind of stupid.

## 226. Invert Binary Tree (Easy)

Easy one.

## 227. Basic Calculator II (Medium)

Same as #224.

## 228. Summary Ranges (Medium)

Scan.

## 229.

## 230.

## 231.

## 232. Implement Queue using Stacks

The inverted version of #225.

## 233.

## 234. Palindrome Linked List

> Could you do it in O(n) time and O(1) space?

Reverse the first half or last half, then compare each half front to end.

## 235. Lowest Common Ancestor of a Binary Search Tree

The given BST structure makes it easy to solve.

## 236. 

## 237. Delete Node in a Linked List

Just move the val and next from next node to this one.

Actually I was asked about this question for twice during auditions.

## 238.

## 239.

## 240.

## 241.

## 242.

## 243.

## 244.

## 245.

## 246.

## 247.

## 248.

## 249.

## 250.

## 251.

## 252.

## 253.

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

## 260.

## 261.

## 262.

## 263. Ugly Number

Divide all 2, 3 and 5 then check whether the remaining is 1.

## 264.

## 265.

## 266.

## 267.

## 268. Missing Number

Xor 0~n with all numbers in nums, the number left will be the result.

## 269.

## 270.

## 271.

## 272.

## 273.

## 274.

## 275.

## 276.

## 277.

## 278. First Bad Version

Binary search. But the choose of l and r could be tricky here.

Faults:

1. **[TLE]** [,) will loop by [1,3)
1. **[WA]** Change to (,] but with a wrong l to start. (Should be 0)
1. **[TLE]** Test with [,) again and figure out the [1,3) problem.
1. **[TLE]** When calculating mid = (l + r) / 2, overflow maybe happen.
1. **[TLE]** Typo.

## 279.

## 280.

## 281.

## 282.

## 283. Move Zeros

Two pointers, one to find the non-zero numbers and one to store them from the beginning.

## 284.

## 285.

## 286.

## 287.

## 288.

## 289.

## 290. Word Pattern

When comparing two Strings, String.equals(s) should be used.
Also notice that the match should be a bijection.

## 291.

## 292. Nim Game

Check whether n % 4 equals 0.

## 293.

## 294.

## 295.

## 296.

## 297.

## 298.

## 299.

## 300.

## 301.

## 302.

## 303. Range Sum Query - Immutable

Prefix sum array.

## 344. Reverse String

StringBuilder.reverse().toString()

## 345. Reverse Vowels of a String

Two pointers, one points to vowels forwards and another backwards. Swap them pair by pair.

Faults:

1. **[WA]** Forgot to minus the back pointer after swapping.

## 346.

## 347.

## 348.

## 349. Intersection of Two Arrays
Use HashSet.

## 350. Intersection of Two Arrays II
Use HashMap. The times of num should be right.

Faults:

1. **[WA]** Used HashSet.

## 351.

## 352.

## 353.

## 354.

## 355.

## 356.

## 357.

## 358.

## 359.

## 360.

## 361.

## 362.

## 363.

## 364.

## 365.

## 366.

## 367. Valid Perfect Square

Binary search.

Faults:

1. **[TLE]** r + 1 and num * num maybe out of range. So use long instead.


## 368. 

## 369.

## 370.

## 371. Sum of Two Integers

Bit manipulation.

One short but meaningful code.

    while (b != 0) {
        int c = a & b;
        a ^= b;
        b = c << 1;
    }

## 372.

## 373.

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

## 386.

## 387. First Unique Character in a String

Use an array to count the numbers of characters.

## 388.

## 389. Find the Difference

Use an array to count the numbers of characters.

## 400. Nth Digit

There are 9 numbers with 1 bit, 90 with 2 bits, etc.

## 401. Binary Watch

Enumerate all the time expression and calculate its bits.

## 402.

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

## 406.

## 407.

## 408.

## 409. Longest Palindrome

Calculate the number of letters.

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

## 426.

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

## 461. Hamming Distance (Medium)

Bit Manipulation.



## 792. Number of Matching Subsequences

Subsequences matching.

    public boolean match(String S, String str) {
        int i = 0, j = 0;
        while (i < S.length() && j < str.length()) {
            if (S.charAt(i) == str.charAt(j)) {
                i ++; j ++;
            } else i ++;
        }
        return j == str.length();
    }

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