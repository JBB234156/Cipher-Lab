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