public class Tenis{

    private String nombre_jugador1;
    private String nombre_jugador2;
    private int puntaje_jugador1 = 0;
    private int puntaje_jugador2 = 0;


    public Tenis(String nombre_jugador1, String nombre_jugador2) {
        this.nombre_jugador1 = nombre_jugador1;
        this.nombre_jugador2 = nombre_jugador2;
    }

    public void punto_ganado(String nombre_jugador) {
        if (nombre_jugador == nombre_jugador1) {
            puntaje_jugador1++;
        }else{
            puntaje_jugador2++;
        }
    }

    public int obtener_puntaje(String nombre_jugador){
        if (nombre_jugador == nombre_jugador1) {
            return puntaje_jugador1;
        }else{
            return puntaje_jugador2;
        }
    }

    public String obtener_marcador() {
        String marcador = "";
        int marcador_temporal = 0;
        if (puntaje_jugador1 == puntaje_jugador2) {
            switch (puntaje_jugador1) {
                case 0:
                    marcador = "Love-All";
                    break;
                case 1:
                    marcador = "Fifteen-All";
                    break;
                case 2:
                    marcador = "Thirty-All";
                    break;
                default:
                    marcador = "Deuce";
                    break;
            }
        }else if (puntaje_jugador1>=4 || puntaje_jugador2>=4){
            int diferencia_marcador = puntaje_jugador1-puntaje_jugador2;
            if (diferencia_marcador == 1) {
                marcador = "Advantage " + nombre_jugador1;
            }
            else if (diferencia_marcador ==-1){
                marcador ="Advantage " + nombre_jugador2;
            }
            else if(diferencia_marcador>=2){
                marcador = "Win for " + nombre_jugador1;
            }
            else{
                marcador = "Win for " + nombre_jugador2;
            }

        }else{
            for (int i=1; i<3; i++){
                if (i==1) {
                    marcador_temporal = puntaje_jugador1;
                }else {
                    marcador+="-"; marcador_temporal = puntaje_jugador2;
                }
                switch(marcador_temporal){
                    case 0:
                        marcador+="Love";
                        break;
                    case 1:
                        marcador+="Fifteen";
                        break;
                    case 2:
                        marcador+="Thirty";
                        break;
                    case 3:
                        marcador+="Forty";
                        break;
                }
            }
        }
        return marcador;
    }
}

