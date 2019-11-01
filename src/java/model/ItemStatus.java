/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DrazenDragovic
 */
@Entity
@Table(name = "ItemStatus", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "ItemStatus.findAll", query = "SELECT i FROM ItemStatus i"),
    @NamedQuery(name = "ItemStatus.findByIDItemStatus", query = "SELECT i FROM ItemStatus i WHERE i.iDItemStatus = :iDItemStatus"),
    @NamedQuery(name = "ItemStatus.findByName", query = "SELECT i FROM ItemStatus i WHERE i.name = :name")})

public class ItemStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "IDItemStatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDItemStatus;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Name")
    private String name;

    public ItemStatus() {
    }

    public ItemStatus(Integer iDItemStatus) {
        this.iDItemStatus = iDItemStatus;
    }

    public ItemStatus(Integer iDItemStatus, String name) {
        this.iDItemStatus = iDItemStatus;
        this.name = name;
    }

    public Integer getIDItemStatus() {
        return iDItemStatus;
    }

    public void setIDItemStatus(Integer iDItemStatus) {
        this.iDItemStatus = iDItemStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDItemStatus != null ? iDItemStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemStatus)) {
            return false;
        }
        ItemStatus other = (ItemStatus) object;
        return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
    }

    @Override
    public String toString() {
        return name;
    }

}
