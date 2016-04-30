
package ejerciciopilaparentesis;
import javax.swing.*;
import java.awt.event.*;

public class EjercicioPilaParentesis extends JFrame implements ActionListener
{
    private JTextField tf1;
    private JButton boton1;
    
    public EjercicioPilaParentesis() 
    {
        setLayout(null);
        tf1=new JTextField("{2*(4-5)-{3*4}-[4-5]}");
        tf1.setBounds(10,10,230,30);
        add(tf1);
        boton1=new JButton("Verificar fórmula.");
        boton1.setBounds(10,70,180,30);
        add(boton1);
        boton1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
           if (balanceada()) {
               setTitle("Está correctamente balanceada.");
           } else {
               setTitle("No está correctamente balanceada.");
           }
        }
    }

    public boolean balanceada() {
        PilaParentesis pila1;  
    	pila1 = new PilaParentesis();    
    	String cadena=tf1.getText();
    	for (int f = 0 ; f < cadena.length() ; f++)
    	{
    	    if (cadena.charAt(f) == '(' || cadena.charAt(f) == '[' || cadena.charAt(f) == '{') {
    	    	pila1.insertar(cadena.charAt(f));
    	    } else {
    	    	if (cadena.charAt(f)==')') {
    	    	    if (pila1.extraer()!='(') {
    	    	        return false;
    	    	    }
    	     	} else {
    	    	    if (cadena.charAt(f)==']') {
    	    	        if (pila1.extraer()!='[') {
    	    	            return false;
    	    	        }
    	    	    } else {
    	    	        if (cadena.charAt(f)=='}') {
    	    	            if (pila1.extraer()!='{') {
    	    	                return false;
    	    	            }
    	    	        }
    	    	    }
    	        }
   	    }   
        }
    	if (pila1.vacia()) {
    	    return true;
    	} else {
   	    return false;
    	}
    }	
    
    
    public static void main(String[] ar) {
        EjercicioPilaParentesis formula1=new EjercicioPilaParentesis();
        formula1.setBounds(0,0,350,140);
        formula1.setVisible(true);
    }
}
