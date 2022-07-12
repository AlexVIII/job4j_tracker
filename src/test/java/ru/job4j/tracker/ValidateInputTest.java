package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputMinus1() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected, is(-1));
    }

    @Test
    public void whenInvalidOneInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected, is(0));
    }

    @Test
    public void whenInvalidThreeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] data = new int[3];
        data[0] = input.askInt("Enter menu");
        data[1] = input.askInt("Enter menu");
        data[2] = input.askInt("Enter menu");
        assertThat(data, is(new int[]{0, 1, 2}));
    }
}