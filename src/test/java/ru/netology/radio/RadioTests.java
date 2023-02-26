package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTests {

    @ParameterizedTest
    @CsvSource({
            "Valid value, 5, 5",
            "Boundary value, -1, 0",
            "Boundary value, 0, 0",
            "Boundary value, 1, 1",
            "Boundary value, 8, 8",
            "Boundary value, 9, 9",
            "Boundary value, 10, 0",
            "Invalid value, 18, 0",
            "Invalid value, -9, 0"

    })
    public void setCurrentStation(String nameTest, int currentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }


    @ParameterizedTest
    @CsvSource({
            "Valid value, 5, 6",
            "Boundary value, 0, 1",
            "Boundary value, 1, 2",
            "Boundary value, 8, 9",
            "Boundary value, 9, 0",

    })

    public void setNextStation(String nameTest, int currentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.nextStation();
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource({
            "Valid value, 5, 4",
            "Boundary value, 0, 9",
            "Boundary value, 1, 0",
            "Boundary value, 8, 7",
            "Boundary value, 9, 8",
    })
    public void setPrevStation(String nameTest, int currentStation, int expectedStation) {
        Radio radio = new Radio();
        radio.setCurrentStation(currentStation);
        radio.prevStation();
        Assertions.assertEquals(radio.getCurrentStation(), expectedStation);
    }

    @ParameterizedTest
    @CsvSource({
            "Valid value, 5, 6",
            "Boundary value, 0, 1",
            "Boundary value, 1, 2",
            "Boundary value, 99, 100",
            "Boundary value, 100, 100",

    })

    public void setIncreaseVolume(String nameTest, int currentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.increaseVolume();
        Assertions.assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @ParameterizedTest
    @CsvSource({
            "Valid value, 5, 4",
            "Boundary value, 0, 0",
            "Boundary value, 1, 0",
            "Boundary value, 100, 99",
            "Boundary value, 99, 98",
    })
    public void setDecreaseVolume(String nameTest, int currentVolume, int expectedVolume) {
        Radio radio = new Radio();
        radio.setCurrentVolume(currentVolume);
        radio.decreaseVolume();
        Assertions.assertEquals(radio.getCurrentVolume(), expectedVolume);
    }

    @Test
    public void shouldSetRangeOfStation() {
        Radio radio = new Radio(50);
        Assertions.assertEquals(49, radio.getMaxStation());
        Assertions.assertEquals(0, radio.getMinStation());
    }

    @Test
    public void shouldNotSetRangeOfStation() {
        Radio radio = new Radio();
        Assertions.assertEquals(9, radio.getMaxStation());
        Assertions.assertEquals(0, radio.getMinStation());
    }
}
