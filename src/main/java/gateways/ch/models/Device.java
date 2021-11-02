package gateways.ch.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author FranciscoR
 */
@Entity(name = "devices")
@DynamicUpdate
@DynamicInsert
@Cacheable(false)
public class Device implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_devices", unique = true, nullable = false)
    private Long idDevices;

    @Column(name = "vendor")
    private String vendor;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_gateway")
    //@JsonIgnore
    @JsonBackReference
    private Gateway gateway;

    public Device() {
    }

    public Device(String vendor, Date date, Boolean status, Gateway gateway) {
        this.vendor = vendor;
        this.date = date;
        this.status = status;
        this.gateway = gateway;
    }

    public Long getIdDevices() {
        return this.idDevices;
    }

    public void setIdDevices(Long idDevices) {
        this.idDevices = idDevices;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Gateway getGateway() {
        return gateway;
    }

    public void setGateway(Gateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public String toString() {
        return "Device{" + "idDevices=" + idDevices + ", vendor=" + vendor + ", date=" + date + ", status=" + status + '}';
    }

}
