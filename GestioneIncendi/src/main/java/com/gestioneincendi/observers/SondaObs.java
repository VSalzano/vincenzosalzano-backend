package com.gestioneincendi.observers;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Observable;
import java.util.Observer;

import com.gestioneincendi.models.Sonda;

@SuppressWarnings("deprecation")
public class SondaObs implements Observer {

    @Override
    public void update(Observable o, Object sonda) {
        Sonda rilevamento = (Sonda) sonda;
        this.allarme(rilevamento);
    }

    public String allarme(Sonda rilevamento) {
        String message = "";

        if (rilevamento.getIntFumo() >= 5) {
            message = "Allarme Incendio!";
            inviaRichiestaHTTP(message);
        } else if (rilevamento.getIntFumo() < 5 && rilevamento.getIntFumo() > 0) {
            message = "Warning: piccola quantità di fumo rilevata";
            inviaRichiestaHTTP(message);
        } else {
            message = "Ormai siamo andati a fuoco, non c'è più niente da fare";
            inviaRichiestaHTTP(message);
        }

        return message;
    }

    private void inviaRichiestaHTTP(String message) {
        try {
            URL url = new URL("http://localhost:8080/allarmeincendio");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String requestBody = "{\"message\": \"" + message + "\"}";
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();


            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}