package service;


import models.People;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PopularFollowerService {
    List<People> getPopularFollowerList();
    Integer getPopularFollowerConnections();
}
