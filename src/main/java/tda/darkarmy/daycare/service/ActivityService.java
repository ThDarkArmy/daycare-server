package tda.darkarmy.daycare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tda.darkarmy.daycare.exception.ResourceNotFoundException;
import tda.darkarmy.daycare.model.Activity;
import tda.darkarmy.daycare.repository.ActivityRepository;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAll(){
        return activityRepository.findAll();
    }

    public Activity getById(Long id){
        return activityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Activity not found"));
    }

    public Activity add(Activity activity){
        return activityRepository.save(activity);
    }

    public Activity update(Long id, Activity activity){
        Activity activity1 = activityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Activity not found"));
        activity1.setId(id);
        return activityRepository.save(activity1);
    }

    public String delete(Long id){
        activityRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Activity not found"));
        activityRepository.deleteById(id);
        return "Activity deleted successfully";
    }
}
