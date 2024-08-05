package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Complaint;
import net.javaguides.springboot.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;


    public Complaint createComplaint(Complaint complaint) {
        complaint.setEmail(complaint.getEmail()+"@gmail.com");
        complaintRepository.save(complaint);
        return complaint;
    }
}
