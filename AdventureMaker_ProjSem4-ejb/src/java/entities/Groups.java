/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Groups", catalog = "AdventureMaker", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findByGroupID", query = "SELECT g FROM Groups g WHERE g.groupID = :groupID"),
    @NamedQuery(name = "Groups.findByGroupName", query = "SELECT g FROM Groups g WHERE g.groupName = :groupName"),
    @NamedQuery(name = "Groups.findByDescription", query = "SELECT g FROM Groups g WHERE g.description = :description")})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "groupID", nullable = false, length = 10)
    private String groupID;
    @Size(max = 30)
    @Column(name = "groupName", length = 30)
    private String groupName;
    @Size(max = 200)
    @Column(name = "description", length = 200)
    private String description;
    @OneToMany(mappedBy = "groupID")
    private Collection<AccountDetails> accountDetailsCollection;

    public Groups() {
    }

    public Groups(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<AccountDetails> getAccountDetailsCollection() {
        return accountDetailsCollection;
    }

    public void setAccountDetailsCollection(Collection<AccountDetails> accountDetailsCollection) {
        this.accountDetailsCollection = accountDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupID != null ? groupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.groupID == null && other.groupID != null) || (this.groupID != null && !this.groupID.equals(other.groupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Groups[ groupID=" + groupID + " ]";
    }

}
