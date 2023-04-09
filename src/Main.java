
import edu.princeton.cs.stdlib.StdDraw;

public class Main {
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
        double x = min + (max - min) * Math.random();
        double y = min + (max - min) * Math.random();

        // Velocidad inicial
        double vx = 0.001;
        double vy = 0.001;

        //Radio de pelota?
        double radio = 0.05;

        //Ciclo infinito
        while (true) {

            //Colision
            if (Math.abs(x +vx) > 1.0 - radio) {
                vx = -vx;
            }
            if (Math.abs(y +vy) > 1.0 - radio) {
                vy = -vy;
            }

            // Actualizacion de posciion
            x += vx;
            y += vy;

            //Limpieza de fondo
            StdDraw.clear();

            //Dibujar la pelotita?
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(x,y,radio);

            //Mostrar la pantalla y esperar
            StdDraw.show();
            //StdDraw.pause(10);

        }
    }
}