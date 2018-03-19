package models;

public class Followers {

    private int person_id;
    private int follower_person_id;

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getFollower_person_id() {
        return follower_person_id;
    }

    public void setFollower_person_id(int follower_person_id) {
        this.follower_person_id = follower_person_id;
    }

    public Followers(){}

    public Followers(int person_id, int follower_person_id) {
        this.person_id = person_id;
        this.follower_person_id = follower_person_id;
    }

    @Override
    public String toString() {
        return "Followers{" +
                "person_id=" + person_id +
                ", follower_person_id=" + follower_person_id +
                '}';
    }
}
