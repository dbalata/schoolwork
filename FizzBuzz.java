/**
 * @author Dylan Balata
 * CS251 Lab 1 FizzBuzz
 * Due September 2, 2016
 */
public class FizzBuzz {
    
    /**
     * Takes 3 command line arguments and prints numbers from one
     * to arg 0 replacing numbers divisible by arg 1 with Fizz,
     * divisible by arg 2 with Buzz, and divisible by both with FizzBuzz.
     * @param args
     */
    
    public static void main(String[] args){
        
        int max = Integer.parseInt(args[0]);
        int fizz = Integer.parseInt(args[1]);
        int buzz = Integer.parseInt(args[2]);
        
        for(int i = 1; i <= max; i++){
            if(i%fizz==0&&i%buzz!=0){
                System.out.println("Fizz");
            }
            if(i%buzz==0&&i%fizz!=0){
                System.out.println("Buzz");
            }
            if(i%buzz==0&&i%fizz==0){
                System.out.println("FizzBuzz");
            }
            if(i%buzz!=0&&i%fizz!=0){
                System.out.println(i);
            }
        }
    }
}
