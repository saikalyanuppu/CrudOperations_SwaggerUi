package com.example.cd.service;

import com.example.cd.dto.DonationDTO;

import java.util.List;

public interface DonationService {
   
	DonationDTO createDonation(DonationDTO donationDTO);
    DonationDTO getDonationById(Long id);
    DonationDTO updateDonation(Long id, DonationDTO donationDTO);
    void deleteDonation(Long id);
    
    List<DonationDTO> getAllDonations();
}

