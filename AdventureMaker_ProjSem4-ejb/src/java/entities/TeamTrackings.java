/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "TeamTrackings", catalog = "AdventureMaker", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeamTrackings.findAll", query = "SELECT t FROM TeamTrackings t"),
    @NamedQuery(name = "TeamTrackings.findByTeamID", query = "SELECT t FROM TeamTrackings t WHERE t.teamTrackingsPK.teamID = :teamID"),
    @NamedQuery(name = "TeamTrackings.findByStationID", query = "SELECT t FROM TeamTrackings t WHERE t.teamTrackingsPK.stationID = :stationID"),
    @NamedQuery(name = "TeamTrackings.findByStartTime", query = "SELECT t FROM TeamTrackings t WHERE t.startTime = :startTime"),
    @NamedQuery(name = "TeamTrackings.findByEndTime", query = "SELECT t FROM TeamTrackings t WHERE t.endTime = :endTime"),
    @NamedQuery(name = "TeamTrackings.findByScore", query = "SELECT t FROM TeamTrackings t WHERE t.score = :score")})
public class TeamTrackings implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TeamTrackingsPK teamTrackingsPK;
    @Column(name = "startTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "endTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "score")
    private Integer score;
    @JoinColumn(name = "stationID", referencedColumnName = "stationID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Stations stations;
    @JoinColumn(name = "teamID", referencedColumnName = "teamID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teams teams;

    public TeamTrackings() {
    }

    public TeamTrackings(TeamTrackingsPK teamTrackingsPK) {
        this.teamTrackingsPK = teamTrackingsPK;
    }

    public TeamTrackings(String teamID, String stationID) {
        this.teamTrackingsPK = new TeamTrackingsPK(teamID, stationID);
    }

    public TeamTrackingsPK getTeamTrackingsPK() {
        return teamTrackingsPK;
    }

    public void setTeamTrackingsPK(TeamTrackingsPK teamTrackingsPK) {
        this.teamTrackingsPK = teamTrackingsPK;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Stations getStations() {
        return stations;
    }

    public void setStations(Stations stations) {
        this.stations = stations;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamTrackingsPK != null ? teamTrackingsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamTrackings)) {
            return false;
        }
        TeamTrackings other = (TeamTrackings) object;
        if ((this.teamTrackingsPK == null && other.teamTrackingsPK != null) || (this.teamTrackingsPK != null && !this.teamTrackingsPK.equals(other.teamTrackingsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TeamTrackings[ teamTrackingsPK=" + teamTrackingsPK + " ]";
    }

}
