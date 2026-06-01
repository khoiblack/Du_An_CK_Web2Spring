package ntu.khoi.service;

import ntu.khoi.entity.LabRoom;
import ntu.khoi.repository.LabRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LabRoomService {

    @Autowired
    private LabRoomRepository labRoomRepository;

    public List<LabRoom> getAll() {
        return labRoomRepository.findAll();
    }

    public LabRoom getById(Integer id) {
        return labRoomRepository.findById(id).orElse(null);
    }
    public void save(LabRoom labRoom) {
        labRoomRepository.save(labRoom);
    }

    public void delete(Integer id) {
        labRoomRepository.deleteById(id);
    }
}