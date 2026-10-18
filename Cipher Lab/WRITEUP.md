**Cipher Lab Write-Up**

Part 1: Pre-Lab

To answer these questions, watch the following video: [The Science of Codes: An Intro to Cryptography](https://www.youtube.com/watch?v=-yFZGF8FHSg) by SciShow.

1. **Show your work**. Use a Caesar Cipher with a right shift of 4 to encrypt the word “HOLIDAY”.

	LSPMHEC 

2. **Show your work.** Use a Caesar Cipher with a left shift of 2 to encrypt the word “WEEKDAY”.

   YGGMFCA

   

 


3. If a Caesar Cipher uses a right shift of 28, what is an equivalent RIGHT shift value to use?

ANSWER: 1

4. If a Caesar Cipher uses a left shift of 5, what is an equivalent RIGHT shift value to use?

ANSWER: 21

5. If a Caesar Cipher uses a left shift of 30, what is an equivalent LEFT shift value to use?

ANSWER: 4

6. If a Caesar Cipher uses a right shift of 4, what is an equivalent LEFT shift value to use?

ANSWER: 22

Part 2: Encrypt Caesar Cipher

**Directions**: Create a method that accepts two parameters: a String to encrypt, and a shift key for the Caesar cipher. Your method should return the encrypted version of that String. Use your work shown for questions 1 and 2 to help you write this method. 

Additionally, below is a sample code with test cases. You may copy and modify this as desired. 

```java
public class CipherLab {
public static void main(String[] args) 
{
String test1 = encryptCaesar("AaBbCc", 3);
//test1 shifts each letter right 3, maintaining case
//test1 should contain: "DdEeFf"

String test2 = encryptCaesar("abc!?", -2);
//test1 shifts each letter left 2, maintaining non-letters
//test2 should contain: "yza!?"
}
public static String encryptCaesar(String original, int key) 
{
/* code not shown */
}
}
```

Once complete, copy and paste your code (or a screenshot of your code) in the section below:

```java
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
                System.out.println("Enter a string to encrypt:");
                String message = input.nextLine();

                System.out.println("Enter a shift value:");
                int shift = input.nextInt();

                String ceaserMessage = CeaserCipher.ceaser(message, shift);
                System.out.println("Ceaser Cipher:" + ceaserMessage);
            }
            else if (cipher == 2)
            {
                System.out.println();
                System.out.println("Enter a string to encrypt:");
                String message = input.nextLine();

                String glrbaflemdMessage = Glrbaflemd.bestCipherEver(message);
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


public class CeaserCipher {
    public static String ceaser(String message, int shift) {
        String currentCheck;
        int encLetterPos;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String encString = "";
        String letterToBeEnc;
        String encLetter;

        for (int i = 0; i < message.length(); i++)
        {
            currentCheck = message.substring(i, i+1);
            letterToBeEnc = currentCheck.toLowerCase(); // makes it so the computer can find the letter in the alphabet

            if (!alphabet.contains(letterToBeEnc)) encString += currentCheck;
            else
            {
                encLetterPos = alphabet.indexOf(letterToBeEnc) + shift;
                encLetter = alphabet.substring(encLetterPos, encLetterPos+1);

                // the only reason this would be true is if currentCheck isn't lowercase
                if (!currentCheck.equals(letterToBeEnc)) encLetter = encLetter.toUpperCase();

                // subtracts 26 until the cipher is accurate
                while (encLetterPos > 26)
                {
                    encLetterPos -= 26;
                }

                encString += encLetter;
            }
        }

        return encString;
    }
}  



```

7. Refer to your code above, and find a conditional statement. Explain your use of this conditional statement, and its function in your program. 

`if (!currentCheck.equals(letterToBeEnc)) encLetter = encLetter.toUpperCase();`

I used this to check if the inserted character I'm assessing at that iteration of the loop as lowercase is the same as the normal character. If it is, then the char is normally lowercase, and should stay as such. If not, then the normal character is uppercase and should be converted as such

8. Refer to your code above, and find a loop you used. Explain your use of this loop, and its function in your program. Justify your choice of this type of loop (while, for, do-while, etc.)

`while (encLetterPos > 26)`  
`{`  
    `encLetterPos -= 26;`  
`}`

If the shift is set over 26, and the computer tries that, I’ll get an indexOutOfBounds error b/c the alphabet is only 26 characters. But any shift \>26 is the same as going the same way shift \- 26 times, so this script subtracts 26 until the shift is 26 or less

Part 3: Another Cipher

**Directions**: Identify a historical cipher, or design your own. In the space below, describe your cipher using examples of how to encrypt text. A valid cipher must have the following:

- [x] ~~Well defined steps for the encryption algorithm, that can be recreated by someone with knowledge of your cipher.~~  
- [x] ~~Some method of decrypting. In other words, the defined steps in the first bullet point can be reversed if one knows the method.~~   
- [x] ~~A way to maintain unique characteristics of grammar in the English language. In other words, your cipher should deal with punctuation and special characters ( . , \! ? ; \- ) in a different manner than uppercase and lowercase letters, maintaining that data in the encrypted string.~~

9. Describe and plan the code for your cipher in the space below. You may write out the steps using a list, or a pseudocode flowchart. Refer to the slides for examples of pseudocode control flowcharts.  
- Take a message and a key  
- Use the random class with an inputted seed to do some random bullshit to make it very different if you change just one bit  
    
    
    
    
  


10. Write three test cases for your cipher or chosen cipher, showing inputs and expected outputs.   
    Input: hello\\, with a key of 9987  
    Output: \-6681373699092098975-2453325707483110039-39622016617853731-2791843213154164613-6957729675865292212-7372551187817670499  
    Input: hello?, with a key of 9987  
    Output:  
    \-6681373699092098975-2453325707483110039-39622016617853731-2791843213154164613-6957729675865292212-7372551187817670499  
    Input: hella, key 9678  
    Output: \-5044049111070171104-938770424779715295-35234707210033788-6788347139955857165-6322955039954497692  
      
  


11. Create a second method in your program to encrypt a string in your cipher or chosen cipher. Once complete, copy and paste your code (or a screenshot of your code) in the section below:

```java
import java.util.Random;

public class Glrbaflemd {
    public static String bestCipherEver(String message, long key)
    {


        String alphabet = "pozecgfqjvakwimsdthxyunblr";
        String numbers = "0798463521";
        String specialChars = "~!@#$%^&*()_+{}|:L<>?,./;'[]-=\\";
                   
        String encMessage = "";
        String currentCheck;
        String hotOffThePress;
        Random rand = new Random(key);


        int randIsStupid = rand.nextInt() * rand.nextInt() + message.length();
        Random rand2 = new Random(randIsStupid);


        for (int i = 0; i < message.length(); i++)
        {
            currentCheck = message.substring(i, i+1);
            hotOffThePress = currentCheck.toLowerCase();


            if (!alphabet.contains(hotOffThePress) && numbers.contains(hotOffThePress)) encMessage += -1 * Math.abs(rand.nextInt() + (numbers.indexOf(hotOffThePress) + 1) * rand2.nextLong() + (message.length() * rand2.nextInt()));
            else if (specialChars.contains(hotOffThePress))
            {
                encMessage += -1 * Math.abs(randIsStupid + rand2.nextLong() * (specialChars.indexOf(hotOffThePress) + 1) * rand2.nextLong());
            }
            else
            {
                encMessage += -1 * Math.abs(rand.nextLong() * ((alphabet.indexOf(hotOffThePress) + 1) * randIsStupid) * rand2.nextLong() * rand.nextLong() + i);
            }
        }
        return encMessage;
    }
}



```

12. Submit this completed lab write-up on Canvas, along with a link to your final project. You may paste that in the space below, or on Canvas: 

|  |
| :---- |

