import java.util.Scanner;


public class CipherRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int cipher = 0;
        boolean isValid = false;

        do
        {
            try {
                System.out.println("CHOOSE A CIPHER TO USE: " + "\n" +
                    "1. Ceaser Cipher" + "\n" +
                    "2. Glrbaflemd"
                );


                cipher = input.nextInt();
                input.nextLine();


                isValid = true;
            } catch (Exception e) {
                input.nextLine();


            }


            if (cipher == 1)
            {
                System.out.println();
                System.out.println("Enter a string to encrypt: ");
                String message = input.nextLine();


                System.out.print("Enter a shift value: ");
                int shift = input.nextInt();


                String ceaserMessage = CeaserCipher.ceaser(message, shift);
                System.out.println("Ceaser Cipher:" + ceaserMessage);
            }
            else if (cipher == 2)
            {
                System.out.println();
                System.out.print("Enter a string to encrypt: ");
                String message = input.nextLine();

                System.out.print("Enter a key: ");
                Long key = input.nextLong();

                String glrbaflemdMessage = Glrbaflemd.bestCipherEver(message, key);
                System.out.println(glrbaflemdMessage);
            }
            else
            {
                System.out.println();
                System.out.println("that is not an option...");
            }
           
        } while (isValid == false || (cipher != 1 && cipher != 2));
       
    }
}
