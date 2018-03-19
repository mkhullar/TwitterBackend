package service;

import dao.ConnectionsDao;
import models.Connections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConnectionsServiceImpl implements ConnectionsService{
    @Autowired
    private ConnectionsDao connectionsDao;

    /**
     * Get connections from ConnectionsDao
     * @param  id Type: int
     * @return    Type: Connections
     */
    @Override
    public Connections getConnections(int id){
        return connectionsDao.getConnections(id);
    }

}
