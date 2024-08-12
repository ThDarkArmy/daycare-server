package tda.darkarmy.daycare.service;

import jakarta.mail.MessagingException;
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

    @Autowired
    private MailSenderService mailSenderService;

    public List<Kid> getAll(){
        return kidRepository.findAll();
    }

    public List<Kid> getMyKids(){
        User user = userService.getLoggedInUser();
        return kidRepository.findByUser(user);
    }

    public Kid add(Long dayCareId, Kid kid) throws MessagingException {
        User user = userService.getLoggedInUser();
        DayCare dayCare = dayCareRepository.findById(dayCareId).orElseThrow(()-> new ResourceNotFoundException("DayCare not found"));
        kid.setDayCare(dayCare);
        kid.setUser(user);
        Kid kid1 = kidRepository.save(kid);
        String mailBody = createTemplate(kid, dayCare);
        mailSenderService.send(user, mailBody);
        return kid1;
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

    private String createTemplate(Kid kid, DayCare dayCare){
        String mailTemplate= """
                <!DOCTYPE html>
                <html lang="en">
                                
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Fee Receipt</title>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            background-color: #f4f4f4;
                            margin: 0;
                            padding: 0;
                        }
                                
                        .container {
                            width: 100%;
                            max-width: 600px;
                            margin: 20px auto;
                            background-color: #ffffff;
                            border: 1px solid #ddd;
                            border-radius: 8px;
                            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                        }
                                
                        .header {
                            background-color: #007bff;
                            color: #ffffff;
                            text-align: center;
                            padding: 20px;
                            border-radius: 8px 8px 0 0;
                        }
                                
                        .header h1 {
                            margin: 0;
                            font-size: 24px;
                        }
                                
                        .content {
                            padding: 20px;
                        }
                                
                        .content h2 {
                            margin-top: 0;
                            font-size: 20px;
                            color: #333;
                        }
                                
                        .content p {
                            font-size: 16px;
                            color: #555;
                            line-height: 1.6;
                        }
                                
                        .fee-table {
                            width: 100%;
                            border-collapse: collapse;
                            margin-top: 20px;
                        }
                                
                        .fee-table th,
                        .fee-table td {
                            border: 1px solid #ddd;
                            padding: 10px;
                            text-align: left;
                            font-size: 16px;
                        }
                                
                        .fee-table th {
                            background-color: #f8f8f8;
                        }
                                
                        .total {
                            font-weight: bold;
                        }
                                
                        .footer {
                            background-color: #f8f8f8;
                            padding: 20px;
                            text-align: center;
                            border-radius: 0 0 8px 8px;
                            font-size: 14px;
                            color: #555;
                        }
                                
                        .footer a {
                            color: #007bff;
                            text-decoration: none;
                        }
                    </style>
                </head>
                                
                <body>
                    <div class="container">
                        <div class="header">
                        <h3>Dear Sir</h3><br>
                        <h3>Admission of kid successful, Please find the fee receipt below.</h3>
                            <h1>Fee Receipt</h1>
                        </div>
                        <div class="content">
                            <h2>Dear Parent,</h2>
                            <p>Thank you for your payment. Please find the details of the fee receipt below:</p>
                                
                            <table class="fee-table">
                                <tr>
                                    <th>Description</th>
                                    <th>Amount (INR)</th>
                                </tr>
                                <tr>
                                    <td>Admission Fee</td>
                                    <td>5,000</td>
                                </tr>
                                <tr>
                                    <td>Tuition Fee</td>
                                    <td>2,000</td>
                                </tr>
                                <tr>
                                    <td>Cultural Activity Fee</td>
                                    <td>500</td>
                                </tr>
                                <tr>
                                    <td>Other Fee</td>
                                    <td>500</td>
                                </tr>
                                <tr class="total">
                                    <td>Total Amount</td>
                                    <td>90,000</td>
                                </tr>
                            </table>
                     """
                +"<p><strong>Student Name:</strong> "+ kid.getName()+"</p>"+
                "<p><strong>Daycare Name:</strong>"+dayCare.getName()+"</p>"+
                "<p><strong>Contact Details:</strong> "+dayCare.getContactNumber()+"</p>"+
                """
                <p>If you have any questions regarding the payment, feel free to contact us.</p>
                </div>
                <div class="footer">"""+

                "<p>Thank you for choosing "+dayCare.getName()+".</p>"+
                "<p>Phone: +"+dayCare.getContactNumber()+"</p>"+
                """
            </div>
            </div>
        </body>
                        
        </html>
                        
        """;

        return mailTemplate;
    }
}
