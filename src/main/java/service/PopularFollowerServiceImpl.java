package service;

import dao.PopularFollowerDao;
import models.Connections;
import models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopularFollowerServiceImpl implements PopularFollowerService {

    @Autowired
    private PopularFollowerDao popularFollowerDao;

    /**
     * Get a list of connected users from PopularFollowerDao
     * @return Type: List of type People
     */
    @Override
    public List<People> getPopularFollowerList() {
        return popularFollowerDao.getPopularFollowerList();
    }
    /**
     * Get the ID of the most popular followers from PopularFollowerDao
     * @return Type: Integer
     */
    @Override
    public Integer getPopularFollowerConnections() {
        return popularFollowerDao.getPopularFollowerConnections();
    }
}
