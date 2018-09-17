package com.company;

import java.awt.*;
import java.util.Random;

public class SimulacijaParalelno implements Runnable {
    public Thread t = null;;
    public static double unutarnji = 0.0;
    public Graphics gr;
    public int pocetak;

    public SimulacijaParalelno(Graphics g, int p) {
        gr = g;
        pocetak = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < (MainParalelno.ponavljanje/2); i++) {
            Random rand = new Random();
            int x;
            if(pocetak == 0){
                gr.setColor(Color.red);
                x = rand.nextInt(250);
            }else{
                gr.setColor(Color.yellow);
                x = rand.nextInt(250) + 250;
            }

            int y = rand.nextInt(500);
            gr.fillRect(x, y, 1, 1); // Kvadrat velicine pixela
            if(MainParalelno.slika.matrica[x][y] == 0){
                if(x < 250){
                    MainParalelno.unutarnji1 += 1;
                }else{
                    MainParalelno.unutarnji2 += 1;
                }
            }
        }
    }

    public void start(){
        if(t == null){
            t = new Thread(this);
            t.start();
        }
    }
}
