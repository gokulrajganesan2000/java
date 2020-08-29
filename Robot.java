/*
* Question:

Message controlled robot movement with 90 deg and 45 deg turning capability and 1 unit moving capability
Harish, an engineering student needs to submit his final year project. He decides to create a Robot which can be controlled by a set of instructions. He also decides that grid ( of  X and Y axis)should be defined and the robot  should move only within that grid. The set of instructions to move the robot should be given as a single message(string) and the Robot should accordingly move and reach the expected location. If the given instructions lead to a position which is out of the given grid, the Robot should stop at the last valid instruction.
Harish decides to write a code  that should process the given inputs and return a string representing the final position of the Robot.
The program will take 4 input parameters that define the size of the grid(X and Y axis), the current position of the Robot, and the message(string) containing the set of movement instructions.
The first two input parameters define the size of the grid.
input1 =X axis of the grid
input2=Y axis of the grid
Note that input1 and input2 will always be >0.So,the valid grid area for the robot's movement should be the rectangular area formed between the diagonal ends (0,0) and (X,Y)
The third parameter defines the current (starting) position of the robot.
Input3=current position of the robot, represented as a string containing 3 values separated by   a  -(hyphen). The format of input3 is x-y-D, where x and y represent the current(starting) position of the robot and D represents the direction where the robot is currently facing. Valid values for direction D are E,W,N, or S, representing East, West, North, and South respectively.
The fourth input parameter represents the single message containing the set of instructions to move the robot.
input4 =movement instructions to the robot, represented as a string containing the instructions separated by a space. The message will consist of a series of M,m,L,l,R or r ,where
M means "Move 2 unit forward in the direction that the robot is facing".
m means "Move 1 unit forward in the direction that the robot is facing".
L  means "Turn 90° towards left",
l  means "Turn 45° towards left",
R  means "Turn 90° towards right" and
r  means "Turn 45° towards right".
Note that for turning 45° the instructions used are lower case R(r) and lower case L(l), similarly for moving the robot by 1 unit, the insturction is lower case M(m)
Output expected to be printed by the program –
The program is expected to process the given inputs and print a string representing the final position of the Robot. The returned string should be of the format x-y-D, where x and y represent the final(end) position of the robot and D represents the direction where the robot is finally facing. Valid values for direction D are E,W,N,S,SE,SW,NE, NW representing East, West, North, South, South East, South West,North East, North West  respectively.
Note:
1.You can assume the grid to be similar to the 1st quadrant of the regular graph sheet. In a regular graph sheet of dimensions x units and y units,(0,0) is the bottom left corner and (X,Y) is the top right corner. Ex: For a grid of 5 x 5,the bottom left corner will be (0,0) and top right corner will be(5,5).
2.The starting position of the robot (third input parameter) will be any position on the grid.i.e.it need not always be (0,0)
3.You can assume that the current position (starting position, specified in input3) will always be a valid position within the specified grid.
4.IMPORTANT – Note that the instructions L,l,R and r only change the direction of the robot without moving it .The instruction M and m moves the robot 2 units and 1 unit respectively forward in the direction that the robot is facing.
5.A note about the instruction M and m
Note that the robot is facing North, South, East or West, the instruction M will make it move 2 units forwards North, South, East or West respectively AND the instruction m will make it move 1 unit forwards North, South, East or West respectively.
Similarly, if the robot is facing towards North-East, South-East, North-West or South-West, the instruction M will make it move 2 units forwards North-East, South-East, North-West or South-West respectively AND the instruction m will make it move 1 units forwards North-East, South-East, North-West or South-West respectively.
For Example, If the robot is at position (3,2) facing North-East, the instruction m will make it move to the position(4,3). Similarly, If the robot is at position (2,4) facing South-West, the instruction m will make it move to the position(1,3), i.e, for diagonal movements with m the movement is not exactly 1 unit, but to the diagonal end of the cell.
Similarly for the instruction M, the movement will be diagonally across 2 cells. If the robot is at position (3,2) facing North-East, the instruction M will make it move to the position(5,4). Similarly, If the robot is at position (2,4) facing South-West, the instruction M will make it move to the position(0,2),i.e, for diagonal movements with M the movement is not exactly 2 unit, but to the diagonal end of across 2 cells.
Invalid moves should not be allowed: Any move that could lead the robot to a position beyond (outside) the defined X and Y axis of the grid or below 0 on either X or Y axis, should be considered an invalid move.(see below examples to get clarity)
Example1-
input1: x=4
input2: y=4
input3: 1-1-N
input4: M R m R M L m
Output: 3-1-E
Explanation:
The size  of the grid 4x4 units. Current (starting) position of the robot is ( 1,1) facing North. After processing the set of instructions given in input4, the new position will be in (3,1) facing North. So, the program is expected to return the output in the format x-y-D i.e. 3-1-E
Example2-
input1: x=5
input2: y=4
input3: 1-2-E
input4: r M l m L M r
Output: 4-2-NE
Explanation:
The size of the grid is 5x4 units. Current (starting) position of the robot is (1,2) facing East. After processing the set of instructions given in input4,the new position will be in (4,2) facing North East. So, the function should return the output as 4-2-NE.
Example3-
input1: x=7
input2: y=7
input3: 4-6-SW
input4: M r m l M m R
Output: 1-4-SW-ER
Explanation:
The size of the grid is 7x7 units. Current (starting) position of the robot is (4,6) facing South west. After processing the set of instructions given in input4,the new position will be in (1,4) facing South West. Note that the 5th instruction(M) leads to a position outside the grid, so the valid moves stop at l which is the 4th instruction. In this case, the function is expected to return the output representing the last valid position appended with -ER representing ERROR. So, the function should return the output as 1-4-SW-ER.
IMPORTANT NOTE: The output format should be strictly as specified above. Any extra spaces before, after or within the output string will result in failure. Also, the alphabets in the output string should be in upper-case.
NOTE: The above few examples are only to help you understand the question. The actual test-case values will be different from these, so you must ensure to check the result for all possible cases.
* */

