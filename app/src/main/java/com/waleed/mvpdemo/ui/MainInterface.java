package com.waleed.mvpdemo.ui;

import com.waleed.mvpdemo.model.Persons;

public interface MainInterface {


    interface IView {
        //for getting the data
        void showData(Persons[] persons);
        void showError(String error);

       // the response of uploading the data
      //  void showResult(String response);

    }

    interface IPresenter {
        void getData();

        //in case you know to upload data
        // void saveData(Persons[] persons);
    }
}
