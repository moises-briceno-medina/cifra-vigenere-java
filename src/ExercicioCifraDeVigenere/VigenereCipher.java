package ExercicioCifraDeVigenere;

import ExercicioCifraDeVigenere.constants.MensagensConstants;
import ExercicioCifraDeVigenere.utils.ScanUtils;

import java.util.Arrays;
import java.util.List;

public class VigenereCipher {
    public static void main(String[] args) {
        vigenereCipherSolution();
    }

    private static void vigenereCipherSolution() {
        ScanUtils scan = new ScanUtils();

        //        lista de letras
        final List<String> alphabetList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

        System.out.println(MensagensConstants.MENSAGENS_VIGENERE_CIPHER.VIGENERE_CIPHER);

        //Recebe uma mensagem
        String message = scan.coletaTexto(MensagensConstants.MENSAGENS_SCANNER.TYPE_THE_TEXT);

        //Recebe uma CHAVE
        String key = scan.coletaTexto(MensagensConstants.MENSAGENS_SCANNER.TYPE_THE_KEY);

        //FAZ A ESCOLHA
        int choice = scan.coletaInt(MensagensConstants.MENSAGENS_VIGENERE_CIPHER.CHOICE);
        switch (choice) {
            case 1:
                String finalTextEncry = encryptText(alphabetList, message, key);
                System.out.println(MensagensConstants.MENSAGENS_VIGENERE_CIPHER.ENCRYPTED_TEXT + finalTextEncry);
                break;
            case 2:
                String finalTextDecry = decryptText(alphabetList, message, key);
                System.out.println(MensagensConstants.MENSAGENS_VIGENERE_CIPHER.DECRYPTED_TEXT + finalTextDecry);
                break;
            default:
                System.out.println(MensagensConstants.MENSAGENS_VIGENERE_CIPHER.NO_OPTIONS_CHOSEN);
                break;
        }
    }

    public static String encryptText(List<String> alphabet, String message, String key) {

        String encryptedText = "";
        message = message.toUpperCase();
        key = key.toUpperCase();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            int position = alphabet.indexOf(Character.toString(c));

            if (position == -1) {
                encryptedText += (c);
            } else {
                int shift = key.charAt(i % key.length()) - 'A'; // o deslocamento é calculado subtraindo o caractere correspondente da chave ( key.charAt(i % key.length())) pelo caractere 'A'
                encryptedText += alphabet.get((position + shift) % alphabet.size());
            }
        }
        return encryptedText;
    }

    public static String decryptText(List<String> alphabet, String message, String key) {

        String decryptedText = "";
        message = message.toUpperCase();
        key = key.toUpperCase();

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            int position = alphabet.indexOf(Character.toString(c));

            if (position == -1) {
                decryptedText += (c);
            } else {
                int shift = key.charAt(i % key.length()) - 'A'; // o deslocamento é calculado subtraindo o caractere correspondente da chave ( key.charAt(i % key.length())) pelo caractere 'A'
                decryptedText += alphabet.get((position - shift + alphabet.size()) % alphabet.size());
            }
        }
        return decryptedText;
    }
}