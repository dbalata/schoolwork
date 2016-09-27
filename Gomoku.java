
import cs251.lab3.*;

//import java.util.Random;
/**
 * Gomoku
 * @author Dylan Balata
 * CS 251
 */
public class Gomoku implements GomokuModel {
    int rows = GomokuModel.DEFAULT_NUM_ROWS; //default 30
    int cols = GomokuModel.DEFAULT_NUM_COLS; //default 30
    int inLine = GomokuModel.SQUARES_IN_LINE_FOR_WIN; //default 5
    Square state[][] = new Square [cols][rows]; //board array
    Square winTracker = Square.RING; //indicates starting turn based on winner
    boolean player1; //true is player 1 false is player 2 or computer
    boolean bot = !false; //true if computer is enabled through command COMPUTER
    int lastTurnX; //X value of last turn made by player, used in computer turn
    int lastTurnY; // Y '''
    
    /**
     * Initializes game and decides if computer player
     * @param args COMPUTER to enable computer player
     */
    public static void main (String[] args) {
        Gomoku game = new Gomoku ();
            if (args.length > 0) {
                game.setComputerPlayer (args [0]);
            }
            GomokuGUI.showGUI ( game );
        }
    /**
     * Converts board array into 2D string
     * @return String representation of board
     */

    public String getBoardString() {
        String s="";
        for(int i=0; i<cols; i++){
            for(int j=0; j<rows; j++){
                if(state[i][j].equals(Square.EMPTY)){
                    s=s+"-"; // '-' denotes an empty space
                }
                if(state[i][j].equals(Square.RING)){
                    s=s+"O";
                }
                if(state[i][j].equals(Square.CROSS)){
                    s=s+"X";
                }
            }
            s=s+"\n";
        }
        return s;
    }
    /**
     * @return number of columns as determined by class variable
     */

