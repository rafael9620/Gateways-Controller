/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateways.ch.service;

import gateways.ch.models.Gateway;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author FranciscoR
 */
@Service
public interface GatewayService {

    public ArrayList<Gateway> getGateway();

    public Gateway saveGateway(Gateway gateway);
    
    public Gateway find(Long id);
    
    

}
