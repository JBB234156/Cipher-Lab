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
            encLetterPos = alphabet.indexOf(letterToBeEnc) + shift;
            encLetter = alphabet.substring(encLetterPos, encLetterPos+1);

            System.out.println(currentCheck);
            System.out.println(letterToBeEnc);

            // the only reason this would be true is if currentCheck isn't lowercase
            if (!currentCheck.equals(letterToBeEnc)) encLetter.toUpperCase();

            // subtracts 26 until the cipher is accurate
            while (encLetterPos > 26)
            {
                encLetterPos -= 26;
            }

            encString += encLetter;
        }

        return encString;
    }
}   
