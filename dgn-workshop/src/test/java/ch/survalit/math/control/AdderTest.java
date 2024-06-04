package ch.survalit.math.control;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AdderTest {

    @Test
    @DisplayName("Add 10 and 20")
    void addTenAndTwenty() {
        var result = Adder.add(10, 20);

        assertThat(result).isEqualTo(30);
    }
    
    @Test
    @DisplayName("Add 10 to each integer - lambda")
    void streamingAdd() {
        var integers = List.of(1, 2, 3, 4, 5);
        var result = integers.stream()
                .map(i -> Adder.add(i, 10))
                .toList();

        assertThat(result).contains(11,12,13,14,15);
    }

    @Test
    @DisplayName("Add 10 to each integer - method reference")
    void add10() {
        var integers = List.of(1, 2, 3, 4, 5);
        var result = integers.stream()
                .map(Adder::addTen)
                .toList();

        assertThat(result).contains(11,12,13,14,15);
    }

}