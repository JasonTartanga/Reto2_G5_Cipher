package asimetric;

/**
 *
 * @author Jason.
 */
import app.CashTracker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.util.logging.Logger;

public class KeyGenerator {

    public static void generateKeys() {
        try {
            //Especifico el tipo de clave que quiero generar
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            //Creo la clave publica
            PublicKey publicKeyAndMore = keyPair.getPublic();
            byte[] publicKeyBytes = publicKeyAndMore.getEncoded();
            try (FileOutputStream publicKeyFile = new FileOutputStream(CashTracker.CASHTRACKER_PATH + "\\publicKey.der")) {
                publicKeyFile.write(publicKeyBytes);
            }

            //Creo la clave privada
            PrivateKey privateKey = keyPair.getPrivate();
            byte[] privateKeyBytes = privateKey.getEncoded();
            try (FileOutputStream privateKeyFile = new FileOutputStream(CashTracker.CASHTRACKER_PATH + "\\privateKey.der")) {
                privateKeyFile.write(privateKeyBytes);
            }

            System.out.println("Ficheros de Clave Generados!");
        } catch (IOException | NoSuchAlgorithmException e) {
            Logger.getLogger(KeyGenerator.class.getName()).severe(e.getLocalizedMessage());
        }
    }
}
