package conversor;

import java.io.IOException;

import javax.swing.JOptionPane;

public class temperatura {
	entradaValor valor = new entradaValor();
	
	
	   double fahrenheitToCelsius(double fahrenheit) {
	    double celsius = (fahrenheit - 32) * 5 / 9;
	    return celsius;
	}
	
	  double celsiusToFahrenheit(double celsius) {
	    double fahrenheit = celsius * 9 / 5 + 32;
	    return fahrenheit;
	}
	

	
	  
	
	
	
	public  void mostrarSelectorDetemperatura() throws IOException {
        String[] options = {"De celcius a farenheit", "De farenheit a celcius"};
        String selectedOption = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión:", "Conversor de temperatura", JOptionPane.DEFAULT_OPTION, null, options, options[0]);

        if (selectedOption != null) {
            switch(selectedOption) {
                case "De celcius a farenheit":
                	double numero1 = valor.obtenerNumeroValidado("Ingrese el valor a convertir:");
                	double farenheit = celsiusToFahrenheit(numero1);
                    JOptionPane.showMessageDialog(null, "El valor convertido es: " + farenheit + " grados Centigrados");
                    break;

                case "De farenheit a celcius":
                	double numero2 = valor.obtenerNumeroValidado("Ingrese el valor a convertir:");
                	double celsius = fahrenheitToCelsius(numero2);
                    JOptionPane.showMessageDialog(null, "El valor convertido es: " + celsius + " grados Celsius");
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
