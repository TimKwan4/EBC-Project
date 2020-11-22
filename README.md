# EBC-Project
Example project following the entity, boundary, controller pattern

The goal of the game is to combine the number tiles until only one tile remains in the center of the board.

A user can select a piece and move it up,down,left,or right. 

Each direction combines 2 tiles using a different math computation.

Example puzzle:
[3,6,4]
[1,7,9]
[2,5,8]

Move Right to add: Move 1 right to 7, to add 1 to 7, resulting in 1+7 = 8
Move Left to subtract: Move 4 left to 6, to subtract 4 from 6, resulting in 6 - 4 = 2
Move Up to multiply: Move 5 up to 7, to multiply 7 by 5, resulting in 5 x 7 = 35
Move Down to divide: Move 1 down to 2, to divide 1 into 2, resulting in 2 ¸ 1 = 2; valid only if the result is an integer
