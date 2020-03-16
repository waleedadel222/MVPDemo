package com.waleed.mvpdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.waleed.mvpdemo.R;
import com.waleed.mvpdemo.model.Persons;

public class MainActivity extends AppCompatActivity implements MainInterface.IView {

    TextView tvId, tvName, tvMobile;
    ImageView ivPersonImage;
    Button btnGetData;
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        tvId = findViewById(R.id.tvId);
        tvName = findViewById(R.id.tvName);
        tvMobile = findViewById(R.id.tvMobile);
        ivPersonImage = findViewById(R.id.imageView);
        btnGetData = findViewById(R.id.btnGetData);

        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getData();

            }
        });
    }

    @Override
    public void showData(Persons[] persons) {
        tvId.setText(persons[0].getId().toString());
        tvMobile.setText(persons[0].getMobile());
        tvName.setText(persons[0].getName());
        Glide.with(MainActivity.this)
                .load(persons[0].getProfileImge())
                .into(ivPersonImage);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }
}
