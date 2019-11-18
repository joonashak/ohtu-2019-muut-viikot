
package ohtu;

public class Player {
    private String name, team, nationality;
    private Integer goals, assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getAssists() {
        return assists;
    }

    public Integer getPoints() {
        return goals + assists;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return name + " " + team + " " + goals + " " + assists + " " + getPoints();
    }     
}
