package com.company;

import java.awt.*;

public class PlatnoParalelno extends Canvas{

    public boolean uvjet = true;

    public PlatnoParalelno() {

    }

    @Override
    public void paint(Graphics g) {
        this.setBackground(Color.green); // Uklonit zelenu, samo radi testiranja ovdje
        g.drawImage(MainParalelno.slika.pravaSlika, 0,0, null);

        if(uvjet){
            uvjet = false;

            SimulacijaParalelno t1 = new SimulacijaParalelno(g, 0);
            SimulacijaParalelno t2 = new SimulacijaParalelno(g, 250);

            t1.start();
            t2.start();

            try {
                t1.t.join();
                t2.t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MainParalelno.odnos = ((MainParalelno.unutarnji1 + MainParalelno.unutarnji2) / (MainParalelno.ponavljanje));
        }



    }

}
