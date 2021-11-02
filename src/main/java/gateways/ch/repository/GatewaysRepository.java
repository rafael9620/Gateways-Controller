/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateways.ch.repository;

import gateways.ch.models.Device;
import gateways.ch.models.Gateway;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FranciscoR
 */
@Repository
@Transactional
public interface GatewaysRepository extends JpaRepository<Gateway, Long> {

    
    
    

}
