package dao;

import models.FollowUnfollow;

public interface FollowDao {
    FollowUnfollow follow(int id, int follow_id, String handle);
}
