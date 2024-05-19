package softjam.tools.mimetype;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JMimeType {

    ArrayList<String[]> files;

    public JMimeType() {
        try {
            JSONArray obj = new JSONArray((new dt()).json);
            files = new ArrayList<>();
            for (int i = 0; i < obj.length(); i++) {
                JSONObject js = obj.getJSONObject(i);
                JSONArray jsonArray = js.getJSONArray("fileTypes");
                for (int j = 0; j < jsonArray.length(); j++) {
                    files.add(new String[]{js.getString("name"), jsonArray.getString(j)});
                }
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String searchFor(String data) {
        for (int i = 0; i < files.size(); i++) {
            String[] unitString = files.get(i);
            if (unitString[1].contains(data)) {
                return unitString[0];
            }
        }
        return "Error";
    }
}
