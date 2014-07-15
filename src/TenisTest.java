public class TenisTest {
    public static void main(String[] args) {
        String jugador1 = "Juan";
        String jugador2 = "Pedro";
        int marcador_jugador1 = 4;
        int marcador_jugador2 = 0;
        int maxima_puntuacion;
        Tenis t = new Tenis(jugador1,jugador2);

        maxima_puntuacion = Math.max(marcador_jugador1, marcador_jugador2);

        for (int i = 0; i < maxima_puntuacion; i++) {
            if (i < marcador_jugador1) {
                t.punto_ganado(jugador1);
            }
            if (i < marcador_jugador2) {
                t.punto_ganado(jugador2);
            }
        }
        System.out.println(t.obtener_marcador());
    }
}
