package softjam.tools.mimetype;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.MimeTypeMap;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class JMimeType {
    private int countRedirect = 0;

    public boolean CheckWithMimetype(ArrayList<String> list, String url) {
        String mimetype = GetMimetypeFromUrlAdvanced(url);
        return list.contains(mimetype);
    }

    public boolean CheckWithExtension(ArrayList<String> list, String url) {
        String extension = GetExtensionFromUrlAdvanced(url);
        return list.contains(extension);
    }

    public String GetExtensionFromUrlAdvanced(String urlString) {
        return GetExtensionFromMimetype(GetMimetypeFromUrlAdvanced(urlString));
    }

    public String GetMimetypeFromUrlAdvanced(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            if (isRedirect(connection.getResponseCode())) {
                if (countRedirect == 2) {
                    countRedirect = 0;
                    return "Error1";
                }
                String newUrl = connection.getHeaderField("Location");
                return GetMimetypeFromUrlAdvanced(newUrl);
            }
            return connection.getContentType();
        } catch (ProtocolException e) {
            return "Error2";
        } catch (MalformedURLException e) {
            return "Error3";
        } catch (IOException e) {
            return "Error4";
        }
//        return "Error5";
    }

    protected boolean isRedirect(int statusCode) {
        if (statusCode != HttpURLConnection.HTTP_OK) {
            if (statusCode == HttpURLConnection.HTTP_MOVED_TEMP || statusCode == HttpURLConnection.HTTP_MOVED_PERM || statusCode == HttpURLConnection.HTTP_SEE_OTHER) {
                countRedirect++;
                return true;
            }
        }
        return false;
    }

    public String GetMimetypeFromUrlBasic(String url) {
        url = url.substring(url.lastIndexOf(".") + 1);
        return GetMimetypeFromExtension(url);
    }

    public String GetMimetypeFromExtension(String url) {
        MimeTypeMap m = MimeTypeMap.getSingleton();
        return m.getMimeTypeFromExtension(url);
    }

    public String GetExtensionFromMimetype(String url) {
        MimeTypeMap m = MimeTypeMap.getSingleton();
        return m.getExtensionFromMimeType(url);
    }


}
