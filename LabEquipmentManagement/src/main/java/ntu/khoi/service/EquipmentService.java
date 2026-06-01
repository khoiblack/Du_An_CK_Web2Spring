package ntu.khoi.service;

import ntu.khoi.entity.Equipment;
import ntu.khoi.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    
    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    
    public void save(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    
    public Equipment getById(Integer id) {
        return equipmentRepository.findById(id).orElse(null);
    }

    
    public void delete(Integer id) {
        equipmentRepository.deleteById(id);
    }
}