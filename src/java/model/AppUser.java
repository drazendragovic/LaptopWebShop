/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DrazenDragovic
 */
@Entity
@Table(name = "AppUser", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUser.findByIDUser", query = "SELECT a FROM AppUser a WHERE a.iDUser = :iDUser"),
    @NamedQuery(name = "AppUser.findByName", query = "SELECT a FROM AppUser a WHERE a.name = :name"),
    @NamedQuery(name = "AppUser.findBySurname", query = "SELECT a FROM AppUser a WHERE a.surname = :surname"),
    @NamedQuery(name = "AppUser.findByEmail", query = "SELECT a FROM AppUser a WHERE a.email = :email"),
    @NamedQuery(name = "AppUser.findByUsername", query = "SELECT a FROM AppUser a WHERE a.username = :username"),
    @NamedQuery(name = "AppUser.findByPassword", query = "SELECT a FROM AppUser a WHERE a.password = :password")})

public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUser")
    private Integer iDUser;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Surname")
    private String surname;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Username")
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Password")
    private String password;

    @OneToMany(mappedBy = "userID")
    private List<Logins> loginsList;
    @JoinColumn(name = "UserTypeID", referencedColumnName = "IDUserType")

    @ManyToOne
    private UserType userTypeID;
    @OneToMany(mappedBy = "userID")

    private List<AppOrder> appOrderList;

    public AppUser() {
    }

    public AppUser(String name, String surname, String email, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public AppUser(Integer iDUser, String name, String surname, String email, String username, String password) {
        this.iDUser = iDUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public AppUser(Integer iDUser, String name, String surname, String email, String username, String password, UserType userTypeID) {
        this.iDUser = iDUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userTypeID = userTypeID;
    }

    public Integer getIDUser() {
        return iDUser;
    }

    public void setIDUser(Integer iDUser) {
        this.iDUser = iDUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Logins> getLoginsList() {
        return loginsList;
    }

    public void setLoginsList(List<Logins> loginsList) {
        this.loginsList = loginsList;
    }

    public UserType getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(UserType userTypeID) {
        this.userTypeID = userTypeID;
    }

    public List<AppOrder> getAppOrderList() {
        return appOrderList;
    }

    public void setAppOrderList(List<AppOrder> appOrderList) {
        this.appOrderList = appOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDUser != null ? iDUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.iDUser == null && other.iDUser != null) || (this.iDUser != null && !this.iDUser.equals(other.iDUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

}
