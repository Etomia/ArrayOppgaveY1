package com.company;

import static javax.swing.JOptionPane.*;

public class UnikeTall {

    // Deklarasjon av array for lagring av tilfeldige heltall
    public int[] unikeTall;

    /* Konstruktør som mottar arrayets lengde som parameter og oppretter arrayet.  */
    public UnikeTall(int length){
        unikeTall = new int[length];
    }

   /* Metode som skal undersøke om et gitt tall finnes i arrayet fra før.
     Tallet det letes etter skal mottas som parameter.
     Metoden skal returnere true hvis tallet finnes i arrayet.
     Hvis ikke skal metoden returnere false. */
    public boolean Exists(int tall){
        boolean value = false;
        for (int j : unikeTall) {
            if (j == tall) {
                value = true;
                break;
            }
        }
        return value;
    }

   /* Metode som skal fylle arrayet med tilfeldige tall mellom 100 og 999,
     begge grenser inkludert. Metoden skal gjøre dette på en måte
     som sikrer at alle tallene er forskjellige. Metoden skal ikke ha
     parametre og heller ikke returnere noen verdi.
     Tips bruk (int)(Math.random()*(900)+100); for å generere tallene mellom 100 og 999
   */
    public void FyllArray(){
        for(int i = 0; i < unikeTall.length; i++){
            int newNumber = (int)(Math.random()*(900)+100);

            while(Exists(newNumber)){
                newNumber = (int)(Math.random()*(900)+100);
            }

            unikeTall[i] = newNumber;
        }
    }

        // Metode som finner og returnerer det minste tallet i arrayet.
    public int Smallest() {
        int small = unikeTall[0];

        for (int i = 1; i < unikeTall.length; i++) {
            if (unikeTall[i] < small) {
                small = unikeTall[i];
            }
        }

        return small;
    }

        // Metode som finner og returnerer det største tallet i arrayet.
    public int Largest(){

        int large = unikeTall[0];

        for(int i = 1; i < unikeTall.length; i++){
            if(unikeTall[i] > large){
                large = unikeTall[i];
            }
        }

        return large;
    }

   /*  Metode som beregner og returnerer den gjennomstnittlige verdien
     (double-verdi) av tallene i arrayet.  */

    public double Average(){
        int sum = 0;
        double average;

        for (int i = 0; i < unikeTall.length; i++) {
            sum += unikeTall[i];
        }

        average = (double)sum / unikeTall.length;

        return average;
    }

   /* Metode som viser tallene i arrayet i en meldngsboks.
     I tillegg skal det, i meldingsboks, skrives ut
     opplysninger om hvilket tall som er minst, hvilket som er størst, og
     hva som er gjennomsnittsverdien, jfr bildet over. Gjennomsnittverdien
     skal skrives ut med en desimal. Bruk gjerne String.format("%.2f,tall) til dette.
     Legg inn mellomrom mellom tallene og skriv ut et passende antall tall
     per linje. */

    public void Show(){
        String ut = "";
        int n = 0;

        for (int j : unikeTall) {
            n++;

            ut += j + " ";

            if (n % 10 == 0) {
                ut += ("\n");
            }
        }

        ut += "\n \n Det Minste tallet er " + Smallest() + "\n Det største tallet er " + Largest() + "\n Gjennomsnittet er " + String.format("%.1f", Average());


        showMessageDialog(null, ut);

    }

}
