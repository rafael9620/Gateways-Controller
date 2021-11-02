/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateways.ch.repository;

import gateways.ch.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author FranciscoR
 */
@Repository
@Transactional
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Modifying
    @Query(value = "delete from devices d where d.id_devices = ?1", nativeQuery = true)
    void deleteDevice(Long id);
}