    public int getNumCols() {
        return cols;
    }
    /**
     * @return number of pieces in a row to win as determined by class variable
     */
    public int getNumInLineForWin() {
        return inLine;
    }
    /**
     * @return number of rows as determined by class variable
     */
    public int getNumRows() {
        return rows;
    }
    /**
     * Places a piece for either player 1, player 2, or calls a method for 
     * computer player, also checks for draw and cycles turn.
     * @return Outcome of the game based on where piece is played
     * @param row and column values for piece being played
     */
    public Outcome playAtLocation(int arg0, int arg1) {
        if(checkDraw()){return Outcome.DRAW;}
        if(state[arg0][arg1].equals(Square.EMPTY)){
            if(player1){
                state[arg0][arg1]=Square.RING;
                if(checkDraw()){return Outcome.DRAW;}
                lastTurnX=arg0;
                lastTurnY=arg1;
                if(checkWin(arg0,arg1,Square.RING).equals(Outcome.RING_WINS)){
                    winTracker = Square.RING;
                    return Outcome.RING_WINS;
                }
            }
            if(bot){
                return criticalComputer();
            }
            if(!player1&&!bot){
                state[arg0][arg1]=Square.CROSS;
                if(checkDraw()){return Outcome.DRAW;}
                if(checkWin(arg0,arg1,Square.CROSS)==Outcome.CROSS_WINS){
                    winTracker = Square.CROSS;
                    return Outcome.CROSS_WINS;
                }
            }
            player1= !player1;
            if(checkDraw()){return Outcome.DRAW;}
            return Outcome.GAME_NOT_OVER;
        }
        if(checkDraw()){return Outcome.DRAW;}
        return Outcome.GAME_NOT_OVER;
    }
    /**
     * Loops over the board checking for an empty space
     * @return true if board is full and draw has occurred
     */
    public boolean checkDraw(){
        for(int i=0; i<cols; i++){
            for(int j=0; j<rows; j++){
                if(state[i][j].equals(Square.EMPTY)){return false;}
            }
        }
        return true;
    }
    /**
     * @param COMPUTER enables computer player
     */
    public void setComputerPlayer(String arg0) {
        if(arg0.equals("COMPUTER")){
        bot=true;
        }
    }
    /**
     * Loops over the board, searching for most valuable move
     * prioritizing offense. Checks for win on computer turn as well
     * @return Cross wins if computer has won, else game not over
     */
    public Outcome criticalComputer(){
        for(int i = inLine;i>0;i--){ //greater i is more valuable move
            for(int j = 0;j<cols;j++){
                for(int k = 0;k<rows;k++){
                    if((checkHorizontal(j,k,Square.CROSS)==i|| //offense
                    checkVertical(j,k,Square.CROSS)==i||
                    checkDiagonalForward(j,k,Square.CROSS)==i||
                    checkDiagonalBackward(j,k,Square.CROSS)==i)&&
                    state[j][k].equals(Square.EMPTY)){
                        state[j][k]=Square.CROSS;
                        if(checkDraw()){return Outcome.DRAW;}
                        if(checkWin(j,k,Square.CROSS)
                                .equals(Outcome.CROSS_WINS)){
                            winTracker=Square.CROSS;
                            return Outcome.CROSS_WINS;
                        }
                        return Outcome.GAME_NOT_OVER;
                    }
                    if((checkHorizontal(j,k,Square.RING)==i|| //defense
                    checkVertical(j,k,Square.RING)==i||
                    checkDiagonalForward(j,k,Square.RING)==i||
                    checkDiagonalBackward(j,k,Square.RING)==i)&&
                    state[j][k].equals(Square.EMPTY)){
                        state[j][k]=Square.CROSS;
                        if(checkDraw()){return Outcome.DRAW;}
                        if(checkWin(j,k,Square.CROSS)
                                .equals(Outcome.CROSS_WINS)){
                            winTracker = Square.CROSS;
                            return Outcome.CROSS_WINS;
                        }
                        return Outcome.GAME_NOT_OVER;
                    }
                
                }
            }
        }
        return Outcome.GAME_NOT_OVER; //should'nt be reached
    }
//    /**
//     * Randomly selects a space around last space occupied by player
//     * and plays there if empty, keeps searching in that direction if not,
//     * also checks if computer has won, made obsolete by criticalComputer
//     */
//    public Outcome computerTurn(){
//        System.out.println("pass");
//        Random rand=new Random();
//        int z = rand.nextInt(4) + 1;
//        int x=lastTurnX;
//        int y=lastTurnY;
//        if(x==cols)x--; // if statements used to prevent corner or side moves
//        if(x==0)x++;    // breaking for loops
//        if(y==rows)y--;
//        if(y==0)y++;
//        if(z==1){
//            for(int i=x;i<cols;i++){
//                if(state[i][y].equals(Square.EMPTY)){
//                    state[i][y]=Square.CROSS;
//                    if(checkWin(i,y,Square.CROSS)!=Outcome.GAME_NOT_OVER){
//                        winTracker = Square.CROSS;
//                        return Outcome.CROSS_WINS;
//                    }
//                    return Outcome.GAME_NOT_OVER;
//                }
//            }
//            return computerTurn();
//        }
//        if(z==2){
//            for(int i=x;i>=0;i--){
//                if(state[i][y].equals(Square.EMPTY)){
//                    state[i][y]=Square.CROSS;
//                    if(checkWin(i,y,Square.CROSS)!=Outcome.GAME_NOT_OVER){
//                        winTracker = Square.CROSS;
//                        return Outcome.CROSS_WINS;
//                    }
//                    return Outcome.GAME_NOT_OVER;
//                }
//            }
//        }
//        if(z==3){
//            for(int i=y;i<rows;i++){
//                if(state[x][i].equals(Square.EMPTY)){
//                    state[x][i]=Square.CROSS;
//                    if(checkWin(x,i,Square.CROSS)!=Outcome.GAME_NOT_OVER){
//                        winTracker = Square.CROSS;
//                        return Outcome.CROSS_WINS;
//                    }
//                    return Outcome.GAME_NOT_OVER;
//                }
//            }
//            return computerTurn();
//        }
//        if(z==4){
//            for(int i=y;i>=0;i--){
//                if(state[x][i].equals(Square.EMPTY)){
//                    state[x][i]=Square.CROSS;
//                    if(checkWin(x,i,Square.CROSS)!=Outcome.GAME_NOT_OVER){
//                        winTracker = Square.CROSS;
//                        return Outcome.CROSS_WINS;
//                    }
//                    return Outcome.GAME_NOT_OVER;
//                }
//            }
//            return computerTurn();
//        }
//        return Outcome.GAME_NOT_OVER;
//    }
    /**
     * Calls helper methods in order to check if someone has won
     * @param x which column turn was made in
     * @param y which row turn was made in
     * @param z type of piece
     * @return
     */
    public Outcome checkWin(int x, int y, Square z){
        if(checkHorizontal(x,y,z)>=inLine||
                checkVertical(x,y,z)>=inLine||
                checkDiagonalForward(x,y,z)>=inLine||
                checkDiagonalBackward(x,y,z)>=inLine){
                if(z.equals(Square.CROSS)){
                    return Outcome.CROSS_WINS;
                }
            return Outcome.RING_WINS;
        }
        return Outcome.GAME_NOT_OVER;
    }
    /**
     * Loops forward and backward along x axis near last play,
     * searching for inLine in a row
     * @param x which column turn was made in
     * @param y which row turn was made in
     * @param z type of piece
     * @return number "in row", may have 1 space gap (used in criticalComputer)
     */    
    public int checkHorizontal(int x,int y, Square z){
        int sum=1;
        int i=x+1;
        if(i<cols){
            while(state[i][y].equals(z)){
                sum++;
                i++;
                if(i>=cols){
                    break;
                }
            }
        }
        i=x-1;
        if(i>=0){
            while(state[i][y].equals(z)){
                sum++;
                i--;
                if(i<0){
                    break;
                }
            }
        }
        return sum;
    }
    /**
     * Loops up and down over y axis near last play, 
     * looking for inLine in a row
     * @param x which column turn was made in
     * @param y which row turn was made in
     * @param z type of piece
     * @return number "in row", may have 1 space gap (used in criticalComputer)
     */    
    public int checkVertical(int x,int y, Square z){
        int sum=1;
        int i=y+1;
        if(i<rows){
            while(state[x][i].equals(z)){
                sum++;
                i++;
                if(i>=rows){
                    break;
                }
            }
        }
        i=y-1;
        if(i>=0){
            while(state[x][i].equals(z)){
                sum++;
                i--;
                if(i<0){
                    break;
                }
            }
        }
        return sum;
    }
    /**
     * Loops in a "\" manner near last play looking for inLine in a row
     * @param x which column turn was made in
     * @param y which row turn was made in
     * @param z type of piece
     * @return number "in row", may have 1 space gap (used in criticalComputer)
     */
    public int checkDiagonalForward(int x,int y, Square z){
        int sum=1;
        int i=x+1;
        int j=y+1;
        if(i<cols&&j<rows){
            while(state[i][j].equals(z)){
                sum++;
                i++;
                j++;
                if(i>=cols||j>=rows){
                    break;
                }
            }
        }
        i=x-1;
        j=y-1;
        if(i>0&&j>0){
            while(state[i][j].equals(z)){
                sum++;
                i--;
                j--;
                if(i<0||j<0){
                    break;
                }
            }
        }
        return sum;
    }
    /**
     * Loops in a "/" manner near last play, looking for inLine in a row
     * @param x which column turn was made in
     * @param y which row turn was made in
     * @param z type of piece
     * @return number "in row", may have 1 space gap (used in criticalComputer)
     */
    public int checkDiagonalBackward(int x,int y, Square z){
        int sum=1;
        int i=x+1;
        int j=y-1;
        if(i<cols&&j>=0){
            while(state[i][j].equals(z)){
                sum++;
                i++;
                j--;
                if(i>=cols||j<0){
                    break;
                }
            }
        }
        i=x-1;
        j=y+1;
        if(i>=0&&j<rows){
            while(state[i][j].equals(z)){
                sum++;
                i--;
                j++;
                if(i<0||j>=rows){
                    break;
                }
            }
        }
        return sum;
    }
    /**
     * Wipes the board and gives first turn to winner of last game, default
     * first turn is given to ring
     */
    public void startNewGame() {
        for(int i=0; i<cols; i++){
            for(int j=0; j<rows; j++){
                state[i][j]=Square.EMPTY;
            }
        }
        if(winTracker.equals(Square.RING)){player1 = true;}
        if(winTracker.equals(Square.CROSS)&&bot){
            criticalComputer();
            player1= true;}
        if(winTracker.equals(Square.CROSS)&&!bot){
            player1= false;
        }
    }

}
