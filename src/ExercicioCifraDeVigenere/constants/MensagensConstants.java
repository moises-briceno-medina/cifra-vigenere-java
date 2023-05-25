package ExercicioCifraDeVigenere.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MensagensConstants {
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MENSAGENS_VIGENERE_CIPHER {

        String VIGENERE_CIPHER = """
                        ######################################
                        #---------- Cifra de Vigenère ----------#
                        ######################################
                """;
        String CHOICE = "Escolha a opção que deseja:\n " + "Criptografar o texto = [1]\n " + "Descriptografar o texto = [2]";
        String ENCRYPTED_TEXT = "Texto criptografado: ";
        String DECRYPTED_TEXT = "Texto descriptografado: ";
        String NO_OPTIONS_CHOSEN = "Nenhuma das opções foi escolhida";
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface MENSAGENS_SCANNER {
        String TYPE_THE_TEXT = "Digte o texto, Por favor: ";
        String TYPE_THE_KEY = "Digte a chave, Por favor: ";
    }
}
