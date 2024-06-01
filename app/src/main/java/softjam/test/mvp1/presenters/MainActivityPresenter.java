package softjam.test.mvp1.presenters;

import android.os.AsyncTask;

import java.util.ArrayList;

import softjam.test.mvp1.models.MeFile;
import softjam.tools.mimetype.JMimeType;

public class MainActivityPresenter {
    private JMimeType jMimeType;

    private MeFile meFile;
    private View view;

    public MainActivityPresenter(View view) {
        this.meFile = new MeFile();
        this.view = view;
        this.jMimeType = new JMimeType();
    }

    public void Check(String string) {
        new CheckClass().execute(string);
    }

    public void addMimeTypes(ArrayList<String> mims) {
        meFile.setMimeType(mims);
    }

    private class CheckClass extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            if (jMimeType.CheckWithMimetype(meFile.getMimeType(), strings[0]))
                view.Success("Ok");
            else
                view.Failure("Error");
            return "";
        }
    }

    public interface View {
        void Success(String message);

        void Failure(String message);
    }
}