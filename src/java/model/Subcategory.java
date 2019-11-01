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

@Entity
@Table(name = "Subcategory", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "Subcategory.findAll", query = "SELECT s FROM Subcategory s"),
    @NamedQuery(name = "Subcategory.findByIDSubcategory", query = "SELECT s FROM Subcategory s WHERE s.iDSubcategory = :iDSubcategory"),
    @NamedQuery(name = "Subcategory.findByName", query = "SELECT s FROM Subcategory s WHERE s.name = :name"),
    @NamedQuery(name = "Subcategory.findBySubcatPath", query = "SELECT s FROM Subcategory s WHERE s.subcatPath = :subcatPath")})

public class Subcategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "IDSubcategory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDSubcategory;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;

    @Size(max = 100)
    @Column(name = "SubcatPath")
    private String subcatPath;

    @OneToMany(mappedBy = "subcategoryID")
    private List<Item> itemList;

    @JoinColumn(name = "CategoryID", referencedColumnName = "IDCategory")
    @ManyToOne
    private Category categoryID;

    @Size(max = 200)
    @Column(name = "Description")
    private String description;

    public Subcategory() {
    }

    public Subcategory(Integer iDSubcategory, String name, String subcatPath, List<Item> itemList, Category categoryID, String description) {
        this.iDSubcategory = iDSubcategory;
        this.name = name;
        this.subcatPath = subcatPath;
        this.itemList = itemList;
        this.categoryID = categoryID;
        this.description = description;
    }

    public Integer getIDSubcategory() {
        return iDSubcategory;
    }

    public void setIDSubcategory(Integer iDSubcategory) {
        this.iDSubcategory = iDSubcategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubcatPath() {
        return subcatPath;
    }

    public void setSubcatPath(String subcatPath) {
        this.subcatPath = subcatPath;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Category getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Category categoryID) {
        this.categoryID = categoryID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDSubcategory != null ? iDSubcategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategory)) {
            return false;
        }
        Subcategory other = (Subcategory) object;
        if ((this.iDSubcategory == null && other.iDSubcategory != null) || (this.iDSubcategory != null && !this.iDSubcategory.equals(other.iDSubcategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
