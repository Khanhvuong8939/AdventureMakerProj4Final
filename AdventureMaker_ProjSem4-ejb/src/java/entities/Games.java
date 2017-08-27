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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Games", catalog = "AdventureMaker", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Games.findAll", query = "SELECT g FROM Games g"),
    @NamedQuery(name = "Games.findByGameID", query = "SELECT g FROM Games g WHERE g.gameID = :gameID"),
    @NamedQuery(name = "Games.findByGameName", query = "SELECT g FROM Games g WHERE g.gameName = :gameName"),
    @NamedQuery(name = "Games.findByStatus", query = "SELECT g FROM Games g WHERE g.status = :status"),
    @NamedQuery(name = "Games.findByCustomWin", query = "SELECT g FROM Games g WHERE g.customWin = :customWin"),
    @NamedQuery(name = "Games.findByDescription", query = "SELECT g FROM Games g WHERE g.description = :description"),
//    @NamedQuery(name = "Games.findGameByPlayer", query = "SELECT g FROM Games g WHERE g.teamsCollection.accountsCollection.accID = ?1"),
//    @NamedQuery(name= "Games.findByTeamID", query = "SELECT g FROM Games g WHERE g.teamsCollection.teamID = ?1"),
    @NamedQuery(name = "Games.findByAccID", query = "SELECT g FROM Games g WHERE g.accID.accID = :accID")
})
public class Games implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "gameID", nullable = false, length = 10)
    private String gameID;
    @Size(max = 50)
    @Column(name = "gameName", length = 50)
    private String gameName;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "customWin")
    private Boolean customWin;
    @Size(max = 500)
    @Column(name = "description", length = 500)
    private String description;
    @OneToMany(mappedBy = "gameID")
    private Collection<Stations> stationsCollection;
    @JoinColumn(name = "accID", referencedColumnName = "accID")
    @ManyToOne
    private Accounts accID;
    @OneToMany(mappedBy = "gameID")
    private Collection<Teams> teamsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "games")
    private GameDetails gameDetails;

    public Games() {
    }

    public Games(String gameID) {
        this.gameID = gameID;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getCustomWin() {
        return customWin;
    }

    public void setCustomWin(Boolean customWin) {
        this.customWin = customWin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Stations> getStationsCollection() {
        return stationsCollection;
    }

    public void setStationsCollection(Collection<Stations> stationsCollection) {
        this.stationsCollection = stationsCollection;
    }

    public Accounts getAccID() {
        return accID;
    }

    public void setAccID(Accounts accID) {
        this.accID = accID;
    }

    @XmlTransient
    public Collection<Teams> getTeamsCollection() {
        return teamsCollection;
    }

    public void setTeamsCollection(Collection<Teams> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    public GameDetails getGameDetails() {
        return gameDetails;
    }

    public void setGameDetails(GameDetails gameDetails) {
        this.gameDetails = gameDetails;
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
        if (!(object instanceof Games)) {
            return false;
        }
        Games other = (Games) object;
        if ((this.gameID == null && other.gameID != null) || (this.gameID != null && !this.gameID.equals(other.gameID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Games[ gameID=" + gameID + " ]";
    }

}
