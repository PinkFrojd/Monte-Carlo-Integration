package com.company;

import java.awt.*;
import java.util.Random;

public class Platno extends Canvas {


    @Override
    public void paint(Graphics g) {
        this.setBackground(Color.green); // Uklonit zelenu, samo radi testiranja ovdje
        g.drawImage(Main.slika.pravaSlika, 0,0, null);

        Main.odnos = simuliraj(g, Main.ponavljanje);

    }

    private double simuliraj(Graphics g, int ponavljanje) {
        g.setColor(Color.red);
        double unutarnji = 0.0;

        for (int i = 0; i < ponavljanje; i++) {
            Random rand = new Random();
            int x = rand.nextInt(500);
            int y = rand.nextInt(500);
            g.fillRect(x, y, 1, 1); // Kvadrat velicine pixela
            if(Main.slika.matrica[x][y] == 0){
                unutarnji += 1;
            }
        }

        double odnos = unutarnji / ponavljanje;

        return odnos;

    }
}
