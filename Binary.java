package global_converter;

class Binary {
    public static String convertToBinary(String input) {
        StringBuilder sb = new StringBuilder();
        String[] nums = input.split(" ");
        int num;
        for (String c : nums) {
            num = Integer.parseInt(c);
            sb.append(padLeftWithZeros(decimalToBinary(num), 8));
            sb.append(" ");
        }
        return sb.toString();
    }
    public static String decimalToBinary(int decimal) {
        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            sb.insert(0, (char) ('0' + remainder));
            decimal /= 2;
        }
        return sb.toString();
    }
    public static String convertFromBinary(String input) {

            StringBuilder result = new StringBuilder();
            String[] binaryArray = input.split(" ");

            for (String binary : binaryArray) {
                if (isValidBinary(binary)) {
                    int decimal = convertToDecimal(binary);
                    result.append(decimal).append(" ");
                }
            }

            return result.toString().trim();
        }

        private static boolean isValidBinary(String binary) {
            return binary.matches("[01]+");
        }

        private static int convertToDecimal(String binary) {
            int decimal = 0;
            int power = 0;

            for (int i = binary.length() - 1; i >= 0; i--) {
                int digit = binary.charAt(i) - '0';
                decimal += digit * Math.pow(2, power);
                power++;
            }

            return decimal;
        }

    public static String padLeftWithZeros(String binary, int length) {
        if (binary.length() >= length) {
            return binary;
        } else {
            StringBuilder sb = new StringBuilder();
            int paddingSize = length - binary.length();
            sb.append("0".repeat(paddingSize));
            sb.append(binary);
            return sb.toString();
        }
    }
}
