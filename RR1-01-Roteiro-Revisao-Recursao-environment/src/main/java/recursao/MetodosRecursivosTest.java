package recursao;

import static org.junit.jupiter.api.Assertions.*;

class MetodosRecursivosTest {

    MetodosRecursivos teste = new MetodosRecursivos();

    @org.junit.jupiter.api.Test
    void calcularSomaArrayTeste() {
        int[] v = {1,2,3,4,5};
        assertEquals(teste.calcularSomaArray(v), 15);
    }

    @org.junit.jupiter.api.Test
    void calcularFatorialTeste() {
        assertEquals(teste.calcularFatorial(1),1);
        assertEquals(teste.calcularFatorial(0),1);
        assertEquals(teste.calcularFatorial(5),120);
        assertEquals(teste.calcularFatorial(10),3628800);
    }

    @org.junit.jupiter.api.Test
    void calcularFibonacciTeste() {
        System.out.println("Teste 1");
        assertEquals(teste.calcularFibonacci(1),1);
        System.out.println("Teste 2");
        assertEquals(teste.calcularFibonacci(2),1);
        System.out.println("Teste 3");
        assertEquals(teste.calcularFibonacci(3),2);
        System.out.println("Teste 4");
        assertEquals(teste.calcularFibonacci(4),3);
        System.out.println("Teste 5");
        assertEquals(teste.calcularFibonacci(5),5);
        System.out.println("Teste 6");
        assertEquals(teste.calcularFibonacci(6),8);
        System.out.println("Teste 7");
        assertEquals(teste.calcularFibonacci(7),13);
        System.out.println("Teste 8");
        assertEquals(teste.calcularFibonacci(8),21);
        System.out.println("Teste 9");
        assertEquals(teste.calcularFibonacci(9),34);
    }

    @org.junit.jupiter.api.Test
    void countNotNullTeste() {
        Object[] array1 = {1,2,3,4,5};
        Object[] array2 = {1,2,3,null,4};
        Object[] array3 = {null,null,null,null};
        Object[] array4 = {};
        Object[] array5 = {1,null, 2,3,null,4,5};
        Object[] array6 = {null,2,3,null,4,5,null};
        assertEquals(teste.countNotNull(array1),5);
        assertEquals(teste.countNotNull(array2),4);
        assertEquals(teste.countNotNull(array3),0);
        assertEquals(teste.countNotNull(array4),0);
        assertEquals(teste.countNotNull(array5),5);
        assertEquals(teste.countNotNull(array6),4);
    }

    @org.junit.jupiter.api.Test
    void potenciaDe2Teste() {
        assertEquals(teste.potenciaDe2(0),1);
        assertEquals(teste.potenciaDe2(1),2);
        assertEquals(teste.potenciaDe2(2),4);
        assertEquals(teste.potenciaDe2(3),8);
        assertEquals(teste.potenciaDe2(10),1024);
        assertEquals(teste.potenciaDe2(20),1048576);
        assertEquals(teste.potenciaDe2(30),1073741824);
    }

    @org.junit.jupiter.api.Test
    void progressaoAritmeticaTeste() {
        assertEquals(teste.progressaoAritmetica(3,2,5),11);
        assertEquals(teste.progressaoAritmetica(4,3,5),16);
        assertEquals(teste.progressaoAritmetica(9,8,7),57);
        assertEquals(teste.progressaoAritmetica(33,17,13),237);
    }

    @org.junit.jupiter.api.Test
    void progressaoGeometricaTeste() {
        assertEquals(teste.progressaoGeometrica(2,2,4),16);
        assertEquals(teste.progressaoGeometrica(4,5,10),7812500);
        assertEquals(teste.progressaoGeometrica(13,17,5),1085773);
        assertEquals(teste.progressaoGeometrica(8,3,12),1417176);
    }
}