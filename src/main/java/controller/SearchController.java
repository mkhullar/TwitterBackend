package controller;

import models.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import service.PeopleService;
import service.SearchService;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    private SearchService searchService;

    @Autowired
    private PeopleService peopleService;
    /**
     * Read the message list for the current user.
     * Includes messages they have sent and messages sent by users they follow
     * with “search=” parameter that can be used to further filter
     * messages based on keyword.
     * @param "/search={value}"
     * @param RequestMethod.GET
     */
    @RequestMapping(value = "/search={value}", method = RequestMethod.GET)
    public @ResponseBody
    List<Messages> getSearchValue(@PathVariable("value") String value){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return searchService.getSearchValue(value, peopleService.getUserId(user.getUsername()));
    }

    /**
     * Read the message list for the current user.
     * Includes messages they have sent and messages sent by users they follow
     * @param "/"
     * @param RequestMethod.GET
     */
    @RequestMapping( value = "/", method = RequestMethod.GET)
    List<Messages> getSearch() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return searchService.getSearch(peopleService.getUserId(user.getUsername()));
    }
}
