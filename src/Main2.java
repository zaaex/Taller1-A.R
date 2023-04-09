import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class Main2 {
    public static void main(String[] args) {
        // Rango de dibujo
        double min = -1.0;
        double max = 1.0;

        //Definicion de la escala del lienzo
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        // Evitar el parpadeo de la pantalla
        StdDraw.enableDoubleBuffering();

        Color[] colores = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN};

        // Dibujo de linea
        while (true) {
            //Generacion de par ordenado
            double x0 = min + (max - min) * Math.random();
            double y0 = min + (max - min) * Math.random();

            double x1 = min + (max - min) * Math.random();
            double y1 = min + (max - min) * Math.random();

            //Seleccion de color al azar
            StdDraw.setPenColor(colores[(int) (Math.random() * colores.length)]);

            StdDraw.line(x0, y0, x1, y1);
            StdDraw.show();

            //StdDraw.pause(t: 200);


        }
    }
}