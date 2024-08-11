package tda.darkarmy.daycare.service;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tda.darkarmy.daycare.dto.DayCareDto;
import tda.darkarmy.daycare.exception.ResourceNotFoundException;
import tda.darkarmy.daycare.model.DayCare;
import tda.darkarmy.daycare.model.User;
import tda.darkarmy.daycare.repository.DayCareRepository;
import tda.darkarmy.daycare.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

@Service
public class DayCareService {

    private final String BASE_URL = "http://localhost:8000";
    private Path fileStoragePath;

    @Autowired
    private DayCareRepository dayCareRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSenderService mailSenderService;

    public DayCareService() {
        try {
            fileStoragePath = Paths.get("src\\main\\resources\\static\\fileStorage").toAbsolutePath().normalize();
            Files.createDirectories(fileStoragePath);
        } catch (IOException e) {
            throw new RuntimeException("Issue in creating file directory");
        }
    }

    public List<DayCare> getAll(){
        return dayCareRepository.findAll();
    }

    public DayCare getById(Long id){
        return dayCareRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("DayCare not found"));
    }

    public DayCare save(DayCareDto dayCareDto) throws MessagingException {
        User user = userService.getLoggedInUser();
        System.out.println("User: "+user);
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(dayCareDto.getImage().getOriginalFilename()));
        fileName = Math.random() + fileName.replace(" ", "");
        Path filePath = Paths.get(fileStoragePath + "\\" + fileName);

        try {
            Files.copy(dayCareDto.getImage().getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DayCare dayCare = new DayCare();
        dayCare.setCity(dayCareDto.getCity());
        dayCare.setName(dayCareDto.getName());
        dayCare.setFullAddress(dayCareDto.getFullAddress());
        dayCare.setHigherAgeLimit(dayCareDto.getHigherAgeLimit());
        dayCare.setLowerAgeLimit(dayCareDto.getLowerAgeLimit());
        dayCare.setRegistrationFee(dayCareDto.getRegistrationFee());
        dayCare.setImagePath(BASE_URL + "/fileStorage/" + fileName);
        dayCare.setAboutUs(dayCareDto.getAboutUs());
        dayCare.setContactNumber(dayCareDto.getContactNumber());
        dayCare.setUser(user);
        user.setDayCare(dayCare);
        User user1 = userRepository.save(user);
        String mailBody = """
                <h3>Dear Sir</h3><br>
                <h3>Registration of a daycare successful, registration fee of ₹500 paid, Please find the details below.</h3>
                <br>
                """;
        mailSenderService.send(user, mailBody+dayCare.toString());
        return user1.getDayCare();
    }

    public String delete(Long id){
        dayCareRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("daycare not found"));
        dayCareRepository.deleteById(id);
        return "DayCare deleted successfully!";
    }

    public DayCare getMyDaycare(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return dayCareRepository.findByUser(user);
    }
}
