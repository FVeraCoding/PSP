package Tema4.ActividadesPropuestas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ActividadPropuesta4_1 {
    public static void main(String[] args) {

        String apiUrl = "https://opendata.aemet.es/centrodedescargas/inicio";
        
        try {
            
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            int codigoRespuesta = connection.getResponseCode();
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder respuesta = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    respuesta.append(inputLine);
                    respuesta.append("\n");
                }
                in.close();
                
                System.out.println("Respuesta JSON del servicio web:");
                System.out.println(respuesta.toString());
            } else {
                System.out.println("Error en la conexión. Código de respuesta: " + codigoRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
