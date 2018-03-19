package controller;


import models.FollowUnfollow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import service.PeopleService;
import service.UnfollowService;

@RestController
public class UnfollowController {

    @Autowired
    private UnfollowService unfollowService;

    @Autowired
    private PeopleService peopleService;
    /**
     * Unfollow a user with specified handle and checks if handle is valid.
     * @param "/unfollow"
     * @param RequestMethod.DELETE
     */
    @RequestMapping(value = "/unfollow", method = RequestMethod.DELETE)
    public @ResponseBody
    FollowUnfollow unfollow(@RequestParam("handle") String handle){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (peopleService.getUserId(handle) !=-1)
            return unfollowService.unfollow(peopleService.getUserId(user.getUsername()), peopleService.getUserId(handle), handle);
        else
            return new FollowUnfollow("Failure", handle, "Invalid Handle");
    }
}
