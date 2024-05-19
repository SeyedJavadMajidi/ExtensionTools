package softjam.test.mvp1.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import softjam.test.mvp1.R;
import softjam.test.mvp1.presenters.MathdActivityPresenter;
//import softjam.tools.mimetype.JMimeType;

public class MathdActivity extends AppCompatActivity implements MathdActivityPresenter.MyView {
    MathdActivityPresenter mathdActivityPresenter;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathd);
//        JMimeType jMimeType = new JMimeType();
//        Log.d("KAKAKAKKA",jMimeType.searchFor(".apk"));
        mathdActivityPresenter = new MathdActivityPresenter(this);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathdActivityPresenter.sum(67, 78);
            }
        });
    }

    @Override
    public void Mine(int result) {

    }

    @Override
    public void Sum(int result) {
        Toast.makeText(getApplicationContext(), "" + result, Toast.LENGTH_LONG).show();
    }

    public String checkExe(String uri) {
        String extension = uri.substring(uri.lastIndexOf("."));
        String[][] extensions = {
                {"[IMAGE]", ".jpg", ".gif", ".jpeg", ".png", ".bmp", ".ico", ".cur"},
                {"[Video]", ".mp4", ".mov", ".avi", ".3gp", ".flv", ".mkv"},
                {"[PDF]", ".pdf"},
                {"[Word]", ".doc", ".docx"},
        };
        for (int i = 0; i < extensions.length; i++) {
            for (String s : extensions[i]) {
                int x = s.indexOf(extension);
                if (x >= 0) {
                    return extensions[i][0];
                }
            }
        }
        return "Error";
    }
}