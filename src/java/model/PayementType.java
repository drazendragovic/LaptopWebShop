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
@Table(name = "PayementType", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "PayementType.findAll", query = "SELECT p FROM PayementType p"),
    @NamedQuery(name = "PayementType.findByIDPayementType", query = "SELECT p FROM PayementType p WHERE p.iDPayementType = :iDPayementType"),
    @NamedQuery(name = "PayementType.findByName", query = "SELECT p FROM PayementType p WHERE p.name = :name")})

public class PayementType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "IDPayementType")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDPayementType;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Name")
    private String name;
    
    @OneToMany(mappedBy = "payementType")
    private List<AppOrder> appOrderList;

    public PayementType() {
    }

    public PayementType(Integer iDPayementType) {
        this.iDPayementType = iDPayementType;
    }

    public PayementType(Integer iDPayementType, String name) {
        this.iDPayementType = iDPayementType;
        this.name = name;
    }

    public Integer getIDPayementType() {
        return iDPayementType;
    }

    public void setIDPayementType(Integer iDPayementType) {
        this.iDPayementType = iDPayementType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (iDPayementType != null ? iDPayementType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PayementType)) {
            return false;
        }
        PayementType other = (PayementType) object;
        return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
    }

    @Override
    public String toString() {
        return name;
    }
    
}
