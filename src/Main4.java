import edu.princeton.cs.stdlib.StdDraw;

public class Main4 {
    public static void main(String[] args) {
        // Rango de dibujo
        double min = -1.0;
        double max = 1.0;

        // Definicion de la escala del lienzo de dibujo
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);

        // Evitar el parpadeo de la pantalla
        StdDraw.enableDoubleBuffering();

        // Posicion y velocidad inicial de la línea líder
        double x0 = min + (max - min) * Math.random();
        double y0 = min + (max - min) * Math.random();
        double vx0 = 0.001;
        double vy0 = 0.001;

        // Posicion y velocidad inicial de las líneas de la cola
        double[] x = new double[6];
        double[] y = new double[6];
        double[] vx = new double[6];
        double[] vy = new double[6];
        for (int i = 0; i < 6; i++) {
            x[i] = x0 + (i + 1) * 0.06;
            y[i] = y0 + (i + 1) * 0.12;
            vx[i] = 0.001;
            vy[i] = 0.001;
        }

        // Ciclo infinito
        while (true) {

            // Colisión de la línea líder
            if (Math.abs(x0 + vx0) > 1.0) {
                vx0 = -vx0;
            }
            if (Math.abs(y0 + vy0) > 1.0) {
                vy0 = -vy0;
            }

            // Actualización de posición de la línea líder
            x0 += vx0;
            y0 += vy0;

            // Actualización de posición de las líneas de la cola
            for (int i = 0; i < 6; i++) {
                // Colisión
                if (Math.abs(x[i] + vx[i]) > 1.0) {
                    vx[i] = -vx[i];
                }
                if (Math.abs(y[i] + vy[i]) > 1.0) {
                    vy[i] = -vy[i];
                }
                // Actualización de posición
                x[i] += vx[i];
                y[i] += vy[i];
            }

            // Limpieza de fondo
            StdDraw.clear();

            // Dibujar línea líder y líneas de la cola
            StdDraw.setPenColor(StdDraw.GREEN);
            StdDraw.line(x0, y0, x[0], y[0]);
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(x0, y0, x[1], y[1]);
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(x0, y0, x[2], y[2]);
            StdDraw.setPenColor(StdDraw.MAGENTA);
            StdDraw.line(x0, y0, x[3], y[3]);
            StdDraw.setPenColor(StdDraw.YELLOW);
            StdDraw.line(x0, y0, x[4], y[4]);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.line(x0, y0, x[5], y[5]);

            // Mostrar la pantalla y esperar
            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}
