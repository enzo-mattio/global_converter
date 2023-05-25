package global_converter;

public class Hexadecimal {
    public static String convertToHex(String input) {
        StringBuilder sb = new StringBuilder();
        String[] values = input.split(" ");
        for (String value : values) {
            if (!value.isEmpty()) {
                int decimal = Integer.parseInt(value);
                String hex = convertToHexadecimal(decimal);
                sb.append(hex);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String convertFromHex(String input) {
        StringBuilder sb = new StringBuilder();
        String hex = input.replaceAll("\\s+", "");
        for (int i = 0; i < hex.length(); i += 2) {
            String hexPair = hex.substring(i, i + 2);
            int decimal = hexToDecimal(hexPair);
            sb.append(decimal);
            sb.append(" ");
        }
        return sb.toString();
    }

    private static String convertToHexadecimal(int decimal) {
        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 16;
            sb.insert(0, getHexChar(remainder));
            decimal /= 16;
        }
        return sb.toString();
    }

    private static char getHexChar(int remainder) {
        if (remainder >= 0 && remainder <= 9) {
            return (char) ('0' + remainder);
        } else {
            return (char) ('A' + remainder - 10);
        }
    }

    private static int hexToDecimal(String hex) {
        int decimal = 0;
        for (int i = 0; i < hex.length(); i++) {
            char digit = hex.charAt(i);
            int digitValue = getHexDigitValue(digit);
            decimal = decimal * 16 + digitValue;
        }
        return decimal;
    }

    private static int getHexDigitValue(char digit) {
        if (digit >= '0' && digit <= '9') {
            return digit - '0';
        } else if (digit >= 'A' && digit <= 'F') {
            return digit - 'A' + 10;
        } else if (digit >= 'a' && digit <= 'f') {
            return digit - 'a' + 10;
        }
        throw new IllegalArgumentException("Invalid hexadecimal digit: " + digit);
    }
}
