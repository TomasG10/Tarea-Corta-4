import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana implements ActionListener {

    JFrame window;

    int suma;
    int contador = 0;

    int[] arreglo = new int[2];

    int[] secuencia = new int[]{0,0,0};

    int[] verificador = new int[]{1,2,3};

    boolean check = false;

    JButton boton1;
    JButton boton2;
    JButton boton3;

    JPanel panelBotones;

    public Ventana(){

        window = new JFrame("PRESIONE LOS BOTONES DE MANERA ASCENDENTE!!!");

        window.setPreferredSize(new Dimension(500,300));

        window.setResizable(true);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        agregarComponentes();
        window.pack();
        window.setVisible(true);


    }

    private void agregarComponentes(){

        boton1 = new JButton("1");
        boton1.addActionListener(this);
        boton2 = new JButton("2");
        boton2.addActionListener(this);
        boton3 = new JButton("3");
        boton3.addActionListener(this);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(10,10));

        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);

        window.add(panelBotones, BorderLayout.CENTER);


    }

    public void compararArrays(){
        if(secuencia[0] == verificador[0] & secuencia[1] == verificador[1] & secuencia[2] == verificador[2]){
            check = false;
        }
        else{
            check = true;
        }
    }

    public void verificarSuma(){
        compararArrays();
        
        if (contador == 3 & check == true){
            try{
                arreglo[2] = 1;
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(window, "No se presionaron los botones de forma correcta");
                secuencia = new int[]{0,0,0};
                contador = 0;
            }
        }
        else if(contador == 3){
            contador = 0;
        }
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(boton1)){
            secuencia[contador] = 1;
            contador += 1;
            verificarSuma();
        }

        if (e.getSource().equals(boton2)){
            secuencia[contador] = 2;
            contador += 1;
            verificarSuma();
        }
        
        if (e.getSource().equals(boton3)){
            secuencia[contador] = 3;
            contador += 1;
            verificarSuma();
        }
    }
    
}
