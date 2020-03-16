package com.waleed.mvpdemo.ui;

import com.waleed.mvpdemo.model.Persons;
import com.waleed.mvpdemo.utlis.APIClient;
import com.waleed.mvpdemo.utlis.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainInterface.IPresenter {

    MainInterface.IView iView;

    public MainPresenter(MainInterface.IView iView) {
        this.iView = iView;
    }

    @Override
    public void getData() {

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Persons[]> call = apiInterface.getPersons();
        call.enqueue(new Callback<Persons[]>() {

            @Override
            public void onResponse(Call<Persons[]> call, Response<Persons[]> response) {

                if (response.isSuccessful()) {
                    iView.showData(response.body());
                }
            }

            @Override
            public void onFailure(Call<Persons[]> call, Throwable t) {

                iView.showError(t.getMessage()
                );
            }
        });


    }
}

