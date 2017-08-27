/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "GameDetails", catalog = "AdventureMaker", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameDetails.findAll", query = "SELECT g FROM GameDetails g"),
    @NamedQuery(name = "GameDetails.findByGameID", query = "SELECT g FROM GameDetails g WHERE g.gameID = :gameID"),
    @NamedQuery(name = "GameDetails.findByStartTime", query = "SELECT g FROM GameDetails g WHERE g.startTime = :startTime"),
    @NamedQuery(name = "GameDetails.findByEndTime", query = "SELECT g FROM GameDetails g WHERE g.endTime = :endTime"),
    @NamedQuery(name = "GameDetails.findByLocationStart", query = "SELECT g FROM GameDetails g WHERE g.locationStart = :locationStart"),
    @NamedQuery(name = "GameDetails.findByLocationEnd", query = "SELECT g FROM GameDetails g WHERE g.locationEnd = :locationEnd"),
    @NamedQuery(name = "GameDetails.findByAmtP", query = "SELECT g FROM GameDetails g WHERE g.amtP = :amtP"),
    @NamedQuery(name = "GameDetails.findByAmtS", query = "SELECT g FROM GameDetails g WHERE g.amtS = :amtS")})
public class GameDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gameID", nullable = false, length = 10)
    private String gameID;
    @Column(name = "startTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "endTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 100)
    @Column(name = "locationStart", length = 100)
    private String locationStart;
    @Size(max = 100)
    @Column(name = "locationEnd", length = 100)
    private String locationEnd;
    @Column(name = "amtP")
    private Integer amtP;
    @Column(name = "amtS")
    private Integer amtS;
    @JoinColumn(name = "gameID", referencedColumnName = "gameID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Games games;

    public GameDetails() {
    }

    public GameDetails(String gameID) {
        this.gameID = gameID;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
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

    public String getLocationStart() {
        return locationStart;
    }

    public void setLocationStart(String locationStart) {
        this.locationStart = locationStart;
    }

    public String getLocationEnd() {
        return locationEnd;
    }

    public void setLocationEnd(String locationEnd) {
        this.locationEnd = locationEnd;
    }

    public Integer getAmtP() {
        return amtP;
    }

    public void setAmtP(Integer amtP) {
        this.amtP = amtP;
    }

    public Integer getAmtS() {
        return amtS;
    }

    public void setAmtS(Integer amtS) {
        this.amtS = amtS;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gameID != null ? gameID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameDetails)) {
            return false;
        }
        GameDetails other = (GameDetails) object;
        if ((this.gameID == null && other.gameID != null) || (this.gameID != null && !this.gameID.equals(other.gameID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GameDetails[ gameID=" + gameID + " ]";
    }

}
