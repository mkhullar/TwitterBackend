package service;

import dao.SearchDao;
import models.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchServiceImpl  implements SearchService{
    @Autowired
    private SearchDao searchDao;

    /**
     * Get the tweets by the keyword from SearchDao
     * @param  value Type: String
     * @param  id    Type: int
     * @return       Type: List of Messages
     */
    @Override
    public List<Messages> getSearchValue(String value, int id){
        return searchDao.getSearchValue(value, id);
    }

    /**
     * Get all the tweets from SearchDao
     * @param  id Type: int
     * @return    Type: List of Messages
     */
    @Override
    public List<Messages> getSearch(int id) {
        return searchDao.getSearch(id);
    }
}
