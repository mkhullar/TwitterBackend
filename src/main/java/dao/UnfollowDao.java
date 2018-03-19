package dao;

import models.FollowUnfollow;

public interface UnfollowDao {
    FollowUnfollow unfollow(int id, int follow_id,  String handle);
}
