package conversor;
import javax.swing.JOptionPane;

public class Menu {
	
	
	public  void mostrarSelectorDeConversion(double valor) {
        String[] options = {"De peso a dolar", "De dolar a peso", "De peso a euro", "De euro a peso"};
        String selectedOption = (String) JOptionPane.showInputDialog(null, "Seleccione una opción de conversión:", "Conversor de moneda", JOptionPane.DEFAULT_OPTION, null, options, options[0]);

        if (selectedOption != null) {
            switch(selectedOption) {
                case "De peso a dolar":
                    valor= valor * 4;
                    JOptionPane.showMessageDialog(null, "El valor convertido es: " + valor + " USD");
                    break;
                case "De dolar a peso":
                	valor = valor / 4;
                	JOptionPane.showMessageDialog(null, "El valor convertido es: " + valor + " pesos");
                    // Código para la conversión de dólar a dólar
                    break;
                case "De peso a euro":
                	valor= valor * 5;
                	JOptionPane.showMessageDialog(null, "El valor convertido es: " + valor + " euros");
                    // Código para la conversión de peso a euro
                    break;
                case "De euro a peso":
                	valor = valor / 5;
                	JOptionPane.showMessageDialog(null, "El valor convertido es: " + valor + " pesos");
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