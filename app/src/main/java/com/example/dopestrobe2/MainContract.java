package com.example.dopestrobe2;

public interface MainContract {
    interface View {
        void startScreen();
        void startLed();
    }

    interface Presenter {
        void onLedWasClicked();
        void onScreenWasClicked();
    }

    interface Repository {
        //
    }
}