package com.company;

public class Main {

    public static Slika slika = null;
    public static int ponavljanje = 40000;
    public static volatile double odnos = 0.0;

    public static void main(String[] args) throws InterruptedException {

        String imeSlike = "Krivulja2.png";
        slika = new Slika(imeSlike);

        System.out.println("Poziv Monte Carlo Simulacije nad " + imeSlike);
        PlatnoZaCrtanje pl = new PlatnoZaCrtanje(slika.pravaSlika.getWidth(),
                                                 slika.pravaSlika.getHeight());

        System.out.println("Simuliram sa " + ponavljanje + " ponavljanja");
        long t1, t2;
        t1 = System.nanoTime();

        // Cekanje na izvrsavnje racunanja odnosa
        while(odnos == 0.0){
            Thread.sleep(1);
        }

        System.out.println("Odnos unutarnjih naspram svih je: " + odnos);

        ispisPovrsina(imeSlike);

        t2 = System.nanoTime();

        System.out.println("Vrijeme izvodjenja sekvencijalno: " + ((t2-t1)/1000000000.0) + " s");

    }

    public static void ispisPovrsina(String ime){
        System.out.println("Velicina platna je: " + slika.pravaSlika.getWidth() + "x" +
                slika.pravaSlika.getHeight());
        if(ime == "Kvadrat.png"){

            System.out.println("Prava povrsina kvadrata je: " + (300*300));
            System.out.println("Pretpostavljenja povrsina kvadrata je: " + ((500*500)*odnos));

        }else if(ime == "Krug.png"){

            System.out.println("Prava povrsina kruga je: " + (250*250*Math.PI));
            System.out.println("Pretpostavljenja povrsina kvadrata je: " + ((500*500)*odnos));

        }else{
            System.out.println("Pretpostavljenja povrsina krivulje je: " + ((500*500)*odnos));
        }
    }

}
