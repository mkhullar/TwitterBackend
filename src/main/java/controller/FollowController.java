package controller;

import models.FollowUnfollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import service.FollowService;
import service.PeopleService;

@RestController
public class FollowController {
    @Autowired
    private FollowService followService;

    @Autowired
    private PeopleService peopleService;
    /**
     * Follow a user with specified handle and checks if handle is valid.
     * @param "/follow"
     * @param RequestMethod.POST
     */
    @RequestMapping(value = "/follow", method = RequestMethod.POST)
    public @ResponseBody
    FollowUnfollow follow(@RequestParam("handle") String handle){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (peopleService.getUserId(handle) !=-1)
            return followService.follow(peopleService.getUserId(user.getUsername()), peopleService.getUserId(handle), handle);
        else
            return new FollowUnfollow("Failure", handle, "Invalid Handle");
    }
}
