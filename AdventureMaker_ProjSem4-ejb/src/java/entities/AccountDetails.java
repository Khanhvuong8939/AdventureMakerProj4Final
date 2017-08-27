/*
 *  ================================= Java ================================
 *                         Welcome to RaeJas - KODG
 *  ============================== I Love Java ============================
 */


package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "AccountDetails", catalog = "AdventureMaker", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountDetails.findAll", query = "SELECT a FROM AccountDetails a"),
    @NamedQuery(name = "AccountDetails.findByAccID", query = "SELECT a FROM AccountDetails a WHERE a.accID = :accID"),
    @NamedQuery(name = "AccountDetails.findByAccFirstN", query = "SELECT a FROM AccountDetails a WHERE a.accFirstN = :accFirstN"),
    @NamedQuery(name = "AccountDetails.findByAccLastN", query = "SELECT a FROM AccountDetails a WHERE a.accLastN = :accLastN"),
    @NamedQuery(name = "AccountDetails.findByGender", query = "SELECT a FROM AccountDetails a WHERE a.gender = :gender"),
    @NamedQuery(name = "AccountDetails.findByDoB", query = "SELECT a FROM AccountDetails a WHERE a.doB = :doB"),
    @NamedQuery(name = "AccountDetails.findByEmail", query = "SELECT a FROM AccountDetails a WHERE a.email = :email"),
    @NamedQuery(name = "AccountDetails.findByPhone", query = "SELECT a FROM AccountDetails a WHERE a.phone = :phone"),
    @NamedQuery(name = "AccountDetails.findByAddress", query = "SELECT a FROM AccountDetails a WHERE a.address = :address"),
    @NamedQuery(name = "AccountDetails.findByCompany", query = "SELECT a FROM AccountDetails a WHERE a.company = :company")})
public class AccountDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "accID", nullable = false, length = 30)
    private String accID;
    @Size(max = 30)
    @Column(name = "accFirstN", length = 30)
    private String accFirstN;
    @Size(max = 30)
    @Column(name = "accLastN", length = 30)
    private String accLastN;
    @Column(name = "gender")
    private Boolean gender;
    @Size(max = 30)
    @Column(name = "doB", length = 30)
    private String doB;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone", length = 20)
    private String phone;
    @Size(max = 100)
    @Column(name = "address", length = 100)
    private String address;
    @Size(max = 50)
    @Column(name = "company", length = 50)
    private String company;
    @JoinColumn(name = "accID", referencedColumnName = "accID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false,cascade = CascadeType.ALL)
    private Accounts accounts;
    @JoinColumn(name = "groupID", referencedColumnName = "groupID")
    @ManyToOne
    private Groups groupID;

    public AccountDetails() {
    }

    public AccountDetails(String accID) {
        this.accID = accID;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public String getAccFirstN() {
        return accFirstN;
    }

    public void setAccFirstN(String accFirstN) {
        this.accFirstN = accFirstN;
    }

    public String getAccLastN() {
        return accLastN;
    }

    public void setAccLastN(String accLastN) {
        this.accLastN = accLastN;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public Groups getGroupID() {
        return groupID;
    }

    public void setGroupID(Groups groupID) {
        this.groupID = groupID;
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
        if (!(object instanceof AccountDetails)) {
            return false;
        }
        AccountDetails other = (AccountDetails) object;
        if ((this.accID == null && other.accID != null) || (this.accID != null && !this.accID.equals(other.accID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AccountDetails[ accID=" + accID + " ]";
    }

}
