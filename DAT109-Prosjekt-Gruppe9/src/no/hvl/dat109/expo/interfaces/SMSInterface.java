package no.hvl.dat109.expo.interfaces;

/**
 * Interface for å sende meldinger.
 */
public interface SMSInterface {


    /**
     * Send sms boolean.
     *
     * @param number  telefonnummer.
     * @param message Meldingen som skal sendes. Bør inneholde en sjekk om antall bytes for å unngå at flere meldinger blir sendt.
     * @return returnerer true hvis meldingen er feilfri, false hvis det er feil med sendingen
     */
    // Tlf-nummer er String for å kunne håndtere land kode +.. etc.
    Boolean sendSMS(String number, String message);



}
