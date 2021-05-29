package com.pradeep.fireapp;

public class Profile {
    private String name;
    private String email;
    private String profilePic;
    private boolean permission;
    public Profile(){

    }

    public Profile(String name, String email, String profilePic, boolean permission) {
        this.name = name;
        this.email = email;
        this.profilePic = profilePic;
        this.permission = permission;

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public boolean getPermission() {
        return permission;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }
}
