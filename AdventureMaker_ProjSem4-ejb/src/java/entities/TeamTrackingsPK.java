/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Embeddable
public class TeamTrackingsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "teamID", nullable = false, length = 10)
    private String teamID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "stationID", nullable = false, length = 10)
    private String stationID;

    public TeamTrackingsPK() {
    }

    public TeamTrackingsPK(String teamID, String stationID) {
        this.teamID = teamID;
        this.stationID = stationID;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamID != null ? teamID.hashCode() : 0);
        hash += (stationID != null ? stationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeamTrackingsPK)) {
            return false;
        }
        TeamTrackingsPK other = (TeamTrackingsPK) object;
        if ((this.teamID == null && other.teamID != null) || (this.teamID != null && !this.teamID.equals(other.teamID))) {
            return false;
        }
        if ((this.stationID == null && other.stationID != null) || (this.stationID != null && !this.stationID.equals(other.stationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.TeamTrackingsPK[ teamID=" + teamID + ", stationID=" + stationID + " ]";
    }

}
