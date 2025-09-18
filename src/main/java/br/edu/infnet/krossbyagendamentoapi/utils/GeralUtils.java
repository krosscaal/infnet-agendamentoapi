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
        return null;
    }
    public static Boolean contemLetras(String campo) {
        return null;
    }
    public static Boolean contemLetrasComUmEspacamento(String campo) {
        return null;
    }
    public static Boolean VerificarNumeroCpfValido(String cpf) {
        return null;
    }
}
