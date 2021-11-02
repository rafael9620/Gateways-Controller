/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateways.ch.service;

import gateways.ch.models.Device;
import org.springframework.stereotype.Service;

/**
 *
 * @author FranciscoR
 */

public interface DeviceService {

    public Device saveDevice(Device device);

    public Device find(Long id);

    public void deleteDevice(Long id);
}
