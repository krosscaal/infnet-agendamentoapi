/*
 * Author: Krossby Adhemar Camacho Alviz
 * owned by Krossft.
 */
package br.edu.infnet.krossbyagendamentoapi.utils;

import java.util.regex.Pattern;

public class GeralUtils {
    private GeralUtils() {}
    private static final Pattern SOMENTE_NUMEROS = Pattern.compile("^\\d+$");
    private static final Pattern SOMENTE_LETRAS = Pattern.compile("^[\\p{L}\\s]+$");
    private static final Pattern SOMENTE_LETRAS_COM_UM_ESPACAMENTO = Pattern.compile("^[\\p{L}]+(?: [\\p{L}]+)*$");


    public static Boolean contemNumeros(String campo) {
        if (campo == null || campo.trim().isEmpty()) {
            return false;
        }
        return SOMENTE_NUMEROS.matcher(campo).matches();
    }
    public static Boolean contemLetras(String campo) {
        if (campo == null || campo.trim().isEmpty()) {
            return false;
        }
        return SOMENTE_LETRAS.matcher(campo).matches();
    }
    public static Boolean contemLetrasComUmEspacamento(String campo) {
        if (campo == null || campo.trim().isEmpty()) {
            return false;
        }
        return SOMENTE_LETRAS_COM_UM_ESPACAMENTO.matcher(campo).matches();
    }
    public static Boolean verificarNumeroCpfValido(String cpf) {
        if (cpf == null || cpf.trim().length() != 11) {
            return false;
        }
        if (cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") ||
                cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") ||
                cpf.equals("99999999999") || cpf.equals("00000000000")) {
            return false;
        }

        int primeiroDigitoVerificador = (realizarOperacoes(cpf, 8, 10) * 10) % 11;
        if (primeiroDigitoVerificador != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }
        int segundoDigitoVerificador = (realizarOperacoes(cpf, 9, 11) * 10) % 11;
        if (segundoDigitoVerificador != Character.getNumericValue(cpf.charAt(10))) {
            return false;
        }
        return true;
    }

    private static int realizarOperacoes(String cpf, int limite, int multiplicador) {
        int resultado = 0;
        for (int i = 0; i <= limite; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            resultado += digito * multiplicador;
            multiplicador--;
        }
        return resultado;
    }
}
