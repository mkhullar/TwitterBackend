package dao;

import models.Connections;
import models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConnectionsDaoImpl implements ConnectionsDao{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Get connections for the authorized user with return values for both the
     * people you follow and people who follow you using user id.
     * @param  id Type: int
     * @return    Type: Connections
     */
    @Override
    public Connections getConnections(int id){
        String following = "Select * from people as P where P.id in (Select F.FOLLOWER_PERSON_ID from FOLLOWERS " +
                "as F where F.PERSON_ID =" +id +")";
        String followers = "Select * from people as P where P.id in (Select F.PERSON_ID from FOLLOWERS " +
                "as F where F.FOLLOWER_PERSON_ID =" +id +")";
        return new Connections(executeConnections(following), executeConnections(followers));
    }

    /**
     * Execute the query using the String query to return the List of People
     * @param  query Type: String (SQL query)
     * @return       Type: List of People
     */
    private List<People> executeConnections(String query){
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            People people = new People();
            people.setId(Integer.parseInt(rs.getString("id")));
            people.setHandle(rs.getString("handle"));
            people.setName(rs.getString("name"));
            return people;
        });
    }
}
