package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UserType", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u"),
    @NamedQuery(name = "UserType.findByIDUserType", query = "SELECT u FROM UserType u WHERE u.iDUserType = :iDUserType"),
    @NamedQuery(name = "UserType.findByName", query = "SELECT u FROM UserType u WHERE u.name = :name")})

public class UserType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "IDUserType")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDUserType;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Name")
    private String name;
    
    @OneToMany(mappedBy = "userTypeID")
    private List<AppUser> appUserList;

    public UserType() {
    }

    public UserType(Integer iDUserType) {
        this.iDUserType = iDUserType;
    }

    public UserType(Integer iDUserType, String name) {
        this.iDUserType = iDUserType;
        this.name = name;
    }

    public Integer getIDUserType() {
        return iDUserType;
    }

    public void setIDUserType(Integer iDUserType) {
        this.iDUserType = iDUserType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AppUser> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDUserType != null ? iDUserType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserType)) {
            return false;
        }
        UserType other = (UserType) object;
        return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
    }

    @Override
    public String toString() {
        return name;
    }
    
}
