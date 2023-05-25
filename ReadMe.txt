Global Converter
The Global Converter is a command-line application that allows you to convert strings between different number bases. It supports conversions to and from the following bases: hexadecimal, octal, binary, and text. Additionally, it provides a decimal representation of the input string.

Usage
To run the Global Converter, execute the GlobalConverter class with the appropriate command-line arguments. The required arguments are as follows:

php
Copy code
java GlobalConverter <input> <base> <outputBase>
<input>: The string to be converted.
<base>: The base of the input string. Valid options are:
hexadecimal or -h for hexadecimal.
octal or -o for octal.
binary or -b for binary.
text or -t for text.
<outputBase>: The desired base for the converted string. Valid options are the same as the <base> argument.
Note: Ensure that you have Java installed and properly configured on your system before running the Global Converter.

Classes
The Global Converter application consists of the following classes, each stored in a separate file:

GlobalConverter.java
This class contains the main entry point for the application. It validates the input arguments, performs the necessary conversions, and prints the converted output to the console.

Text.java
The Text class provides methods for converting strings to and from text representation. It converts individual ASCII values to characters and handles spaces.

Hexadecimal.java
The Hexadecimal class provides methods for converting strings to and from hexadecimal representation. It handles splitting the input string into hexadecimal pairs and performing the conversion.

Binary.java
The Binary class provides methods for converting strings to and from binary representation. It handles splitting the input string into binary numbers and performs the conversion.

Octal.java
The Octal class provides methods for converting strings to and from octal representation. It handles splitting the input string into octal numbers and performs the conversion.

Helper Methods
The GlobalConverter class also includes several helper methods used for input validation:

isValidString(String input): Checks if the input string contains valid characters.
isValidBase(String base): Checks if the provided base is valid.
isValidHex(String input): Checks if the input string contains valid hexadecimal characters.
isValidOctal(String input): Checks if the input string contains valid octal characters.
isValidBinary(String input): Checks if the input string contains valid binary characters.
Examples
Here are some example commands to run the Global Converter:

arduino
Copy code
java GlobalConverter "Hello" text -h
This converts the string "Hello" to its hexadecimal representation.

php
Copy code
java GlobalConverter "101010" binary -t
This converts the binary string "101010" to its corresponding ASCII text.

csharp
Copy code
java GlobalConverter "123" decimal -b
This converts the decimal number 123 to its binary representation.