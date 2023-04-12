package conversor;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Menu {
	
	
	
	public void convertirMoneda(String from,String to,double amountD ) throws IOException {
        // Obtener los valores deseados de "to", "from" y "amount" del usuario utilizando JOptionPane
		String amount = String.valueOf(amountD);


        // Crea una instancia del cliente OkHttpClient para hacer solicitudes HTTP
      //  OkHttpClient client = new OkHttpClient().newBuilder().build();
        
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
                .readTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
                .build();
        
        

        // Crea un objeto de tipo Request que especifica la URL, el método y la cabecera
        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + amount) // URL de la API
                .addHeader("apikey", "mJARFVGs9K7C51AA3hTXVr1Dmplwb2t7") // Clave de API para autenticarse en la API
                .method("GET", null) // Método HTTP (GET) y cuerpo vacío (null)
                .build();

        // Ejecuta la solicitud HTTP utilizando el cliente OkHttpClient y el objeto Request previamente creado
        Response response = client.newCall(request).execute();

        // Almacena el cuerpo de la respuesta en una variable
        String responseBody = response.body().string();
        
     // Cerrar la respuesta para liberar los recursos
        response.close();


        // Imprime el cuerpo de la respuesta HTTP
        System.out.println(responseBody);

        // Construye un objeto JSON a partir del cuerpo de la respuesta
        JSONObject responseJson = new JSONObject(responseBody);

        // Obtiene el valor de la clave "result" del objeto JSON y lo muestra en un cuadro de diálogo
        double result = responseJson.getDouble("result");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String formattedResult = decimalFormat.format(result);
        JOptionPane.showMessageDialog(null, "El valor convertido es: " + formattedResult);
    }
		 
	
	
	public  void mostrarSelectorDeConversion(double valor) throws IOException{
        String[] options = {"De peso a dolar", "De dolar a peso", "De peso a euro", "De euro a peso"};
        String selectedOption = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión:", "Conversor de moneda", JOptionPane.DEFAULT_OPTION, null, options, options[0]);

        if (selectedOption != null) {
            switch(selectedOption) {
                case "De peso a dolar":
                	Menu menu = new Menu();
                    menu.convertirMoneda("COP","USD",valor);
                    break;
                case "De dolar a peso":
                	Menu menu2 = new Menu();
                    menu2.convertirMoneda("USD","COP",valor);
                    break;
                case "De peso a euro":
                	Menu menu3 = new Menu();
                	menu3.convertirMoneda("COP","EUR",valor);
                    // Código para la conversión de peso a euro
                    break;
                case "De euro a peso":
                	Menu menu4 = new Menu();
                	menu4.convertirMoneda("EUR","COP",valor);
                    // Código para la conversión de euro a peso
                    break;
            }
            
            int option = JOptionPane.showConfirmDialog(null, "¿Desea continuar usando el programa?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (option == JOptionPane.YES_OPTION) {
            	cuadroDialogo miCuadro = new cuadroDialogo();
            	miCuadro.mostrarOpciones();
                
            } else {
                JOptionPane.showMessageDialog(null, "Programa finalizado");
            }
        }
    }
	
	

}