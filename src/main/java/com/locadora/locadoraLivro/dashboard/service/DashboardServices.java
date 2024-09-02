package com.locadora.locadoraLivro.dashboard.service;

import com.locadora.locadoraLivro.Books.repositories.BookRepository;
import com.locadora.locadoraLivro.Renters.models.RenterModel;
import com.locadora.locadoraLivro.Renters.repositories.RenterRepository;
import com.locadora.locadoraLivro.Rents.models.RentStatusEnum;
import com.locadora.locadoraLivro.Rents.repositories.RentRepository;
import com.locadora.locadoraLivro.dashboard.DTOs.RentsperRenterResponseDTO;
import com.locadora.locadoraLivro.dashboard.mappers.BookRentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardServices {

    @Autowired
    RentRepository rentRepository;

    @Autowired
    RenterRepository renterRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private  BookRentMapper bookRentMapper;

    public int getNumberOfRentals() {
        List<RenterModel> totalRents = renterRepository.findAll();
        int rentsQuantity = totalRents.size();

        return rentsQuantity;
    }

    public int getNumberOfRentalsIsLate() {
        List<RenterModel> totalRentsLate = renterRepository.findAllByStatus(RentStatusEnum.LATE);
        int rentsLate = totalRentsLate.size();

        return rentsLate;
    }

    public int getDeliveredInTime() {
        List<RenterModel> totalRentsLate = rentRepository.findAllByStatus(RentStatusEnum.IN_TIME);
        int rentsInTime = totalRentsLate.size();

        return rentsInTime;
    }

    public int getDeliveredWithDelay() {
        List<RenterModel> totalRentsLate = rentRepository.findAllByStatus(RentStatusEnum.DELIVERED_WITH_DELAY);
        int rentsWithDelay = totalRentsLate.size();

        return rentsWithDelay;
    }

    public List<RentsperRenterResponseDTO> getRentsPerRenter() {
//        List<RenterModel> rents = renterRepository.findAllByRenterId(renter.getId());
//        List<RenterModel> rentsActive = renterRepository.findAllByRenterIdAndStatus(renter.getId(), RentStatusEnum.RENTED);
//        renterRentList.add(new RentsperRenterResponseDTO(renter.getName(), rents.size(), rentsActive.size()));

    }
}
