package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Logins", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "Logins.findAll", query = "SELECT l FROM Logins l"),
    @NamedQuery(name = "Logins.findByIDLogin", query = "SELECT l FROM Logins l WHERE l.iDLogin = :iDLogin"),
    @NamedQuery(name = "Logins.findByDate", query = "SELECT l FROM Logins l WHERE l.date = :date"),
    @NamedQuery(name = "Logins.findByIpAdress", query = "SELECT l FROM Logins l WHERE l.ipAdress = :ipAdress")})

public class Logins implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "IDLogin")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDLogin;

    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Size(max = 15)
    @Column(name = "IpAdress")
    private String ipAdress;

    @JoinColumn(name = "UserID", referencedColumnName = "IDUser")
    @ManyToOne
    private AppUser userID;

    public Logins() {
    }
    
    public Logins(Date date, String ipAdress, AppUser userID) {
        this.date = date;
        this.ipAdress = ipAdress;
        this.userID = userID;
    }

    public Integer getIDLogin() {
        return iDLogin;
    }

    public void setIDLogin(Integer iDLogin) {
        this.iDLogin = iDLogin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public AppUser getUserID() {
        return userID;
    }

    public void setUserID(AppUser userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDLogin != null ? iDLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logins)) {
            return false;
        }
        Logins other = (Logins) object;
        if ((this.iDLogin == null && other.iDLogin != null) || (this.iDLogin != null && !this.iDLogin.equals(other.iDLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return userID.getName() + ": " + ipAdress;
    }

}
