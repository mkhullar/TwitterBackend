package service;


import dao.FollowDao;
import models.FollowUnfollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService{

    @Autowired
    private FollowDao followDao;

    /**
     * Call follow from FollowDao
     * @param  id        Type: int
     * @param  follow_id Type: int
     * @param  handle    Type: String
     * @return           Type: FollowUnfollow
     */
    @Override
    public FollowUnfollow follow(int id, int follow_id, String handle) {
        return followDao.follow(id, follow_id,  handle);
    }
}
