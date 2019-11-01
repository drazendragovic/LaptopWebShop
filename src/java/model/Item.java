/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DrazenDragovic
 */
@Entity
@Table(name = "Item", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByIDItem", query = "SELECT i FROM Item i WHERE i.iDItem = :iDItem"),
    @NamedQuery(name = "Item.findByCode", query = "SELECT i FROM Item i WHERE i.code = :code"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByPrice", query = "SELECT i FROM Item i WHERE i.price = :price"),
    @NamedQuery(name = "Item.findByDesription", query = "SELECT i FROM Item i WHERE i.desription = :desription"),
    @NamedQuery(name = "Item.findByCategory", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findByItemStatus", query = "SELECT i FROM Item i WHERE i.itemStatusID = :itemStatusID")})

@NamedStoredProcedureQuery(name="Item.getItemByCategory", procedureName="getItemByCategory", resultClasses = { Item.class },
        parameters = {
              @StoredProcedureParameter(name = "idCategory", type = Integer.class, mode = ParameterMode.IN),
      }
)

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDItem")
    private Integer iDItem;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Code")
    private String code;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private BigDecimal price;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Desription")
    private String desription;

    @JoinColumn(name = "ColorID", referencedColumnName = "IDColor")
    @ManyToOne
    private Color colorID;

    @JoinColumn(name = "ItemStatusID", referencedColumnName = "IDItemStatus")
    @ManyToOne
    private ItemStatus itemStatusID;

    @JoinColumn(name = "SubcategoryID", referencedColumnName = "IDSubcategory")
    @ManyToOne
    private Subcategory subcategoryID;

    public Item() {
    }

    public Item(Integer iDItem) {
        this.iDItem = iDItem;
    }

    public Item(Integer iDItem, String code, String name, BigDecimal price, String desription) {
        this.iDItem = iDItem;
        this.code = code;
        this.name = name;
        this.price = price;
        this.desription = desription;
    }

    public Item(Integer iDItem, String code, String name, BigDecimal price, String desription, Color colorID, ItemStatus itemStatusID, Subcategory subcategoryID) {
        this.iDItem = iDItem;
        this.code = code;
        this.name = name;
        this.price = price;
        this.desription = desription;
        this.colorID = colorID;
        this.itemStatusID = itemStatusID;
        this.subcategoryID = subcategoryID;
    }
    

    public Integer getIDItem() {
        return iDItem;
    }

    public void setIDItem(Integer iDItem) {
        this.iDItem = iDItem;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public Color getColorID() {
        return colorID;
    }

    public void setColorID(Color colorID) {
        this.colorID = colorID;
    }

    public ItemStatus getItemStatusID() {
        return itemStatusID;
    }

    public void setItemStatusID(ItemStatus itemStatusID) {
        this.itemStatusID = itemStatusID;
    }

    public Subcategory getSubcategoryID() {
        return subcategoryID;
    }

    public void setSubcategory(Subcategory subcategoryID) {
        this.subcategoryID = subcategoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDItem != null ? iDItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code + ": " + name;
    }

}
