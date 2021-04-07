# CountRectangles

Requirements: 
- Given some points in cartesian coordinate, (X, Y) find the number of rectangles that can be created 
by those points. Take into consideration only the rectangles that are parallel with the X, Y axes. 

Algorithm descrition:
- I supposed that the points are given in a file in the format (x,y) and points from the same line separated by ";".
- The result is printed in the console.
- First, I go through the list with two for loops in order to find two points that have different coordinates X and Y (two opposed corners of the rectangle), and then I know that the other two points I need in order to form the rectangle are: the one with the coordinate X of the first point and the coordinate Y of the second and the one with the coordinate X of the second point and the coordinate Y of the first. To check if those two points exist in the given list I have one more loop that starts from the next element after the point at the index from the first loop, in order to count one rectangle only once.

