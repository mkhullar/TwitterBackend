package dao;

import models.Followers;
import models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PopularFollowerDaoImpl implements PopularFollowerDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Get a list of connected users from the most followed user.
     * @return Type: List of type People
     */
    @Override
    public List<People> getPopularFollowerList() {
        String popular_follower = "Select p.id, p.handle, p.name from people as p where p.id in " +
                "((SELECT f.PERSON_ID from FOLLOWERS as f inner join (SELECT FOLLOWER_PERSON_ID, count(*) as follow_cnt " +
                "FROM FOLLOWERS  group by FOLLOWER_PERSON_ID Order by follow_cnt Desc Limit 1) as max_follow on " +
                "f.FOLLOWER_PERSON_ID = max_follow.FOLLOWER_PERSON_ID) Union (SELECT fl.FOLLOWER_PERSON_ID from " +
                "FOLLOWERS as fl inner join (SELECT FOLLOWER_PERSON_ID, count(*) as follow_cnt  FROM FOLLOWERS " +
                "group by FOLLOWER_PERSON_ID Order by follow_cnt Desc Limit 1) as max_f on " +
                "fl.PERSON_ID = max_f.FOLLOWER_PERSON_ID)) order by p.id";

        return jdbcTemplate.query(popular_follower, (rs, rowNum) -> {
            People people = new People();
            people.setId(Integer.parseInt(rs.getString("id")));
            people.setHandle(rs.getString("handle"));
            people.setName(rs.getString("name"));
            return people;
        });
    }

    @Override
    public Integer getPopularFollowerConnections() {
        String popular_person = "SELECT FOLLOWER_PERSON_ID, count(*) as follow_cnt " +
                "FROM FOLLOWERS  group by FOLLOWER_PERSON_ID Order by follow_cnt Desc Limit 1";
        List<Followers> follower = jdbcTemplate.query(popular_person, (rs, rowNum) -> {
            Followers followers = new Followers();
            followers.setFollower_person_id(Integer.parseInt(rs.getString("FOLLOWER_PERSON_ID")));
            return followers;
        });

        if(follower.size() > 0){
            return follower.get(0).getFollower_person_id();
        }
        return -1;
    }

}
