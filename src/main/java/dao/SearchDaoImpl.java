package dao;

import models.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SearchDaoImpl implements SearchDao{

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Get the tweets of the user and the users followed by the user
     * by the keyword "value"
     * @param  value Type: String
     * @param  id    Type: int
     * @return       Type: List of Messages
     */
    @Override
    public List<Messages> getSearchValue(String value, int id){
        String query = "SELECT * FROM messages INNER JOIN people on messages.person_id = people.id " +
                "where (people.id in (Select F.FOLLOWER_PERSON_ID from  FOLLOWERS as F where F.PERSON_ID =" +id+
                ") or people.id ="+id+") and lower(messages.content) LIKE '%" + value.toLowerCase() + "%' ";

        return executeSearch(query);

    }
    /**
     * Get the tweets of the user and the users followed by the user
     * @param  id    Type: int
     * @return       Type: List of Messages
     */
    @Override
    public List<Messages> getSearch(int id) {
        String query = "SELECT * FROM messages INNER JOIN people on messages.person_id = people.id " +
                "where people.id in (Select F.FOLLOWER_PERSON_ID from  FOLLOWERS as F where F.PERSON_ID =" +id+
                ")or people.id ="+id;
            return executeSearch(query);
        }

        /**
         * Execute the query using String query
         * @param  query Type: String
         * @return       Type: List< of Messages
         */
        private List<Messages> executeSearch(String query){
            return jdbcTemplate.query(query, (rs, rowNum) -> {
                Messages message = new Messages();
                message.setPerson_id(Integer.parseInt(rs.getString("person_id")));
                message.setContent(rs.getString("content"));
                message.setHandle(rs.getString("handle"));
                return message;
            });

        }

}
