package gateways.ch.controllers;

import gateways.ch.models.Device;
import gateways.ch.models.Gateway;
import gateways.ch.service.DeviceServiceImpl;
import gateways.ch.service.GatewayService;
import gateways.ch.service.GatewayServiceImpl;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author FranciscoR
 */
@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Autowired
    GatewayService gatewayService;

    @Autowired()
    DeviceServiceImpl deviceServiceImpl;

    @GetMapping("/")
    public ArrayList<Gateway> getGateway() {
        return gatewayService.getGateway();
    }

    @GetMapping("/{id}")
    public Gateway showGateway(@PathVariable Long id) {
        return gatewayService.find(id);
    }

    @PostMapping("/")
    public ResponseEntity<Gateway> saveGateway(@RequestBody Gateway gateway) {
        if (validate(gateway.getIpAdrres())) {
            return ResponseEntity.ok(this.gatewayService.saveGateway(gateway));
        } else {
            return ResponseEntity.status(400).build();
        }

    }

    @PostMapping("/add")
    public void addDevice(@RequestBody Device device) {

        deviceServiceImpl.saveDevice(device);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceServiceImpl.deleteDevice(id);
    }

    //Validar la direccion IP
    public static boolean validate(final String ip) {
        String PATTERN = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
        return ip.matches(PATTERN);
    }
}
