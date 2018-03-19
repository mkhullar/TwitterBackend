package dao;

import models.Messages;

import java.util.List;

public interface SearchDao {
     List<Messages> getSearchValue(String value, int id);
     List<Messages> getSearch(int id);
}
