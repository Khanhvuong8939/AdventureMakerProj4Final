/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Stations", catalog = "AdventureMaker", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stations.findAll", query = "SELECT s FROM Stations s"),
    @NamedQuery(name = "Stations.findByStationID", query = "SELECT s FROM Stations s WHERE s.stationID = :stationID"),
    @NamedQuery(name = "Stations.findByLocationStation", query = "SELECT s FROM Stations s WHERE s.locationStation = :locationStation"),
    @NamedQuery(name = "Stations.findByGameID", query = "SELECT t FROM Stations t WHERE t.gameID = ?1"),
    @NamedQuery(name = "Stations.findByKeyQuestion", query = "SELECT s FROM Stations s WHERE s.keyQuestion = :keyQuestion")})
public class Stations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "stationID", nullable = false, length = 10)
    private String stationID;
    @Size(max = 100)
    @Column(name = "locationStation", length = 100)
    private String locationStation;
    @Size(max = 500)
    @Column(name = "keyQuestion", length = 500)
    private String keyQuestion;
    @JoinColumn(name = "accID", referencedColumnName = "accID")
    @ManyToOne
    private Accounts accID;
    @JoinColumn(name = "gameID", referencedColumnName = "gameID")
    @ManyToOne
    private Games gameID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stations")
    private Collection<TeamTrackings> teamTrackingsCollection;

    public Stations() {
    }

    public Stations(String stationID) {
        this.stationID = stationID;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getLocationStation() {
        return locationStation;
    }

    public void setLocationStation(String locationStation) {
        this.locationStation = locationStation;
    }

    public String getKeyQuestion() {
        return keyQuestion;
    }

    public void setKeyQuestion(String keyQuestion) {
        this.keyQuestion = keyQuestion;
    }

    public Accounts getAccID() {
        return accID;
    }

    public void setAccID(Accounts accID) {
        this.accID = accID;
    }

    public Games getGameID() {
        return gameID;
    }

    public void setGameID(Games gameID) {
        this.gameID = gameID;
    }

    @XmlTransient
    public Collection<TeamTrackings> getTeamTrackingsCollection() {
        return teamTrackingsCollection;
    }

    public void setTeamTrackingsCollection(Collection<TeamTrackings> teamTrackingsCollection) {
        this.teamTrackingsCollection = teamTrackingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stationID != null ? stationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stations)) {
            return false;
        }
        Stations other = (Stations) object;
        if ((this.stationID == null && other.stationID != null) || (this.stationID != null && !this.stationID.equals(other.stationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Stations[ stationID=" + stationID + " ]";
    }

}
