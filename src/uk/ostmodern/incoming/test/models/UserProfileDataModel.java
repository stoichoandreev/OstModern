package uk.ostmodern.incoming.test.models;

/**
 * Created by sniper on 5/8/15.
 */
public class UserProfileDataModel {
    private String userName;
    private int userLevel;
    private int userSmallImage;
    private int userBigImage;
    private int userFriends;
    private int userChallenges;
    private int userCompetitions;
    private int userGroups;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserBigImage() {
        return userBigImage;
    }

    public void setUserBigImage(int userBigImage) {
        this.userBigImage = userBigImage;
    }

    public int getUserChallenges() {
        return userChallenges;
    }

    public void setUserChallenges(int userChallenges) {
        this.userChallenges = userChallenges;
    }

    public int getUserCompetitions() {
        return userCompetitions;
    }

    public void setUserCompetitions(int userCompetitions) {
        this.userCompetitions = userCompetitions;
    }

    public int getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(int userFriends) {
        this.userFriends = userFriends;
    }

    public int getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(int userGroups) {
        this.userGroups = userGroups;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserSmallImage() {
        return userSmallImage;
    }

    public void setUserSmallImage(int userSmallImage) {
        this.userSmallImage = userSmallImage;
    }
}
