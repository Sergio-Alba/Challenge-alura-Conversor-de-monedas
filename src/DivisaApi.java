import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DivisaApi {
    public Divisa ConvertirDivisa(String divisa1, String divisa2, Double valor) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/dd465ce76c31973b3e6af5a3/pair/" + divisa1 + "/" + divisa2
                + "/" + valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No Se pudo realizar la converción");
        }


    }
}
