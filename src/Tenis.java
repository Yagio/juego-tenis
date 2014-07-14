public class Tenis{

    private String nombre_jugador1;
    private String nombre_jugador2;
    private int puntaje_jugador1 = 0;
    private int puntaje_jugador2 = 0;
    Idioma idioma = new Idioma(1);


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

    public void cambiar_punto(String nombre_jugador, int puntos) {
        if (nombre_jugador == nombre_jugador1) {
            puntaje_jugador1 = puntos;
        }else{
            puntaje_jugador2 = puntos;
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
                    marcador = "0";
                    break;
                case 1:
                    marcador = "1";
                    break;
                case 2:
                    marcador = "2";
                    break;
                default:
                    marcador = "3";
                    break;
            }
        }else if (puntaje_jugador1>=4 || puntaje_jugador2>=4){
            int diferencia_marcador = puntaje_jugador1-puntaje_jugador2;
            if (diferencia_marcador == 1) {
                marcador = "4,0,1";
            }
            else if (diferencia_marcador ==-1){
                marcador ="4,0,2";
            }
            else if(diferencia_marcador>=2){
                marcador = "5,0,1";
            }
            else{
                marcador = "5,0,2";
            }

        }else{
            for (int i=1; i<3; i++){
                if (i==1) {
                    marcador_temporal = puntaje_jugador1;
                }else {
                    marcador+=",";
                    marcador_temporal = puntaje_jugador2;
                }
                switch(marcador_temporal){
                    case 0:
                        marcador+="6";
                        break;
                    case 1:
                        marcador+="7";
                        break;
                    case 2:
                        marcador+="8";
                        break;
                    case 3:
                        marcador+="9";
                        break;
                }
            }
        }
        return marcador;
    }

    public String generar_marcador(){
        String marcador = obtener_marcador();
        String[] array_marcador;
        String palabra1;
        String palabra2;
        String resultado = "";

        switch (marcador.length()) {
            case 1:
                resultado = idioma.generar_palabra(Integer.parseInt(marcador));
                break;
            case 3:
                array_marcador = marcador.split(",");
                palabra1 = idioma.generar_palabra(Integer.parseInt(array_marcador[0]));
                palabra2  = idioma.generar_palabra(Integer.parseInt(array_marcador[1]));
                resultado = palabra1 + "-" + palabra2;
                break;
            case 5:
                array_marcador = marcador.split(",");
                palabra1 = idioma.generar_palabra(Integer.parseInt(array_marcador[0]));
                if (Integer.parseInt(array_marcador[2]) == 1){
                    palabra2 = nombre_jugador1;
                }else{
                    palabra2 = nombre_jugador2;
                }
                resultado = palabra1 + " " + palabra2;
                break;
        }

        return resultado;

    }

    public void setIdioma(String nombre_idioma){
        if (nombre_idioma == "Español"){
            idioma.setIdioma(1);
        }else if (nombre_idioma == "Ingles"){
            idioma.setIdioma(2);
        }else if (nombre_idioma == "Frances"){
            idioma.setIdioma(3);
        }else if (nombre_idioma == "Aleman"){
            idioma.setIdioma(4);
        }

    }
}

