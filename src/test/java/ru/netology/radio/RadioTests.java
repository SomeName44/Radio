package ru.netology.radio;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.netology.radio.Radio;


public class RadioTests {
    @ParameterizedTest //Проверка номер радиостанции от 0 до 9
    @CsvFileSource(files = "src/test/resources/setRadioNumber.cvs")
    public void shouldSetRadioNumber(int expected, int radioNumber) {
        Radio radio = new Radio();
        radio.setRadioNumber(radioNumber);

        int actual = radio.getRadioNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test //Максимальная станция
    public void shouldSetToMaxNumber() {
        Radio radio = new Radio();
        radio.setToMaxNumber();

        int expected = 9;
        int actual = radio.getRadioNumber();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest // Переключение радио на след. радиостанцию
    @CsvFileSource(files = "src/test/resources/nextRadioNumber.cvs")
    public void shouldNextRadioNumber(int expected, int newRadioNumber) {
        Radio radio = new Radio();
        radio.setRadioNumber(newRadioNumber);
        radio.nextRadioNumber();

        int actual = radio.getRadioNumber();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest // Переключение радио на предыдущую радиостанцию
    @CsvFileSource(files = "src/test/resources/prevRadioNumber.cvs")
    public void shouldPrevRadioNumber(int expected, int newRadioNumber) {
        Radio radio = new Radio();
        radio.setRadioNumber(newRadioNumber);
        radio.prevRadioNumber();

        int actual = radio.getRadioNumber();
        Assertions.assertEquals(expected, actual);
    }

//////////// Volume

    @ParameterizedTest //Проверка звука в диапозоне от 0 до 10
    @CsvFileSource(files = "src/test/resources/setSoundVolume.cvs")
    public void shouldSetSoundVolume(int expected, int newSoundVolume) {
        Radio radio = new Radio();
        radio.setSoundVolume(newSoundVolume);

        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test //Максимальный звук
    public void shouldSetToMaxVolume() {
        Radio radio = new Radio();
        radio.setToMaxVolume();

        int expected = 10;
        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest //Проверка увеличения звука
    @CsvFileSource(files = "src/test/resources/nextSoundVolume.cvs")
    public void shouldNextSoundVolume(int expected, int newSoundVolume) {
        Radio radio = new Radio();
        radio.setSoundVolume(newSoundVolume);
        radio.nextSoundVolume();

        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest //Проверка уменьшения звука
    @CsvFileSource(files = "src/test/resources/prevSoundVolume.cvs")
    public void shouldPrevSoundVolume(int expected, int newSoundVolume) {
        Radio radio = new Radio();
        radio.setSoundVolume(newSoundVolume);
        radio.prevSoundVolume();

        int actual = radio.getSoundVolume();
        Assertions.assertEquals(expected, actual);
    }
}
