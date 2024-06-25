package com.example.cd.repository;

import com.example.cd.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DonationRepository extends JpaRepository<Donation, Long> {
}
