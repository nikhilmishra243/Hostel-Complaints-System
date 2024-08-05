package net.javaguides.springboot.controller;

import java.util.List;

import net.javaguides.springboot.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.entity.Complaint;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.ComplaintRepository;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "http://localhost:3000")
public class ComplaintController {

	@Autowired
	private ComplaintRepository complaintRepository;

	@Autowired
	private ComplaintService complaintService;

	// get all complaints
	@GetMapping
	public List<Complaint> getAllComplaints() {
		return this.complaintRepository.findAll();
	}

	// get complaint by id
	@GetMapping("/{id}")
	public Complaint getComplaintById(@PathVariable (value = "id") long complaintId) {
		return this.complaintRepository.findById(complaintId)
				.orElseThrow(() -> new ResourceNotFoundException("Complaint not found with id :" + complaintId));
	}

	// create complaint
	@PostMapping
	public Complaint createComplaint(@RequestBody Complaint complaint) {
		return this.complaintService.createComplaint(complaint);
	}
	
	// update complaint
	@PutMapping("/{id}")
	public Complaint updateComplaint(@RequestBody Complaint complaint, @PathVariable ("id") long complaintId) {
		 Complaint existingComplaint = this.complaintRepository.findById(complaintId)
			.orElseThrow(() -> new ResourceNotFoundException("Complaint not found with id :" + complaintId));
		 existingComplaint.setFirstName(complaint.getFirstName());
		 existingComplaint.setLastName(complaint.getLastName());
		 existingComplaint.setEmail(complaint.getEmail());
		 return this.complaintRepository.save(existingComplaint);
	}
	
	// delete complaint by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Complaint> deleteComplaint(@PathVariable ("id") long complaintId){
		 Complaint existingComplaint = this.complaintRepository.findById(complaintId)
					.orElseThrow(() -> new ResourceNotFoundException("Complaint not found with id :" + complaintId));
		 this.complaintRepository.delete(existingComplaint);
		 return ResponseEntity.ok().build();
	}
}
