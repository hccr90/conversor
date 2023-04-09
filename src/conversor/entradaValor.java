package conversor;
import javax.swing.JOptionPane;



public class entradaValor {
	
	

	
	
	public double obtenerNumeroValidado(String mensaje) {
        double numero = 0;
        boolean numeroValido = false;
        while (!numeroValido) {
            String entrada = JOptionPane.showInputDialog(null, mensaje);
            try {
                numero = Double.parseDouble(entrada);
                numeroValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
            }
        }
        
                return numero;
    }
	
	
	



	

}
