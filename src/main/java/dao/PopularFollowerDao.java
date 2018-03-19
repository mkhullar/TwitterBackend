package dao;

import models.People;

import java.util.List;

public interface PopularFollowerDao {
    List<People> getPopularFollowerList();
    Integer getPopularFollowerConnections();
}
