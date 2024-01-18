package com.codechampions.easytravel.repository;

import com.codechampions.easytravel.model.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {
}
