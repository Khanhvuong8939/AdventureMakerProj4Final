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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "Feedbacks", catalog = "AdventureMaker", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedbacks.findAll", query = "SELECT f FROM Feedbacks f"),
    @NamedQuery(name = "Feedbacks.findByFeedBackID", query = "SELECT f FROM Feedbacks f WHERE f.feedBackID = :feedBackID"),
    @NamedQuery(name = "Feedbacks.findBySender", query = "SELECT f FROM Feedbacks f WHERE f.sender = :sender"),
    @NamedQuery(name = "Feedbacks.findByReceiver", query = "SELECT f FROM Feedbacks f WHERE f.receiver = :receiver"),
    @NamedQuery(name = "Feedbacks.findBySubject", query = "SELECT f FROM Feedbacks f WHERE f.subject = :subject"),
    @NamedQuery(name = "Feedbacks.findByContent", query = "SELECT f FROM Feedbacks f WHERE f.content = :content"),
    @NamedQuery(name = "Feedbacks.findBySentDate", query = "SELECT f FROM Feedbacks f WHERE f.sentDate = :sentDate"),
    @NamedQuery(name = "Feedbacks.findByFlag", query = "SELECT f FROM Feedbacks f WHERE f.flag = :flag")})
public class Feedbacks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "feedBackID", nullable = false, length = 10)
    private String feedBackID;
    @Size(max = 30)
    @Column(name = "sender", length = 30)
    private String sender;
    @Size(max = 30)
    @Column(name = "receiver", length = 30)
    private String receiver;
    @Size(max = 100)
    @Column(name = "subject", length = 100)
    private String subject;
    @Size(max = 500)
    @Column(name = "content", length = 500)
    private String content;
    @Column(name = "sentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;
    @Column(name = "flag")
    private Integer flag;

    public Feedbacks() {
    }

    public Feedbacks(String feedBackID) {
        this.feedBackID = feedBackID;
    }

    public String getFeedBackID() {
        return feedBackID;
    }

    public void setFeedBackID(String feedBackID) {
        this.feedBackID = feedBackID;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedBackID != null ? feedBackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedbacks)) {
            return false;
        }
        Feedbacks other = (Feedbacks) object;
        if ((this.feedBackID == null && other.feedBackID != null) || (this.feedBackID != null && !this.feedBackID.equals(other.feedBackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Feedbacks[ feedBackID=" + feedBackID + " ]";
    }

}
