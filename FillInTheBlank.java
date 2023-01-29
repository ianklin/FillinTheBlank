import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class FillInTheBlank {
    public static void main(String[] args) throws IOException{
        Scanner read = new Scanner(System.in);
        String text = read.nextLine();
        String[] arr = text.split(" ");
        String[] test = arr.clone();
        System.out.println("How many blanks?");
        int n = read.nextInt();
        int[] randints = new int[n];
        Random rand = new Random();
        for(int i = 0; i <n; i++){
            randints[i] = rand.nextInt(arr.length);
        }
        Arrays.sort(randints);
        for(int i = 0; i <n; i++){
            test[randints[i]] = (i+1) + ". ________";
        }
        for(int i = 0; i < test.length; i++){
            System.out.print(test[i] + " ");
        }
        System.out.println();
        int score = 0;
        for(int i = 0; i < n; i++){
            System.out.println("what is blank #" + (i+1) + "?");
            String answer = read.next();
            if(answer.equals(arr[randints[i]])){
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
                System.out.println("Answer is: " + arr[randints[i]]);
            }
        }
        System.out.println("Score: " + ((score/arr.length)*100) + "%");
        read.close();
    }
}
