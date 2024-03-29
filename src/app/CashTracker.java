package app;

import asimetric.KeyGenerator;
import java.io.File;
import simetric.CredentialCifrator;

/**
 * Clase principal del cifrado para el main
 *
 * @author Jason.
 */
public class CashTracker {

    public final static String CASHTRACKER_PATH = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "CashTracker";

    /**
     * Metodo main para inicializar
     *
     * @param args
     */
    public static void main(String[] args) {
        File carpeta = new File(CASHTRACKER_PATH);

        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        KeyGenerator.generateKeys();
        CredentialCifrator.cifrarTexto("Clave", "cashtracker@zohomail.eu/wMKaCRpmjfmB");
    }
}
