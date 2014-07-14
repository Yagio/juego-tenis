public class Idioma {
    private int idioma;
    private String[] palabras_eu = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce", "Adventage", "Win", "Love", "Fifteen", "Thirty", "Forty"};
    private String[] palabras_fr = {"Amour-égaux", "Quinze-égaux", "Trente-égaux", "Diable", "Avantage", "Victoire", "Amour", "Quinze", "Trente", "Quarente"};
    private String[] palabras_es = {"Cero-iguales", "Quince-iguales", "Treinta-iguales", "Empate", "Ventaja para", "Gana", "Cero", "Quince", "Treinta", "Cuarenta"};
    private String[] palabras_al = {"Null-gleich", "Füntzehn-gleich", "Dreibig-gleich", "Ziehen", "Vorteil für", "Wunsch", "Null", "Füntzehn", "Dreibig", "Vierzig"};

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

