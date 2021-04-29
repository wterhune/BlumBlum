import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/*
2. (15 points) You are going to develop a program that uses pseudorandom bits to encrypt text.
•	Implement the Blum-Blum-Shub PRNG as specified in the textbook in section 5.1
(Pseudorandom bit generation) in a method that returns a list of bits.
The method takes the parameters p, q, x, and count. The first three are as specified in the BBS algorithm.
The count parameter specifies how many bits to generate.
•	Write a method that takes as a parameter a list of bits as
a plaintext string and a list of key bits and that returns a list of ciphertext bits.
•	Write a main method or main program that reads in a textfile called bbstext.txt containing 4 lines:
o	value for p
o	value for q
o	value for x
o	plaintext bit string
•	It then uses the above methods to encrypt that plaintext string and then prints the ciphertext bit string.

 */
public class BlumBlum {

    public static void main(String[] args) throws IOException {

        File fileName = new File("/Users/u390445/workspace/Crypto-HW-2/src/bbstext.txt");
        Scanner input = new Scanner(fileName);

        //integer inputs might be long so use BigInteger as recommended
        BigInteger p = BigInteger.valueOf(input.nextLong());
        System.out.println(String.format("P : %d", p));
        BigInteger q = BigInteger.valueOf(input.nextLong());
        System.out.println(String.format("Q : %d", q));
        BigInteger x = BigInteger.valueOf(input.nextLong());
        System.out.println(String.format("X : %d", x));

        //plaintext bit string
        String bitStrings = input.next();
        System.out.println(String.format("Bit : %s", bitStrings));

        BigInteger mod = p.multiply(q);
        ArrayList<BigInteger> blumBlumList = new ArrayList<>(8);

        //set the first blum blum value
        blumBlumList.add((x.multiply(x)).mod(mod));

        //fill the rest of the arraylist
        for (int i = 1; i < 8; i++) {
            blumBlumList.add((blumBlumList.get(i-1).multiply(blumBlumList.get(i-1)).mod(mod)));
        }

        System.out.println("Blum Blum List: " + blumBlumList);
        ArrayList<String> leastSignificantBit = new ArrayList<>(8);

        for (int k = 0; k < 8; k++) {
            BigInteger check = (blumBlumList.get(k)).mod(BigInteger.valueOf(2));
            if (check.compareTo(BigInteger.valueOf(0)) != 0) {
                leastSignificantBit.add("1");
            } else {
                leastSignificantBit.add("0");
            }
        }

        String blumblumRand = leastSignificantBit.toString();
        System.out.println("Bit values from Blum Blum numbers are: " + blumblumRand);

        String eText = "";
        for (int k = 0; k < 8; k++) {
            if (bitStrings.charAt(k) == blumblumRand.charAt(k)) {
                eText += "0";
            } else {
                eText += "1";
            }
        }
        System.out.println("Encrypted string is: " + eText);
    }
}
