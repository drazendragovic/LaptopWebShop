package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AppOrder", catalog = "LaptopShop", schema = "dbo")

@NamedQueries({
    @NamedQuery(name = "AppOrder.findAll", query = "SELECT a FROM AppOrder a"),
    @NamedQuery(name = "AppOrder.findByIDOrder", query = "SELECT a FROM AppOrder a WHERE a.iDOrder = :iDOrder"),
    @NamedQuery(name = "AppOrder.findByUserID", query = "SELECT a FROM AppOrder a WHERE a.userID = :userID"),
    @NamedQuery(name = "AppOrder.findByStatusID", query = "SELECT a FROM AppOrder a WHERE a.statusID = :statusID"),
    @NamedQuery(name = "AppOrder.findByDate", query = "SELECT a FROM AppOrder a WHERE a.date = :date"),
    @NamedQuery(name = "AppOrder.findByTotalprice", query = "SELECT a FROM AppOrder a WHERE a.totalprice = :totalprice")})

public class AppOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDOrder")
    private Integer iDOrder;

    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Totalprice")
    private BigDecimal totalprice;

    @OneToMany(mappedBy = "orderID")
    private List<OrderItem> orderItemList;

    @JoinColumn(name = "UserID", referencedColumnName = "IDUser")
    @ManyToOne
    private AppUser userID;

    @JoinColumn(name = "StatusID", referencedColumnName = "IDOrderStatus")
    @ManyToOne
    private OrderStatus statusID;

    @JoinColumn(name = "PayementType", referencedColumnName = "IDPayementType")
    @ManyToOne
    private PayementType payementType;

    public AppOrder() {
    }

    public AppOrder(Integer iDOrder, Date date, BigDecimal totalprice, List<OrderItem> orderItemList, AppUser userID, OrderStatus statusID, PayementType payementType) {
        this.iDOrder = iDOrder;
        this.date = date;
        this.totalprice = totalprice;
        this.orderItemList = orderItemList;
        this.userID = userID;
        this.statusID = statusID;
        this.payementType = payementType;
    }

    public AppOrder(Date date, BigDecimal totalprice, List<OrderItem> orderItemList, AppUser userID, OrderStatus statusID, PayementType payementType) {
        this.date = date;
        this.totalprice = totalprice;
        this.orderItemList = orderItemList;
        this.userID = userID;
        this.statusID = statusID;
        this.payementType = payementType;
    }

    public AppOrder(Date date, BigDecimal totalprice, AppUser userID, OrderStatus statusID, PayementType payementType) {
        this.date = date;
        this.totalprice = totalprice;
        this.userID = userID;
        this.statusID = statusID;
        this.payementType = payementType;
    }

    public Integer getIDOrder() {
        return iDOrder;
    }

    public void setIDOrder(Integer iDOrder) {
        this.iDOrder = iDOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public AppUser getUserID() {
        return userID;
    }

    public void setUserID(AppUser userID) {
        this.userID = userID;
    }

    public OrderStatus getStatusID() {
        return statusID;
    }

    public void setStatusID(OrderStatus statusID) {
        this.statusID = statusID;
    }

    public PayementType getPayementType() {
        return payementType;
    }

    public void setPayementType(PayementType payementType) {
        this.payementType = payementType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOrder != null ? iDOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppOrder)) {
            return false;
        }
        AppOrder other = (AppOrder) object;
        if ((this.iDOrder == null && other.iDOrder != null) || (this.iDOrder != null && !this.iDOrder.equals(other.iDOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AppOrder[ iDOrder=" + iDOrder + " ]";
    }

}
