public class Idioma {
    private int idioma;
    private String[] palabras_eu = {"Love", "Fifteen", "Thirty", "Forty","All", "Deuce", "Adventage", "Win for"};
    private String[] palabras_fr = {"Amour", "Quinze", "Trente", "Quarente","égaux", "Diable", "Avantage", "Victoire"};
    private String[] palabras_es = {"Cero", "Quince", "Treinta", "Cuarenta","iguales", "Empate", "Ventaja para", "Gana"};
    private String[] palabras_al = { "Null", "Füntzehn", "Dreibig", "Vierzig","gleich", "Ziehen", "Vorteil für", "Wunsch"};

    public Idioma(int idioma) {
        this.idioma = idioma;
    }

    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }

    public String generar_palabra(int i){
        String palabra = "";
        switch (idioma)
        {
            case 1:
                palabra = palabras_es[i];
                break;
            case 2:
                palabra = palabras_eu[i];
                break;
            case 3:
                palabra = palabras_fr[i];
                break;
            case 4:
                palabra = palabras_al[i];
                break;
        }
        return palabra;
    }
}

