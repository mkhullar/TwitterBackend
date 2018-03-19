# Twitter Backend!

By: [Mayank Khular](github.com/mkhullar)
[mkhullar.me](mkhullar.me)

## Installation instructions

 - Unzip the folder challenge_mkhullar.zip
 - Import Project into IntelliJ as a gradle project.
 - Build gradle
 - Run the application

## Technologies
 - [HTTP Basic authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)
 - [Spring Boot](http://projects.spring.io/spring-boot/)
 - [H2 in-memory SQL database](http://www.h2database.com/)

## Functionalities

 - An endpoint to read the message list for the current user (as
   identified by their HTTP Basic authentication credentials). Include
   messages they have sent and messages sent by users they follow.
   Support a “search=” parameter that can be used to further filter
   messages based on keyword. **["/" and "/search={value}"]**
 - Endpoints to get the list of people the user is following as well as the  followers of the user. **["/connections"]**
 - An endpoint to start following another user.**["/follow"]**
 - An endpoint to unfollow another user. **["/unfollow"]**
 - An endpoint that returns a list of _all_ users, paired with their most "popular" follower. The more followers someone has, the more "popular" they are.
	 - Gets the List of connections of the Most Popular follower. Most popular follower is the person who has maximum number of follower. **["/popularFollower"]**
	 - Gets the List of followers and list of the people being followed by the Most Popular follower. Most popular follower is the person who has maximum number of follower. **["/popularFollowerConnections"]**
