import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebsiteContentReader {
    public String getFullSting(String websiteURL, String searchString)
    // Get the website URL from the user
    // String websiteURL = getUserInput("Enter a website URL: ");
    {
        String line="";
        try {
            // Create a URL object and open a connection to the website
            URL url = new URL(websiteURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method (GET) and timeout
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);

            // Check if the response code indicates success (HTTP 200 OK)
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read and print the contents of the website
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            //    String modifiedLine = line.replaceAll("\\b" + searchString + "\\b"), newString);
                while ((line = reader.readLine()) != null) {
                    if(line.contains(searchString) && ( line.contains("<p") || line.contains("<h1"))) {
                        line = line.replaceAll("\\<.*?\\>", "");
//                        line = line.replaceAll("\\b" + searchString + "\\b", searchString);
                        System.out.println("printing line "+line);
                        return line;
                    }
                }

                reader.close();

            } else {
                System.out.println("Failed to retrieve the website content. HTTP response code: " + responseCode);
            }

            // Disconnect the connection
            connection.disconnect();
        } catch (
                IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }


        // Helper method to get user input
  /*  private static String getUserInput(String prompt) {
        System.out.print(prompt);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading user input.");
        }
    }*/
    //    System.out.println("print line before return stmt :"+line);
        return line;
    }
}
