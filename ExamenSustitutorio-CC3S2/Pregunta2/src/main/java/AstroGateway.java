import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AstroGateway implements Gateway<AstroResponse> {
    @Override
    public AstroResponse getResponse() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://api.open-notify.org/astros.json"))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());

            // En caso de éxito
            if (response.statusCode() == 200) {
                String responseJson = response.body();
                // Convertimos la respuesta JSON en un Java POJO (AstroResponse)
                Gson gson = new Gson();
                return gson.fromJson(responseJson, AstroResponse.class);
            } else {  // En caso de error
                System.out.println("Error. Código de estado: "
                        + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}