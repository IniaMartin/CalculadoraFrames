

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculadora extends JFrame{

	//crear elementos
	JTextField campo1, campo2, resultado;
	JLabel nombrecampo1, nombrecampo2, camporesul;
	JButton suma, resta, multi, div, borrar;
	JButton uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero;
	JFrame ventana;
	double valor=0;
	
	//clase principal (podría estar en otro archivo si fuera más largo
	public static void main(String[] args) {
		Calculadora c = new Calculadora();
		c.pack();
		c.setVisible(true);
		
	}

	//constructor
	public Calculadora() {
		//inicializar elemetos
		nombrecampo1 = new JLabel("Numero 1:");
		nombrecampo2 = new JLabel("Numero 2:");
		camporesul = new JLabel("Resultado:");
		campo1 = new JTextField(4);
		campo2 = new JTextField(4);
		resultado = new JTextField(15);
		resultado.setEditable(false);
		suma = new JButton("+");
		resta = new JButton("-");
		multi = new JButton("x");
		div = new JButton("/");
		//botones de los numeros
		uno = new JButton("1");
		dos = new JButton("2");
		tres = new JButton("3");
		cuatro = new JButton("4");
		cinco = new JButton("5");
		seis = new JButton("6");
		siete = new JButton("7");
		ocho = new JButton("8");
		nueve = new JButton("9");
		cero = new JButton("0");
		//boton borrar numeros
		borrar = new JButton("Borrar");
		
		//crear y configurar ventana
		Container ventana = getContentPane();
		ventana.setBackground(Color.decode("#FEFFBA"));
		ventana.setPreferredSize(new Dimension(240,200));
		ventana.setLayout(new FlowLayout());
		
		//añadir elementos a la ventana
		ventana.add(nombrecampo1);
		ventana.add(campo1);
		campo1.setEditable(false);
		ventana.add(nombrecampo2);
		ventana.add(campo2);
		campo2.setEditable(false);
		ventana.add(uno);
		ventana.add(dos);
		ventana.add(tres);
		ventana.add(cuatro);
		ventana.add(cinco);
		ventana.add(seis);
		ventana.add(siete);
		ventana.add(ocho);
		ventana.add(nueve);
		ventana.add(cero);
		ventana.add(suma);
		suma.setEnabled(false);
		ventana.add(resta);
		resta.setEnabled(false);
		ventana.add(multi);
		multi.setEnabled(false);
		ventana.add(div);
		div.setEnabled(false);
		ventana.add(camporesul);
		ventana.add(resultado);
		ventana.add(borrar);
		borrar.setEnabled(false);
		
		//llamar método a cada boton
		suma.addActionListener(new eventoBotones());
		resta.addActionListener(new eventoBotones());
		multi.addActionListener(new eventoBotones());
		div.addActionListener(new eventoBotones());
		borrar.addActionListener(new eventoBotones());

		uno.addActionListener(new eventoNumeros());
		dos.addActionListener(new eventoNumeros());
		tres.addActionListener(new eventoNumeros());
		cuatro.addActionListener(new eventoNumeros());
		cinco.addActionListener(new eventoNumeros());
		seis.addActionListener(new eventoNumeros());
		siete.addActionListener(new eventoNumeros());
		ocho.addActionListener(new eventoNumeros());
		nueve.addActionListener(new eventoNumeros());
		cero.addActionListener(new eventoNumeros());
		
		//cambiar color de los botones si estan deshabilitados
	}
	//clase evento numeros
	private class eventoNumeros implements ActionListener{
		//metodo de los numeros
				public void actionPerformed(ActionEvent numeros) {
					switch(numeros.getActionCommand()) {
					case "1":
						valor=1;
						break;
					case "2":
						valor=2;
						break;
					case "3":
						valor=3;
						break;
					case "4":
						valor=4;
						break;
					case "5":
						valor=5;
						break;
					case "6":
						valor=6;
						break;
					case "7":
						valor=7;
						break;
					case "8":
						valor=8;
						break;
					case "9":
						valor=9;
						break;
					case "0":
						valor=0;
						break;
					}
					if(campo1.getText().equals("")) {
						campo1.setText(Double.toString(valor));
					} else
					if(!campo1.getText().equals("") && campo2.getText().equals("")) {
						campo2.setText(Double.toString(valor));
					}
				
					//si ambos campos ya tienen numeros, se habilitan los botones de operacion
					if(!campo1.getText().equals("") && !campo2.getText().equals("")) {
						suma.setEnabled(true);
						resta.setEnabled(true);
						multi.setEnabled(true);
						div.setEnabled(true);
						borrar.setEnabled(true);
						//deshabilitamos botones de numeros
						uno.setEnabled(false);
						dos.setEnabled(false);
						tres.setEnabled(false);
						cuatro.setEnabled(false);
						cinco.setEnabled(false);
						seis.setEnabled(false);
						siete.setEnabled(false);
						ocho.setEnabled(false);
						nueve.setEnabled(false);
						cero.setEnabled(false);
					}
				}
	}
	
	
	//clase evento
	private class eventoBotones implements ActionListener{
		
		//metodo de qué hace cada botón
		public void actionPerformed(ActionEvent operacion) {
			double num1=Double.parseDouble(campo1.getText());
			double num2=Double.parseDouble(campo2.getText());
			double result=0;
			
			switch(operacion.getActionCommand()) {
			case "+":
				result = num1+num2;
				resultado.setText(Double.toString(result));
				break;
			case "-":
				result = num1-num2;
				resultado.setText(Double.toString(result));
				break;
			case "x":
				result = num1*num2;
				resultado.setText(Double.toString(result));
				break;
			case "/":
				if(num2==0) {
					resultado.setText("No se puede dividir entre 0");
				}else {
					result = num1/num2;
					resultado.setText(Double.toString(result));
				}
				break;
			case "Borrar":
				//poner todos los valores vacios o 0
				valor=0;
				campo1.setText("");
				campo2.setText("");
				//deshabilitar botones de operacion
				suma.setEnabled(false);
				resta.setEnabled(false);
				multi.setEnabled(false);
				div.setEnabled(false);
				borrar.setEnabled(false);
				//habilitar botones de numeros
				uno.setEnabled(true);
				dos.setEnabled(true);
				tres.setEnabled(true);
				cuatro.setEnabled(true);
				cinco.setEnabled(true);
				seis.setEnabled(true);
				siete.setEnabled(true);
				ocho.setEnabled(true);
				nueve.setEnabled(true);
				cero.setEnabled(true);
				break;
			}
			
		}
		
		
		
	}
}
