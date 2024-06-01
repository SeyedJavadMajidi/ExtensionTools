package softjam.test.mvp1.views;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import softjam.test.mvp1.presenters.MainActivityPresenter;
import softjam.test.mvp1.R;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {

    private MainActivityPresenter presenter;
    private TextView myTextView;
    public EditText urlFile;
    private ProgressBar progressBar;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitObject();

        ArrayList<String> mims = new ArrayList<String>();
        mims.add("image/jpeg");
        mims.add("image/png");
        presenter.addMimeTypes(mims);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.Check(urlFile.getText().toString());
            }
        });
    }

    private void InitObject() {
        presenter = new MainActivityPresenter(this);
        myTextView = findViewById(R.id.myTextView);
        urlFile = findViewById(R.id.urlFile);
        btnCheck = findViewById(R.id.btnCheck);
    }

    @Override
    public void Success(String message) {
        myTextView.setTextColor(Color.GREEN);
        myTextView.setText(message);
    }

    @Override
    public void Failure(String message) {
        myTextView.setTextColor(Color.RED);
        myTextView.setText(message);
    }
}