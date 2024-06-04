package ch.survalit.math.control;

public interface Adder {

    int ten = 10;

    static int add(int a, int b) {
        return a + b;
    }

    static int addTen(int a) {
        return a + ten;
    }
}
