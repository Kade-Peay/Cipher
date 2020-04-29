import java.util.Scanner;

public class Cipher {

    public static void main(String[] args) {
        Scanner textInput = new Scanner(System.in);
        Scanner shiftInput = new Scanner(System.in);

        System.out.print("Please enter text to run through cipher: ");
        String input = textInput.nextLine();

        System.out.println();

        System.out.print("Please enter shift: ");
        int shift = shiftInput.nextInt();

        //after getting the input close the scanners
        textInput.close();
        shiftInput.close();

        String crypted = encrypt(input, shift);
        String decrypted = decrypt(crypted, shift);

        System.out.println("--- Before Cipher ---");
        System.out.println(input);
        System.out.println();

        System.out.println("--- After Cipher ---");
        System.out.println(crypted);
        System.out.println();

        System.out.println("--- After Decrypt ---");
        System.out.println(decrypted);
        System.out.println();
    }

    public static String encrypt(String plainText, int shift) {
        if(shift > 26) {
            shift = shift % 26;
        }
        else if(shift < 0) {
            shift = (shift % 26) + 26;
        }

        String cipherText = "";
        for(int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if(Character.isLetter(ch)) {
                if(Character.isLowerCase(ch)) {
                    char c = (char)(ch + shift);
                    if(c > 'z') {
                        cipherText += (char)(ch - (26 - shift));
                    }
                    else {
                        cipherText += c;
                    }
                }
                else if(Character.isUpperCase(ch)) {
                    char c = (char)(ch + shift);
                    if(c > 'Z') {
                        cipherText += (char)(ch - (26 - shift));
                    }
                    else {
                        cipherText += c;
                    }
                }
            }
            else {
                cipherText += ch;
            }
        }
        return cipherText;
    }

    public static String decrypt(String plainText, int shift) {
        if(shift > 26) {
            shift = shift % 26;
        }
        else if(shift < 0) {
            shift = (shift % 26) + 26;
        }

        String cipherText = "";
        for(int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if(Character.isLetter(ch)) {
                if(Character.isLowerCase(ch)) {
                    char c = (char)(ch - shift);
                    if(c < 'a') {
                        cipherText += (char)(ch + (26 - shift));
                    }
                    else {
                        cipherText += c;
                    }
                }
                else if(Character.isUpperCase(ch)) {
                    char c = (char)(ch - shift);
                    if(c < 'A') {
                        cipherText += (char)(ch + (26 - shift));
                    }
                    else {
                        cipherText += c;
                    }
                }
            }
            else {
                cipherText += ch;
            }
        }
        return cipherText;
    }
}
