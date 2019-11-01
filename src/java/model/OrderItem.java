package model;

import java.io.Serializable;
import java.math.BigDecimal;
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

@Entity
@Table(name = "OrderItem", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "OrderItem.findAll", query = "SELECT o FROM OrderItem o"),
    @NamedQuery(name = "OrderItem.findByIDOrderItem", query = "SELECT o FROM OrderItem o WHERE o.iDOrderItem = :iDOrderItem"),
    @NamedQuery(name = "OrderItem.findByQuantity", query = "SELECT o FROM OrderItem o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "OrderItem.findByPrice", query = "SELECT o FROM OrderItem o WHERE o.price = :price"),
    @NamedQuery(name = "OrderItem.findByOrderID", query = "SELECT o FROM OrderItem o WHERE o.orderID = :orderID"),
    @NamedQuery(name = "OrderItem.findByOrderPrice", query = "SELECT o FROM OrderItem o WHERE o.orderPrice = :orderPrice")})

public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "IDOrderItem")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDOrderItem;

    @Column(name = "Quantity")
    private Integer quantity;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "OrderPrice")
    private BigDecimal orderPrice;

    @JoinColumn(name = "OrderID", referencedColumnName = "IDOrder")
    @ManyToOne
    private AppOrder orderID;

    @JoinColumn(name = "ItemID", referencedColumnName = "IDItem")
    @ManyToOne
    private Item itemID;

    public OrderItem() {
    }

    public OrderItem(Integer iDOrderItem, Integer quantity, BigDecimal price, BigDecimal orderPrice, AppOrder orderID, Item itemID) {
        this.iDOrderItem = iDOrderItem;
        this.quantity = quantity;
        this.price = price;
        this.orderPrice = orderPrice;
        this.orderID = orderID;
        this.itemID = itemID;
    }

    public OrderItem(Integer quantity, BigDecimal price, BigDecimal orderPrice, AppOrder orderID, Item itemID) {
        this.quantity = quantity;
        this.price = price;
        this.orderPrice = orderPrice;
        this.orderID = orderID;
        this.itemID = itemID;
    }

    public Integer getIDOrderItem() {
        return iDOrderItem;
    }

    public void setIDOrderItem(Integer iDOrderItem) {
        this.iDOrderItem = iDOrderItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public AppOrder getOrderID() {
        return orderID;
    }

    public void setOrderID(AppOrder orderID) {
        this.orderID = orderID;
    }

    public Item getItemID() {
        return itemID;
    }

    public void setItemID(Item itemID) {
        this.itemID = itemID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOrderItem != null ? iDOrderItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.iDOrderItem == null && other.iDOrderItem != null) || (this.iDOrderItem != null && !this.iDOrderItem.equals(other.iDOrderItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return iDOrderItem.toString();
    }

}
