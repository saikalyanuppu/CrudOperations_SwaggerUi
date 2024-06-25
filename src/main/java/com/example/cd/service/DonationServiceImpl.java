package com.example.cd.service;

import com.example.cd.dto.DonationDTO;

import com.example.cd.entity.Donation;
import com.example.cd.exception.CustomException;
import com.example.cd.repository.DonationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    @Autowired
    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public DonationDTO createDonation(DonationDTO donationDTO) {
        // Convert DTO to Entity
        Donation donation = new Donation();
        BeanUtils.copyProperties(donationDTO, donation);

        // Save to database
        Donation savedDonation = donationRepository.save(donation);

        // Convert saved Entity back to DTO
        DonationDTO responseDTO = new DonationDTO();
        BeanUtils.copyProperties(savedDonation, responseDTO);
        return responseDTO;
    }

    @Override
    public DonationDTO getDonationById(Long id) {
        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new CustomException("Donation not found"));
        DonationDTO donationDTO = new DonationDTO();
        BeanUtils.copyProperties(donation, donationDTO);
        return donationDTO;
    }

    @Override
    public DonationDTO updateDonation(Long id, DonationDTO donationDTO) {
        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new CustomException("Donation not found"));
        BeanUtils.copyProperties(donationDTO, donation);
        donation.setId(id);
        Donation updatedDonation = donationRepository.save(donation);
        DonationDTO responseDTO = new DonationDTO();
        BeanUtils.copyProperties(updatedDonation, responseDTO);
        return responseDTO;
    }

    @Override
    public void deleteDonation(Long id) {
        if (!donationRepository.existsById(id)) {
            throw new CustomException("Donation not found");
        }
        donationRepository.deleteById(id);
    }

    @Override
    public List<DonationDTO> getAllDonations() {
        List<Donation> donations = donationRepository.findAll();
        return donations.stream().map(donation -> {
            DonationDTO donationDTO = new DonationDTO();
            BeanUtils.copyProperties(donation, donationDTO);
            return donationDTO;
        }).collect(Collectors.toList());
    }
}

