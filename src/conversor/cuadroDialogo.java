package conversor;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class cuadroDialogo {
	
	temperatura temperatura = new temperatura();
    Menu menu2 = new Menu();
    entradaValor valor = new entradaValor();

	
    public void mostrarOpciones() throws IOException {
    	
    	UIManager.put("OptionPane.okButtonText", "Aceptar");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
    	
        String[] opciones = {"Convertir moneda", "Convertir temperatura"};
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Conversor", JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);
        
    	if (seleccion != null) {
    		
            if (seleccion.equals("Convertir moneda")) {
            	


				double numero = valor.obtenerNumeroValidado("Ingrese el valor a convertir:");
				menu2.mostrarSelectorDeConversion(numero);
            } else if (seleccion.equals("Convertir temperatura")) {
            	
            	
                
            	temperatura.mostrarSelectorDetemperatura();
            } else {
                JOptionPane.showMessageDialog(null, "Opción no válida");
            }
			
		} else {
			 System.exit(0);

		}
    	
    }

}
