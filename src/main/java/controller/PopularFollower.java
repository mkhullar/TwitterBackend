package controller;

import models.Connections;
import models.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import service.ConnectionsService;
import service.PeopleService;
import service.PopularFollowerService;

import java.util.List;

@RestController
public class PopularFollower {

    @Autowired
    private PopularFollowerService popularFollowerService;

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private ConnectionsService connectionsService;
    /**
     * Gets the List of connections of the Most Popular follower.
     * Most popular follower is the person who has maximum number of follower.
     * @param "/popularFollower"
     * @param RequestMethod.GET
     */
    @RequestMapping(value = "/popularFollower", method = RequestMethod.GET)
    public @ResponseBody
    List<People> getPopularFollowerList(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (peopleService.getUserId(user.getUsername()) != -1)
            return popularFollowerService.getPopularFollowerList();
        else
            return null;
    }

    /**
     * Gets the List of followers and list of the people being followed by the
     * Most Popular follower. Most popular follower is the person who has
     * maximum number of follower.
     * @param "/popularFollowerConnections"
     * @param RequestMethod.GET
     */
    @RequestMapping(value = "/popularFollowerConnections", method = RequestMethod.GET)
    public @ResponseBody
    Connections getPopularFollowerConnections(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (peopleService.getUserId(user.getUsername()) != -1)
            return connectionsService.getConnections(popularFollowerService.getPopularFollowerConnections());
        else
            return null;
    }

}
