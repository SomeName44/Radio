package ru.netology.radio;

public class Radio {
    private int currentStation;
    public int minStation = 0;
    public int maxStation = 9;
    private int currentVolume;
    public int minVolume = 0;
    public int maxVolume = 100;


    public Radio() {

    }

    public Radio(int amountStation) {
        maxStation = amountStation - 1;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public int getMinStation() {
        return minStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation < minStation || currentStation > maxStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public int getCurrentStation() {
        return currentStation;
    }


    public void nextStation() {
        if (maxStation == currentStation) {
            this.currentStation = minStation;
        } else {
            this.currentStation = currentStation + 1;
        }

    }

    public void prevStation() {
        if (minStation == currentStation) {
            this.currentStation = maxStation;
        } else {
            this.currentStation = currentStation - 1;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume == maxVolume) {
            return;
        } else {
            this.currentVolume = currentVolume + 1;
        }
    }

    public void decreaseVolume() {
        if (currentVolume == minVolume) {
            return;
        } else {
            this.currentVolume = currentVolume - 1;
        }
    }
}