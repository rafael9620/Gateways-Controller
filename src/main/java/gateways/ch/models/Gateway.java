package gateways.ch.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author FranciscoR
 */
@Entity(name = "gateway")
@DynamicUpdate
@DynamicInsert
@Cacheable(false)
public class Gateway implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id_gateway", unique = true, nullable = false)
    private Long idGateway;

    @Column(name = "uniqueNumber")
    private String uniqueNumber;

    @Column(name = "namehuman")
    private String namehuman;

    @Column(name = "ip_adrres")
    private String ipAdrres;

    @OneToMany(mappedBy = "gateway", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    //@JsonIgnore
    //@JsonIgnoreProperties

    private List<Device> devices;

    public Gateway() {
    }

    public Gateway(Long idGateway) {
        this.idGateway = idGateway;
    }

    public Gateway(String uniqueNumber, String namehuman, String ipAdrres) {
        this.uniqueNumber = uniqueNumber;
        this.namehuman = namehuman;
        this.ipAdrres = ipAdrres;
    }

    public Long getIdGateway() {
        return idGateway;
    }

    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getNamehuman() {
        return namehuman;
    }

    public void setNamehuman(String namehuman) {
        this.namehuman = namehuman;
    }

    public String getIpAdrres() {
        return ipAdrres;
    }

    public void setIpAdrres(String ipAdrres) {
        this.ipAdrres = ipAdrres;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Gateway{" + "idGateway=" + idGateway + ", uniqueNumber=" + uniqueNumber + ", namehuman=" + namehuman + ", ipAdrres=" + ipAdrres + ", devices=" + devices + '}';
    }

}
