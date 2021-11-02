/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateways.ch.service;

import gateways.ch.models.Device;
import gateways.ch.models.Gateway;
import gateways.ch.repository.GatewaysRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FranciscoR
 */
@Service
public class GatewayServiceImpl implements GatewayService {

    private Gateway gateway;
    
    @Autowired
    GatewaysRepository gatewaysRepository;

    @Override
    public ArrayList<Gateway> getGateway() {
        return (ArrayList<Gateway>) gatewaysRepository.findAll();
    }

    @Override
    public Gateway saveGateway(Gateway gateway) {
        return gatewaysRepository.save(gateway);
    }

    @Override
    public Gateway find(Long id) {
       return gatewaysRepository.findById(id).get();
    }
    
}
