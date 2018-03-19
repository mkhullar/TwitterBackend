package service;

import dao.UnfollowDao;
import models.FollowUnfollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnfollowServiceImpl implements UnfollowService {

    @Autowired
    private UnfollowDao unfollowDao;

    /**
     * Call unfollow from UnfollowDao
     * @param  id        Type: int
     * @param  follow_id Type: int
     * @param  handle    Type: String
     * @return           Type: FollowUnfollow
     */
    @Override
    public FollowUnfollow unfollow(int id, int follow_id, String handle) {
        return unfollowDao.unfollow(id, follow_id, handle);
    }
}
