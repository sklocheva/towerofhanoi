# Tower of Hanoi task

### Overview
The Tower of Hanoi game consists of three pegs (A, B and C) and any number 
of disks stacked on one another in decreasing order. The disks are initially 
positioned on peg A.
The goal of the puzzle is to move the entire initial stack from peg A to peg C, 
while following the rules keeping the decreasing order and moving only one disk at a time.

### Solution
For the solution of this problem we created a Spring MVC program, which 
loads a simple page. The page accepts a positive number for the number disks 
needed for the calculation of the moves. After submission, the page displays 
the moves needed for finishing the Tower of Hanoi game.

### Algorithm
In order for the problem to be solved in minimum number of moves 
the top disk from first peg (A) should be moved to the middle peg (B), 
the bottom disk from the first peg (A) should be moved to the 
destination peg (C), then the top disk from the middle peg (B) should 
be moved to the destination (C). The number of moves nearly 
double every time we add a disk to the problem (2^n-1).

The Tower of Hanoi problem is solved using recursion in these steps:
- First we check if there is only one disk left, then we move it to 
the destination peg (C) and return the result.
- If there are more disks left we recursively move the top n-1 
disk from first peg (A) to middle peg (B).
- Then we move the leftover larger disks from initial peg (A) to destination (C)
- We recursively move the disks n-1 from middle peg (B) to 
destination peg (C).
The steps are repeated until there is one disk left.




