package controller;


import models.Connections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import service.ConnectionsService;
import service.PeopleService;


@RestController
public class ConnectionsController {

    @Autowired
    private ConnectionsService connectionsService;

    @Autowired
    private PeopleService peopleService;
    /**
     * Get connections of the Authenticated user
     * @param "/connections"
     * @param RequestMethod.GET
     */
    @RequestMapping(value = "/connections", method = RequestMethod.GET)
    public @ResponseBody
    Connections getconnections(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return connectionsService.getConnections(peopleService.getUserId(user.getUsername()));
    }
}
