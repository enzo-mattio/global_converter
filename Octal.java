package global_converter;


class Octal {
    public static String convertToOctal(String input){
        String[] nums = input.split(" ");
        int num;
        for (int i = 0  ; i < nums.length ; i++){
            num = Integer.parseInt(nums[i]);
            nums[i] = NumToOctal(num);
        }
        return String.join(" ", nums);
    }

    private static String NumToOctal(int decimalNumber) {
        StringBuilder sb = new StringBuilder();
        if (decimalNumber == 0) {
            sb.append("0");
        } else {
            while (decimalNumber > 0) {
                int remainder = decimalNumber % 8;
                sb.insert(0, remainder);
                decimalNumber /= 8;
            }
        }
        return sb.toString();
    }



    public static String convertFromOctal(String input) {
        StringBuilder result = new StringBuilder();
        String[] octalArray = input.split(" ");
        for (String octal : octalArray) {
            if (octal.length() == 3) {
                int decimal = octalToDecimal(octal);
                result.append(decimal);
                result.append(" ");
            }
        }
        return result.toString();
    }
    private static int octalToDecimal(String octal) {
        int decimal = 0;
        int power = 0;
        for (int i = octal.length() - 1; i >= 0; i--) {
            int digit = octal.charAt(i) - '0';
            decimal += digit * Math.pow(8, power);
            power++;
        }
        return decimal;
    }


}