//Program:

package com.company;

import java.util.Scanner;

public class Robot {
    public static int x;
    public static int y;
    public static int curX;
    public static int curY;
    public static String curDirection;
    public static String getDirectionFour="SWNE";
    public static String[] getDirectionEight={"S","SW","W","NW","N","NE","E","SE"};

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        String[] initial;
        String[] instruction;

        x=scan.nextInt();
        y=scan.nextInt();
        initial=scan.next().split("-");
        scan.nextLine(); // clearing buffer
        instruction=scan.nextLine().split(" ");

        curX=Integer.parseInt(initial[0]);
        curY=Integer.parseInt(initial[1]);
        curDirection=initial[2];
        String currentPosition="";

        for(String ins:instruction){
            if (ins.equals("M") || ins.equals("m") ) {
                if((getDirectionFour.contains(curDirection))&& curDirection.length()==1) {
                    if (ins.equals("M")) {
                        moveFour();
                        moveFour();
                    } else {
                        moveFour();
                    }
                }
                else{
                    if (ins.equals("M")) {
                        moveEight();
                        moveEight();

                    } else {
                        moveEight();
                    }
                }
            } else if (ins.equals("L") || ins.equals("R")) {
                changeDirectionFour(ins);
            } else if (ins.equals("l") || ins.equals("r")) {
                changeDirectionEight(ins);
            }
            if(curX>=0 && curY>=0 && curX<=x && curY<=y) {
                currentPosition=curX+"-"+curY+"-"+curDirection;
            }
            else {
                currentPosition+="-ER";
                break;
            }
        }
        System.out.println(currentPosition);
    }
    public static void moveFour(){
        if(curDirection.equals("E")){
            curX++;
        }
        if(curDirection.equals("W")){
            curX--;
        }
        if(curDirection.equals("N")){
            curY++;
        }
        if(curDirection.equals("S")){
            curY--;
        }
    }
    public static void moveEight(){
        if(curDirection.equals("NE")){
            curX++;
            curY++;
        }
        if(curDirection.equals("NW")){
            curX--;
            curY++;
        }
        if(curDirection.equals("SE")){
            curX++;
            curY--;
        }
        if(curDirection.equals("SW")){
            curY--;
            curX--;
        }
    }
    public static void changeDirectionFour(String deg){
        if(deg.equals("L")){
            if(getDirectionFour.indexOf(curDirection)!=0){
                curDirection=""+getDirectionFour.charAt(getDirectionFour.indexOf(curDirection)-1);
            }
            else{
                curDirection=""+getDirectionFour.charAt(getDirectionFour.length()-1);
            }
        }
        else {
            if(getDirectionFour.indexOf(curDirection)!=getDirectionFour.length()-1){
                curDirection=""+getDirectionFour.charAt(getDirectionFour.indexOf(curDirection)+1);
            }
            else{
                curDirection=""+getDirectionFour.charAt(0);
            }
        }
    }
    public static void changeDirectionEight(String deg){
        if(deg.equals("l")){
            if(findIndex(getDirectionEight,curDirection)!=0){
                curDirection=""+getDirectionEight[findIndex(getDirectionEight,curDirection)-1];
            }
            else {
                curDirection=""+getDirectionEight[getDirectionEight.length-1];
            }
        }
        else{
            if(findIndex(getDirectionEight,curDirection)!= getDirectionEight.length-1){
                curDirection=""+getDirectionEight[findIndex(getDirectionEight,curDirection)+1];
            }
            else {
                curDirection=""+getDirectionEight[0];
            }
        }
    }

    public static int findIndex(String[] array, String key) {
        int returnValue = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key.equals(array[i])) {
                returnValue = i;
                break;
            }
        }
        return returnValue;
    }
}
