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
import javax.persistence.ManyToMany;
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
@Table(name = "Teams", catalog = "AdventureMaker", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teams.findAll", query = "SELECT t FROM Teams t"),
    @NamedQuery(name = "Teams.findByTeamID", query = "SELECT t FROM Teams t WHERE t.teamID = :teamID"),
    @NamedQuery(name = "Teams.findByTeamName", query = "SELECT t FROM Teams t WHERE t.teamName = :teamName"),
    @NamedQuery(name = "Teams.findByGameID", query = "SELECT t FROM Teams t WHERE t.gameID = ?1"),
    @NamedQuery(name = "Teams.findByWin", query = "SELECT t FROM Teams t WHERE t.win = :win")})
public class Teams implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "teamID", nullable = false, length = 10)
    private String teamID;
    @Size(max = 50)
    @Column(name = "teamName", length = 50)
    private String teamName;
    @Column(name = "win")
    private Boolean win;
    @ManyToMany(mappedBy = "teamsCollection")
    private Collection<Accounts> accountsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teams")
    private Collection<TeamTrackings> teamTrackingsCollection;
    @JoinColumn(name = "gameID", referencedColumnName = "gameID")
    @ManyToOne
    private Games gameID;

    public Teams() {
    }

    public Teams(String teamID) {
        this.teamID = teamID;
    }

    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @XmlTransient
    public Collection<TeamTrackings> getTeamTrackingsCollection() {
        return teamTrackingsCollection;
    }

    public void setTeamTrackingsCollection(Collection<TeamTrackings> teamTrackingsCollection) {
        this.teamTrackingsCollection = teamTrackingsCollection;
    }

    public Games getGameID() {
        return gameID;
    }

    public void setGameID(Games gameID) {
        this.gameID = gameID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teamID != null ? teamID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teams)) {
            return false;
        }
        Teams other = (Teams) object;
        if ((this.teamID == null && other.teamID != null) || (this.teamID != null && !this.teamID.equals(other.teamID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Teams[ teamID=" + teamID + " ]";
    }

}
