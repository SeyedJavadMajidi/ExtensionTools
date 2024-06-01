package softjam.test.mvp1.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MeFile {
    private ArrayList<String> mimeType;

    public ArrayList<String> getMimeType() {
        return mimeType;
    }

    public void setMimeType(ArrayList<String> mimeType) {
        this.mimeType = mimeType;
    }
}
