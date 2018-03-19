package models;

public class FollowUnfollow {
    private String status= null;
    private String handle = null;
    private String error = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public FollowUnfollow(){}

    public FollowUnfollow(String status, String handle, String error) {
        this.status = status;
        this.handle = handle;
        this.error = error;
    }



}
