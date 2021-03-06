package com.example.hugh.interesting.CustomizeViews.ProgressBar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.example.hugh.interesting.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener {

    @BindView(R.id.start)
    TextView start;
    @BindView(R.id.cpb)
    CircleProgressBar cpb;
    @BindView(R.id.apb)
    ArchProgressBar apb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress);
        ButterKnife.bind(this);

        ViewTreeObserver viewTreeObserver1 = cpb.getViewTreeObserver();
        viewTreeObserver1.addOnGlobalLayoutListener(this);
    }

    @OnClick(R.id.start)
    public void onViewClicked() {
        cpb.start();
    }

    @Override
    public void onGlobalLayout() {
        cpb.start();
        apb.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cpb != null) {
            ViewTreeObserver viewTreeObserver = cpb.getViewTreeObserver();
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
    }
}
