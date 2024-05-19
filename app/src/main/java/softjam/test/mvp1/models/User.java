package softjam.test.mvp1.models;

import androidx.annotation.NonNull;

public class User {
    private String email = "";
    private String name = "";

    public User(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return getName() + " " + getEmail();
    }
}
