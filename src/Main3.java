import edu.princeton.cs.stdlib.StdDraw;

import javax.xml.stream.util.StreamReaderDelegate;

public class Main3 {
    public static void main(String[] args) {
        //Rango de dibujo
        double min = -1.0;
        double max = 1.0;

        // Definicion de la escala del lienzo de dibujo
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        // Evitar el parpaedeo de la pantalla
        StdDraw.enableDoubleBuffering();

        // Poscion inicial

        // Linea 1
        double x0 = min + (max - min) * Math.random();
        double y0 = min + (max - min) * Math.random();

        double x1 = min + (max - min) * Math.random();
        double y1 = min + (max - min) * Math.random();

        //Linea 2

        double x2 = x0 + 0.06;
        double y2 = y0 + 0.12;

        double x3 = x2 + 0.12;
        double y3 = y2 + 0.06;


        //Velocidad inicial
        double vx = 0.001;
        double vy = 0.001;

        double vx1 = 0.001;
        double vy1 = 0.001;

        //CIclo infinito
        while (true) {

            //Colision

            //Linea 1
            if (Math.abs(x0 + vx) > 1.0) {
                vx = -vx;
            }
            if (Math.abs(y0 + vy) > 1.0) {
                vy = -vy;
            }
            if (Math.abs(x1 + vx) > 1.0) {
                vx = -vx;
            }
            if (Math.abs(y1 + vy) > 1.0) {
                vy = -vy;
            }

            //Linea 2
            if (Math.abs(x2 + vx1) > 1.0) {
                vx1 = -vx1;
            }
            if (Math.abs(y2 + vy1) > 1.0) {
                vy1 = -vy1;
            }
            if (Math.abs(x3 + vx1) > 1.0) {
                vx1 = -vx1;
            }
            if (Math.abs(y3 + vy1) > 1.0) {
                vy1 = -vy1;
            }

            //Actualizacion de posicion

            //Linea 1
            x0 += vx;
            y0 += vy;

            x1 += vx;
            y1 += vy;

            //Linea 2
            x2 += vx1;
            y2 += vy1;

            x3 += vy1;
            y3 += vy1;

            //Limpieza de fondo
            StdDraw.clear();

            //Dibujar linea
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.line(x0, y0, x1, y1);
            StdDraw.line(x2, y2, x3, y3);

            //Mostrar la pantalla y esperar
            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}