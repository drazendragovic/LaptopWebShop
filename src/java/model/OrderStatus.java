
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
@Table(name = "OrderStatus", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "OrderStatus.findAll", query = "SELECT o FROM OrderStatus o"),
    @NamedQuery(name = "OrderStatus.findByIDOrderStatus", query = "SELECT o FROM OrderStatus o WHERE o.iDOrderStatus = :iDOrderStatus"),
    @NamedQuery(name = "OrderStatus.findByName", query = "SELECT o FROM OrderStatus o WHERE o.name = :name")})

public class OrderStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "IDOrderStatus")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDOrderStatus;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    
    @OneToMany(mappedBy = "statusID")
    private List<AppOrder> appOrderList;

    public OrderStatus() {
    }

    public OrderStatus(Integer iDOrderStatus) {
        this.iDOrderStatus = iDOrderStatus;
    }

    public OrderStatus(Integer iDOrderStatus, String name) {
        this.iDOrderStatus = iDOrderStatus;
        this.name = name;
    }

    public Integer getIDOrderStatus() {
        return iDOrderStatus;
    }

    public void setIDOrderStatus(Integer iDOrderStatus) {
        this.iDOrderStatus = iDOrderStatus;
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
        hash += (iDOrderStatus != null ? iDOrderStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderStatus)) {
            return false;
        }
        OrderStatus other = (OrderStatus) object;
        return !((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name)));
    }

    @Override
    public String toString() {
        return name;
    }
    
}
