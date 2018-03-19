package dao;

import models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleDaoImpl implements PeopleDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Get User Id from the handle and returns -1 id user does not exist.
     * @param  handle Type: String
     * @return        Type: Integer
     */
    @Override
    public Integer getUserId(String handle){
        String query = "SELECT people.id FROM people where people.handle = :handle";
        List<People> persons  = jdbcTemplate.query(query, new MapSqlParameterSource("handle", handle),
                (rs, rowNum) -> {
            People people = new People();
            people.setId(Integer.parseInt(rs.getString("id")));
            return people;
        });

        if (persons.size() == 1) {
            return persons.get(0).getId();
        }
        return -1;
    }
}
