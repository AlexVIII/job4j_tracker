package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void process() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3fg", "Sofa"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3fg"), is(new Order("3fg", "Sofa")));
    }

    @Test
    public void processDublicateNew() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3fgFF", "Soffaoffer"));
        orders.add(new Order("3fgFF", "Soffa"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3fgFF"), is(new Order("3fgFF", "Soffa")));
    }
}