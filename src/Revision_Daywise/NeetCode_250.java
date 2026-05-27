package Revision_Daywise;

import java.util.HashMap;
import java.util.Map;

// For codes go to after line 130
public class NeetCode_250 {
    //Day 1 — Arrays
    //Revise:
    //	●	traversal
    //	●	prefix/suffix
    //	●	brute vs optimized
    //Problems:
    //	1.	LeetCode Two Sum
    //	2.	Best Time to Buy and Sell Stock
    //	3.	Contains Duplicate
    //Focus:
    //	●	HashMap usage
    //	●	O(n) thinking
    //⸻
    //Day 2 — Strings + Sliding Window
    //Problems:
    //	1.	Valid Anagram
    //	2.	Valid Palindrome
    //	3.	Longest Substring Without Repeating Characters
    //Focus:
    //	●	frequency counting
    //	●	two pointers
    //	●	sliding window intuition
    //⸻
    //Day 3 — Hashing
    //Problems:
    //	1.	Group Anagrams
    //	2.	Top K Frequent Elements
    //	3.	Encode and Decode Strings (understand idea even if premium)
    //Focus:
    //	●	HashMap patterns
    //	●	frequency logic
    //⸻
    //Day 4 — Recursion + Backtracking
    //Problems:
    //	1.	Fibonacci Number
    //	2.	Subsets
    //	3.	Combination Sum
    //Focus:
    //	●	recursion tree
    //	●	include/exclude pattern
    //⸻
    //Day 5 — Linked List
    //Problems:
    //	1.	Reverse Linked List
    //	2.	Merge Two Sorted Lists
    //	3.	Linked List Cycle
    //Focus:
    //	●	pointer manipulation
    //	●	slow/fast pointer
    //⸻
    //Day 6 — Stack + Queue
    //Problems:
    //	1.	Valid Parentheses
    //	2.	Min Stack
    //	3.	Daily Temperatures
    //Focus:
    //	●	monotonic stack idea
    //	●	stack intuition
    //⸻
    //Day 7 — Binary Search
    //Problems:
    //	1.	Binary Search
    //	2.	Search Insert Position
    //	3.	Search in Rotated Sorted Array
    //Focus:
    //	●	search space reduction
    //	●	boundary conditions
    //⸻
    //Day 8 — Trees Basics
    //Problems:
    //	1.	Invert Binary Tree
    //	2.	Maximum Depth of Binary Tree
    //	3.	Same Tree
    //Focus:
    //	●	DFS recursion
    //	●	tree traversal thinking
    //⸻
    //Day 9 — BST + Traversals
    //Problems:
    //	1.	Validate Binary Search Tree
    //	2.	Binary Tree Level Order Traversal
    //	3.	Lowest Common Ancestor of BST
    //Focus:
    //	●	BST properties
    //	●	BFS vs DFS
    //⸻
    //Day 10 — Heap / Priority Queue
    //Problems:
    //	1.	Kth Largest Element in a Stream
    //	2.	Last Stone Weight
    //	3.	K Closest Points to Origin
    //Focus:
    //	●	min heap vs max heap
    //	●	priority queue usage
    //⸻
    //Day 11 — Graph Basics
    //Problems:
    //	1.	Number of Islands
    //	2.	Clone Graph
    //	3.	Flood Fill
    //Focus:
    //	●	BFS/DFS traversal
    //	●	visited array/set
    //⸻
    //Day 12 — Mixed Revision Day
    //Redo WITHOUT seeing solutions:
    //	1.	Two Sum
    //	2.	Reverse Linked List
    //	3.	Maximum Depth of Binary Tree
    //Then:
    //	●	revise notes
    //	●	identify weak areas
    //⸻
    //Important Strategy
    //For EVERY problem:
    //Step 1
    //Try brute force yourself.
    //Step 2
    //Optimize.
    //Step 3
    //Write:
    //	●	pattern
    //	●	time complexity
    //	●	key intuition
    //Even 2 lines is enough.


    // Day-3 : Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        char arr[] = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        int n = arr.length;

        for(int right = 0; right < n; right++){
            int idx = map.getOrDefault(arr[right], -1);

            // 1. If we found a duplicate inside our window, shrink the window
            if(idx >= left){
                left = idx + 1;
            }

            // 2. ALWAYS record the length of the current valid window
            // Standard formula: right - left + 1
            res = Math.max(res, right - left + 1);

            // 3. Update the character's latest position
            map.put(arr[right], right);
        }

        // 4. Since 'res' was updated perfectly every step, just return it!
        return res;
    }
    public static void main(String[] args) {
        String s = "aabaadbc";
        System.out.println(new NeetCode_250().lengthOfLongestSubstring(s));
    }
}
