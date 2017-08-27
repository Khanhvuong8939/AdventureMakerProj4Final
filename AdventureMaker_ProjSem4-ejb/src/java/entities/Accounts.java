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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Accounts", catalog = "AdventureMaker", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a"),
    @NamedQuery(name = "Accounts.findByAccID", query = "SELECT a FROM Accounts a WHERE a.accID = :accID"),
    @NamedQuery(name = "Accounts.findByPassword", query = "SELECT a FROM Accounts a WHERE a.password = :password"),
    @NamedQuery(name = "Accounts.findByRoles", query = "SELECT a FROM Accounts a WHERE a.roles = :roles"),
    @NamedQuery(name = "Accounts.findByGroupID", query = "SELECT a FROM Accounts a WHERE a.accountDetails.groupID.groupID = ?1"),
    @NamedQuery(name = "Accounts.findByStatus", query = "SELECT a FROM Accounts a WHERE a.status = :status")})
public class Accounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "accID", nullable = false, length = 30)
    private String accID;
    @Size(max = 20)
    @Column(name = "password", length = 20)
    private String password;
    @Column(name = "roles")
    private Boolean roles;
    @Column(name = "status")
    private Boolean status;
    @JoinTable(name = "TeamDetails", joinColumns = {
        @JoinColumn(name = "accID", referencedColumnName = "accID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "teamID", referencedColumnName = "teamID", nullable = false)})
    @ManyToMany
    private Collection<Teams> teamsCollection;
    @OneToMany(mappedBy = "accID")
    private Collection<Stations> stationsCollection;
    @OneToMany(mappedBy = "accID")
    private Collection<Games> gamesCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "accounts")
    private AccountDetails accountDetails;

    public Accounts() {
    }

    public Accounts(String accID) {
        this.accID = accID;
    }

    public Accounts(String accID, String password, Boolean roles, Boolean status) {
        this.accID = accID;
        this.password = password;
        this.roles = roles;
        this.status = status;
    }

    public Accounts(String accID, String password, Boolean roles, Boolean status, Collection<Teams> teamsCollection, Collection<Stations> stationsCollection, Collection<Games> gamesCollection, AccountDetails accountDetails) {
        this.accID = accID;
        this.password = password;
        this.roles = roles;
        this.status = status;
        this.teamsCollection = teamsCollection;
        this.stationsCollection = stationsCollection;
        this.gamesCollection = gamesCollection;
        this.accountDetails = accountDetails;
    }
    
    
    
    

    
    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRoles() {
        return roles;
    }

    public void setRoles(Boolean roles) {
        this.roles = roles;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Teams> getTeamsCollection() {
        return teamsCollection;
    }

    public void setTeamsCollection(Collection<Teams> teamsCollection) {
        this.teamsCollection = teamsCollection;
    }

    @XmlTransient
    public Collection<Stations> getStationsCollection() {
        return stationsCollection;
    }

    public void setStationsCollection(Collection<Stations> stationsCollection) {
        this.stationsCollection = stationsCollection;
    }

    @XmlTransient
    public Collection<Games> getGamesCollection() {
        return gamesCollection;
    }

    public void setGamesCollection(Collection<Games> gamesCollection) {
        this.gamesCollection = gamesCollection;
    }

    public AccountDetails getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(AccountDetails accountDetails) {
        this.accountDetails = accountDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accID != null ? accID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accID == null && other.accID != null) || (this.accID != null && !this.accID.equals(other.accID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Accounts[ accID=" + accID + " ]";
    }

}
