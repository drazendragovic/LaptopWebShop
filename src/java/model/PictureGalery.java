package model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "PictureGalery", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "PictureGalery.findAll", query = "SELECT p FROM PictureGalery p"),
    @NamedQuery(name = "PictureGalery.findByIDGalery", query = "SELECT p FROM PictureGalery p WHERE p.iDGalery = :iDGalery"),
    @NamedQuery(name = "PictureGalery.findByName", query = "SELECT p FROM PictureGalery p WHERE p.name = :name"),
    @NamedQuery(name = "PictureGalery.findByPicPath", query = "SELECT p FROM PictureGalery p WHERE p.picPath = :picPath"),
    @NamedQuery(name = "PictureGalery.findByProductID", query = "SELECT p FROM PictureGalery p WHERE p.pictureItemID.iDItem = :pictureItemID")})

public class PictureGalery implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "IDGalery")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDGalery;
    
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PicPath")
    private String picPath;
    
    @JoinColumn(name = "PictureItemID", referencedColumnName = "IDItem")
    @ManyToOne
    private Item pictureItemID;

    public PictureGalery() {
    }

    public PictureGalery(Integer iDGalery, String name, String picPath) {
        this.iDGalery = iDGalery;
        this.name = name;
        this.picPath = picPath;
    }

    

    public Integer getIDGalery() {
        return iDGalery;
    }

    public void setIDGalery(Integer iDGalery) {
        this.iDGalery = iDGalery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Item getPictureItemID() {
        return pictureItemID;
    }

    public void setPictureItemID(Item pictureItemID) {
        this.pictureItemID = pictureItemID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDGalery != null ? iDGalery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PictureGalery)) {
            return false;
        }
        PictureGalery other = (PictureGalery) object;
        if ((this.iDGalery == null && other.iDGalery != null) || (this.iDGalery != null && !this.iDGalery.equals(other.iDGalery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
