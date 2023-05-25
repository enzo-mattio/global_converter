package global_converter;

public class Text {
    public static String convertToText(String input) {
        StringBuilder sb = new StringBuilder();
        String[] asciiArray = input.split(" ");
        // If space
        for (String asciiValue : asciiArray) {
            switch (asciiValue) {
                case "32", "20", "040":
                    sb.append(" ");
                    break;
                default:
                    if (!asciiValue.isEmpty()) {
                        int decimal = Integer.parseInt(asciiValue);
                        char character = (char) decimal;
                        sb.append(character);
                    }
                    break;
            }
        }
        return sb.toString();
    }

}
