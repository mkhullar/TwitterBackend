package service;

import models.FollowUnfollow;

public interface UnfollowService {
    FollowUnfollow unfollow(int id, int follow_id, String handle);
}
