package tda.darkarmy.daycare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tda.darkarmy.daycare.exception.ResourceNotFoundException;
import tda.darkarmy.daycare.model.DayCare;
import tda.darkarmy.daycare.model.Kid;
import tda.darkarmy.daycare.model.User;
import tda.darkarmy.daycare.repository.DayCareRepository;
import tda.darkarmy.daycare.repository.KidRepository;
import tda.darkarmy.daycare.repository.UserRepository;

import java.util.List;

@Service
public class KidService {
    @Autowired
    private KidRepository kidRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DayCareRepository dayCareRepository;

    @Autowired
    private UserService userService;

    public List<Kid> getAll(){
        return kidRepository.findAll();
    }

    public List<Kid> getMyKids(){
        User user = userService.getLoggedInUser();
        return kidRepository.findByUser(user);
    }

    public Kid add(Long dayCareId, Kid kid){
        User user = userService.getLoggedInUser();
        DayCare dayCare = dayCareRepository.findById(dayCareId).orElseThrow(()-> new ResourceNotFoundException("DayCare not found"));
        kid.setDayCare(dayCare);
        kid.setUser(user);
        return kidRepository.save(kid);
    }

    public Kid update(Long id, Kid kid){
        User user = userService.getLoggedInUser();
        kidRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Kid not found"));
        kid.setUser(user);
        kid.setId(id);
        return kidRepository.save(kid);
    }

    public String delete(Long id){
        kidRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Kid not found"));
        kidRepository.deleteById(id);
        return "Kids deleted successfully";
    }
}
