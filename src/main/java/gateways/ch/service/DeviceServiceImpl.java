/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateways.ch.service;

import gateways.ch.models.Device;
import gateways.ch.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FranciscoR
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device find(Long id) {
        return deviceRepository.findById(id).get();
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteDevice(id);
    }

}
