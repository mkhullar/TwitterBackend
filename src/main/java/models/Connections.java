package models;

import java.util.List;

public class Connections {
    private List<People> following;
    private List<People> followers;

    public List<People> getFollowing() {
        return following;
    }

    public void setFollowing(List<People> following) {
        this.following = following;
    }

    public List<People> getFollowers() {
        return followers;
    }

    public void setFollowers(List<People> followers) {
        this.followers = followers;
    }

    public Connections(){}

    public Connections(List<People> following, List<People> followers) {
        this.following = following;
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "Connections{" +
                "following=" + following +
                ", followers=" + followers +
                '}';
    }
}
