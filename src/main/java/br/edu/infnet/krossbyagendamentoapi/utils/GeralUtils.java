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

    public static Boolean contemNumeros(String campo) {
        return null;
    }
    public static Boolean contemLetras(String campo) {
        return null;
    }
}
