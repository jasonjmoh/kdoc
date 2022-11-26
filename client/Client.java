import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {

    private static final int DEFAULT_NUMBER_REQUEST = 10000;
    private static final String API_BASE_URL = "http://10.0.0.132:3000/check_in";

    public double makeRequest() {
        try {
            // Create a neat value object to hold the URL
            URL url = new URL(API_BASE_URL);

            // Open a connection(?) on the URL(??) and cast the response(???)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Now it's "open", we can set the request method, headers etc.
            connection.setRequestProperty("accept", "application/json");

            long start_time = System.nanoTime();
            // This line makes the request
            connection.getInputStream();

            long end_time = System.nanoTime();
            return (end_time - start_time) / 1e6;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public double run() {
        float sum = 0.00f;
        for (int i = 0; i < DEFAULT_NUMBER_REQUEST; i++) {
            sum += makeRequest();

            if (i != 0 && i % 5 == 0) {
                System.out.println(i);
                continue;
            }
            System.out.print(i + " ");
        }
        return sum / DEFAULT_NUMBER_REQUEST;
    };

    public double run(int numRequest) {
        float sum = 0.00f;
        for (int i = 0; i < numRequest; i++) {

            sum += makeRequest();
            if (i % 5 == 0) {
                System.out.println(i);
                continue;
            }
            System.out.print(i + " ");
        }
        return sum / numRequest;
    }

    public static void main(String[] args) {

        Client c = new Client();
        double result = c.run();
        System.out.println("\nMean time from request to response: " + result + " ms");
    }

}
