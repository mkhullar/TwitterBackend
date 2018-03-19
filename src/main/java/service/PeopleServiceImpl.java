package service;


import dao.PeopleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl implements PeopleService{
    @Autowired
    private PeopleDao peopleDao;

    /**
     * Get User Id from PeopleDao
     * @param  handle Type: String
     * @return        Type: Integer
     */
    @Override
    public Integer getUserId(String handle){
        return peopleDao.getUserId(handle);
    }
}
