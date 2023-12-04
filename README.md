# Inversion-Counting
Counting the number of inversions in an array.
- An `Inversion` is when a pair of numbers are out of their natural order.

## Inversion Counting (1 Array) Problem

### Problem Description
The input will start with an positive integer, giving the number of instances that follow. For each instance, there will be a positive integer, giving the number of elements in the list.

### Sample Input
2<br>
5<br>
5 4 3 2 1<br>
4<br>
1 5 9 8

### Sample Output
10<br>
1

### Sample Input and Output Description
The sample input has two instances. The first instance has 5 elements and the second has 4. For eachinstance, your program should output the number of inversions on a separate line.

### Time Complexity
The time complexity of the optimal inversion counting problem for 1 array is **O(n * log(n))**.

### Run the Code


## Inversion Counting (2 Arrays) Problem

### Problem Description
Suppose you are given two sets of n points, one set {p1, p2, . . . , pn} on the line y = 0 and the other
set {q1, q2, . . . , qn} on the line y = 1. Create a set of n line segments by connecting each point pi to
the corresponding point qi. Your goal is to develop an algorithm to determine how many pairs of these
line segments intersect. Your algorithm should take the 2n points as input, and return the number of
intersections. Using divide-and-conquer, your code needs to run in O(n log n) time.
Hint: How does this problem relate to counting inversions in a list?
Input should be read in from stdin. The first line will be the number of instances. For each instance,
the first line will contain the number of pairs of points (n). The next n lines each contain the location x
of a point qi on the top line. Followed by the final n lines of the instance each containing the location x
of the corresponding point pi on the bottom line. For the example shown in the figure below, the input is properly
formatted in the first test case below.
<img width="444" alt="Screenshot 2023-12-04 at 11 32 06 AM" src="https://github.com/adityakmehrotra/Inversion-Counting/assets/24847438/79a2ab06-1ab4-4cda-9dda-c79fa063e603">

