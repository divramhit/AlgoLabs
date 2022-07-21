import java.util.Scanner;

public class Facebook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int facebookSize;

        System.out.println("Enter number of people on Facebook: ");
        facebookSize = input.nextInt();

        System.out.println("Enter nickname full name combinations: ");

        for (int i = 0; i < facebookSize; i++) {
            String line = input.nextLine();
            String[] info = line.split(" ");

            // to be continued


        }


    }
}
