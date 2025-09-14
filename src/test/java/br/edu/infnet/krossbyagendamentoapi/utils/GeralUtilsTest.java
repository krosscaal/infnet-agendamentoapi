package br.edu.infnet.krossbyagendamentoapi.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class GeralUtilsTest {

    @Test
    void contemNumeros() {
        assertTrue(GeralUtils.contemNumeros("123456789"));
    }

    @Test
    void contemLetras() {
        assertTrue(GeralUtils.contemLetras("Nome e Sobrenome"));
    }
}