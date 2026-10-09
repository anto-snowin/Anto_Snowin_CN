import java.util.*;

public class CRC {

    // Binary (modulo-2) division
    static String xorDivide(String dividend, String divisor) {
        int len = divisor.length();
        char[] bits = dividend.toCharArray();

        for (int i = 0; i <= bits.length - len; i++) {
            if (bits[i] == '1') {
                for (int j = 0; j < len; j++) {
                    bits[i + j] = (bits[i + j] == divisor.charAt(j)) ? '0' : '1';
                }
            }
        }
        return new String(bits, bits.length - len + 1, len - 1);
    }

    // Sender: append CRC bits to the message
    static String encode(String message, String poly) {
        String padded = message + "0".repeat(poly.length() - 1);
        String remainder = xorDivide(padded, poly);
        String frame = message + remainder;

        System.out.println("\n===== SENDER =====");
        System.out.println("Padded data   : " + padded);
        System.out.println("CRC remainder : " + remainder);
        System.out.println("Code word     : " + frame);
        return frame;
    }

    // Receiver: verify the incoming code word
    static void verify(String frame, String poly) {
        String remainder = xorDivide(frame, poly);
        boolean clean = remainder.chars().allMatch(c -> c == '0');

        System.out.println("\n===== RECEIVER =====");
        System.out.println("Remainder     : " + remainder);
        System.out.println(clean ? "Result        : No Error" : "Result        : Error Detected");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter data bits: ");
        String message = in.next();
        System.out.print("Enter generator polynomial bits: ");
        String poly = in.next();

        encode(message, poly);

        System.out.print("\nEnter received code word: ");
        String received = in.next();
        verify(received, poly);

        in.close();
    }
}
