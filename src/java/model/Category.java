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
@Table(name = "Category", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByIDCategory", query = "SELECT c FROM Category c WHERE c.iDCategory = :iDCategory"),
    @NamedQuery(name = "Category.findByName", query = "SELECT c FROM Category c WHERE c.name = :name"),
    @NamedQuery(name = "Category.findByCatPath", query = "SELECT c FROM Category c WHERE c.catPath = :catPath")})

public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "IDCategory")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDCategory;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;

    @Size(max = 100)
    @Column(name = "CatPath")
    private String catPath;

    @OneToMany(mappedBy = "categoryID")
    private List<Subcategory> subcategoryList;

    @Size(max = 200)
    @Column(name = "Description")
    private String description;

    public Category() {
    }

    public Category(Integer iDCategory) {
        this.iDCategory = iDCategory;
    }

    public Category(Integer iDCategory, String name, String catPath, List<Subcategory> subcategoryList, String description) {
        this.iDCategory = iDCategory;
        this.name = name;
        this.catPath = catPath;
        this.subcategoryList = subcategoryList;
        this.description = description;
    }


    public Integer getIDCategory() {
        return iDCategory;
    }

    public void setIDCategory(Integer iDCategory) {
        this.iDCategory = iDCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatPath() {
        return catPath;
    }

    public void setCatPath(String catPath) {
        this.catPath = catPath;
    }

    public List<Subcategory> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(List<Subcategory> subcategoryList) {
        this.subcategoryList = subcategoryList;
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
        hash += (iDCategory != null ? iDCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
    }

    @Override
    public String toString() {
        return name;
    }

}
