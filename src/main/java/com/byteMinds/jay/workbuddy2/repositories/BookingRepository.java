package com.byteMinds.jay.workbuddy2.repositories;

import com.byteMinds.jay.workbuddy2.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
