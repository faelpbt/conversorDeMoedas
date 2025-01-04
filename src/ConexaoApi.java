import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoApi {

    public MoedaApi conecta(String base_code) {
        String chave = "3dc50a11d6e3f7c1d9f16302";

        // Opção de receber o resultado direto da API
//        URI link = URI.create("https://v6.exchangerate-api.com/v6/" + chave + "/pair/" + base_code + "/" + target_code + "/" + amount);

        URI link = URI.create("https://v6.exchangerate-api.com/v6/" + chave + "/latest/" + base_code);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(link)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MoedaApi.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Houve um erro!");
        }
    }
}