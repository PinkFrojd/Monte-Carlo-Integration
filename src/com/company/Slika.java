package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Slika {

    BufferedImage pravaSlika = null;
    int[][] matrica = null;

    public Slika(String imeSlike) {

        File f = new File("./resursi/" + imeSlike);
        try {
            pravaSlika = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        matrica = new int[pravaSlika.getWidth()][pravaSlika.getHeight()];
        for (int x = 0; x < pravaSlika.getWidth(); x++) {
            for (int y = 0; y < pravaSlika.getHeight(); y++) {
                int boja = new Color(pravaSlika.getRGB(x,y)).getBlue();
                if(boja == 255){
                    matrica[x][y] = 1;
                }else{
                    matrica[x][y] = 0;
                }
            }
        }
    }
}
