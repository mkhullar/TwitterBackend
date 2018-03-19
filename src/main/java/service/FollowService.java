package service;

import models.FollowUnfollow;

public interface FollowService {
    FollowUnfollow follow(int id, int follow_id, String handle);
}
