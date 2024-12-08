package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SampleTest {

    private final Sample sample = new Sample();

    @Test
    void add_2_and_2_should_return_4() {
        int result = sample.op(Sample.Operation.ADD, 2, 2);
        Assertions.assertThat(result)
            .as("Addition of 2 and 2")
            .isEqualTo(4);
    }

    @Test
    void multiply_3_and_3_should_return_9() {
        int result = sample.op(Sample.Operation.MULTIPLY, 3, 3);
        Assertions.assertThat(result)
            .as("Multiplication of 3 and 3")
            .isEqualTo(9);
    }

    @Test
    void add_negative_numbers_should_return_correct_result() {
        int result = sample.op(Sample.Operation.ADD, -1, -1);
        Assertions.assertThat(result)
            .as("Addition of -1 and -1")
            .isEqualTo(-2);
    }

    @Test
    void multiply_by_zero_should_return_zero() {
        int result = sample.op(Sample.Operation.MULTIPLY, 5, 0);
        Assertions.assertThat(result)
            .as("Multiplication of 5 and 0")
            .isEqualTo(0);
    }
}

