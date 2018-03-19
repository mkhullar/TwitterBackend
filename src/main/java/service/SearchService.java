package service;

import models.Messages;

import java.util.List;

public interface SearchService {
     List<Messages> getSearchValue(String value, int id);
     List<Messages> getSearch(int id);
}
