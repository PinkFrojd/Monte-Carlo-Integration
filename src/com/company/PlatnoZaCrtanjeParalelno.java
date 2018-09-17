package com.company;

import javax.swing.*;
import java.awt.*;

public class PlatnoZaCrtanjeParalelno extends JFrame{

    public PlatnoParalelno platno = new PlatnoParalelno();

    public PlatnoZaCrtanjeParalelno(int sirina, int visina){

        setLayout(new BorderLayout(0,0));
        setSize(sirina + 16, visina + 39); // Rucno doradjena sirina i visina radi bordera
        setTitle("Monte Carlo Simulacija");
        add("Center", platno);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
