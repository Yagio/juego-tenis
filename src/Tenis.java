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

    public void setNombre_jugador1(String nombre_jugador1) {
        this.nombre_jugador1 = nombre_jugador1;
    }

    public void setNombre_jugador2(String nombre_jugador2) {
        this.nombre_jugador2 = nombre_jugador2;
    }

    public String getNombre_jugador1() {
        return nombre_jugador1;
    }

    public String getNombre_jugador2() {
        return nombre_jugador2;
    }

    public String obtener_marcador() {
        String marcador;
        if (puntaje_jugador1 < 4 && puntaje_jugador2 < 4 && !(puntaje_jugador1 + puntaje_jugador2 == 6)) {
            String[] puntajes = {"0", "1", "2", "3"};
            marcador = puntajes[puntaje_jugador1];
            return (puntaje_jugador1 == puntaje_jugador2) ? (marcador + ",4") : (marcador + "," + puntajes[puntaje_jugador2]);
        } else {
            if (puntaje_jugador1 == puntaje_jugador2)
                return "5";
            marcador = ((puntaje_jugador1 > puntaje_jugador2) ? nombre_jugador1 : nombre_jugador2);
            return ((((puntaje_jugador1 - puntaje_jugador2) * (puntaje_jugador1 - puntaje_jugador2)) == 1)) ? "6," + marcador : "7," + marcador;
        }
    }

    public String generar_marcador(){
        String marcador = obtener_marcador();
        String[] array_marcador;
        String palabra1;
        String palabra2;
        String resultado = "";

        if (marcador.length() == 1){
            resultado = idioma.generar_palabra(Integer.parseInt(marcador));
        }else if(marcador.length() >= 2){
            array_marcador = marcador.split(",");
            if (Integer.parseInt(array_marcador[0]) >= 5 ){
                palabra1 = idioma.generar_palabra(Integer.parseInt(array_marcador[0]));
                palabra2 = array_marcador[1];
                resultado = palabra1 +" "+ palabra2;
            }else{
                palabra1 = idioma.generar_palabra(Integer.parseInt(array_marcador[0]));
                palabra2  = idioma.generar_palabra(Integer.parseInt(array_marcador[1]));
                resultado = palabra1 + "-" + palabra2;
            }
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

