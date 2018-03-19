package dao;

import models.FollowUnfollow;
import models.Followers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UnfollowDaoImpl implements UnfollowDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     *  Check if the user follows the handle then unfollow the handle.
     *  Adding @Transactional since it is a transactional query.
     * @param  id        Type: int
     * @param  follow_id Type: int
     * @param  handle    Type: String
     * @return           Type: FollowUnfollow
     */
    @Override
    @Transactional
    public FollowUnfollow unfollow(int id, int follow_id, String handle) {
        if(alreadyFollowing(id, follow_id)){
            String unfollow = "Delete from followers as f where f.person_id = :id and f.follower_person_id = :follow_id";
            Map<String, Integer> namedParameters = new HashMap<>();
            namedParameters.put("id", id);
            namedParameters.put("follow_id", follow_id);
            jdbcTemplate.update(unfollow, namedParameters);
            return new FollowUnfollow("Success", handle, "");
        }
        return new FollowUnfollow("Failure", handle, "You don't follow this handle");
    }

    /**
     * Check if the user is following the specified handle.
     * @param  id        Type: int
     * @param  follow_id Type: int
     * @return           Type: Boolean
     */
    private Boolean alreadyFollowing(int id, int follow_id) {

        String check_follow = "Select * from FOLLOWERS as F where F.PERSON_ID = " +id +
                " and F.FOLLOWER_PERSON_ID = " + follow_id;
        List<Followers> follower  = jdbcTemplate.query(check_follow, (ResultSet rs, int rowNum) -> {
            Followers followers = new Followers();
            followers.setPerson_id(Integer.parseInt(rs.getString("person_id")));
            followers.setFollower_person_id(Integer.parseInt(rs.getString("follower_person_id")));
            return followers;
        });
        return follower.size() > 0;
    }
}
