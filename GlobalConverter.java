package global_converter;

public class GlobalConverter {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Erreur : Veuillez fournir une chaîne de caractères et une base de traduction.");
            return;
        }

        String input = args[0];
        String base = args[1];
        String outputBase = args[2];

        // Vérification de la validité de la chaîne de caractères
        if (!isValidString(input)) {
            System.out.println("Erreur : La chaîne de caractères contient des caractères invalides.");
            return;
        }

        // Vérification de la validité de la base de traduction
        if (!isValidBase(base) && !isValidBase(outputBase)) {
            System.out.println("Erreur : Base de traduction invalide.");
            return;
        }


        String output;

        switch (base){
            case "hexadecimal", "-h" -> {
                if (!isValidHex(input)) {
                    System.out.println("Erreur : La chaîne de caractères contient des caractères invalides.");
                    return;
                }
                input = Hexadecimal.convertFromHex(input);
            }
            case "octal", "-o" -> {
                if (!isValidOctal(input)) {
                    System.out.println("Erreur : La chaîne de caractères contient des caractères invalides.");
                    return;
                }
                input = Octal.convertFromOctal(input);
            }
            case "binary", "-b" -> {
                if (!isValidBinary(input)) {
                    System.out.println("Erreur : La chaîne de caractères contient des caractères invalides.");
                    return;
                }
                input = Binary.convertFromBinary(input);
            }
            case "text", "-t" -> input = convertToAscii(input);

        }

        switch (outputBase) {
            case "hexadecimal", "-h" -> {
                output = Hexadecimal.convertToHex(input);

                System.out.println("Chaîne de caractères traduite en base hexadécimale : " + output);
            }
            case "octal", "-o" -> {
                output = Octal.convertToOctal(input);

                System.out.println("Chaîne de caractères traduite en base octale : " + output);
            }
            case "binary", "-b" -> {
                output = Binary.convertToBinary(input);
                System.out.println("Chaîne de caractères traduite en base binaire : " + output);
            }
            case "text", "-t" -> {
                output = Text.convertToText(input);

                System.out.println("Chaîne de caractères traduite en base texte : " + output);
            }
            case "decimal", "-d" -> {

                System.out.println("Chaîne de caractères traduite en base décimale : " + input);
            }


        }
    }
    // Ajout de la possibilité d'avoir des espaces dans la chaîne de caractères
    private static boolean isValidHex(String input) {
        return input.matches("[0-9a-fA-F ]+");
    }
    private static boolean isValidOctal(String input) {
        return input.matches("[0-7 ]+");

    }
    private static boolean isValidBinary(String input) {
        return input.matches("[0-1 ]+");
    }
    private static boolean isValidString(String input) {
        return input.matches("[a-zA-Z0-9 ]+");
    }

    private static String convertToAscii(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append((int) c);
            sb.append(" ");
        }
        return sb.toString();
    }
    private static boolean isValidBase(String base) {
        return base.equals("hexadecimal") || base.equals("-h")
                || base.equals("octal") || base.equals("-o")
                || base.equals("decimal") || base.equals("-d")
                || base.equals("binary") || base.equals("-b")
                || base.equals("text") || base.equals("-t");
    }
}
