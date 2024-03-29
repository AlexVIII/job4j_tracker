package ru.job4j.search;

import org.junit.Test;
import ru.job4j.seach.PriorityQueue;
import ru.job4j.seach.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        var result = queue.take();
       assertThat(result.getDesk(), is("urgent"));
    }
}