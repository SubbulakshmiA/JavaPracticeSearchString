// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

        public static void main(String[] args) {
            String equation = "25+7*9";

            // Use regular expressions to split the equation into components
            String[] components = equation.split("((?<=\\+)|(?=\\+)|(?<=-)|(?=-)|(?<=\\*)|(?=\\*)|(?<=/)|(?=/))");

            // Create a String array to store the components
            String[] equationArray = new String[components.length];

            // Copy components into the equationArray
            for (int i = 0; i < components.length; i++) {
                equationArray[i] = components[i];
            }

            // Display the components
            for (String component : equationArray) {
                System.out.println(component);
            }
        }
    }

