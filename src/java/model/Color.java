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
@Table(name = "Color", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "Color.findAll", query = "SELECT c FROM Color c"),
    @NamedQuery(name = "Color.findByIDColor", query = "SELECT c FROM Color c WHERE c.iDColor = :iDColor"),
    @NamedQuery(name = "Color.findByName", query = "SELECT c FROM Color c WHERE c.name = :name")})

public class Color implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "IDColor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDColor;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Name")
    private String name;
    
    @OneToMany(mappedBy = "colorID")
    private List<Item> itemList;

    public Color() {
    }

    public Color(Integer iDColor) {
        this.iDColor = iDColor;
    }

    public Color(Integer iDColor, String name) {
        this.iDColor = iDColor;
        this.name = name;
    }

    public Integer getIDColor() {
        return iDColor;
    }

    public void setIDColor(Integer iDColor) {
        this.iDColor = iDColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDColor != null ? iDColor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Color)) {
            return false;
        }
        Color other = (Color) object;
        return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
    }

    @Override
    public String toString() {
        return name;
    }

}
