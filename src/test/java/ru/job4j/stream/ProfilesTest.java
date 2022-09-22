package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProfilesTest {
    @Test
    public void whenTestMethodCollect() {
        Address first = new Address("City 1", "Street 1", 1, 2);
        Address second = new Address("City 2", "Street 2", 2, 3);
        Address third = new Address("City 3", "Street 3", 3, 4);
        List<Profile> profiles = Arrays.asList(
                new Profile(first),
                new Profile(second),
                new Profile(third)
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expect = Arrays.asList(first, second, third);
        assertThat(result).containsAll(expect);
    }
}