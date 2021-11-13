package com.compurent.compurent.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.compurent.compurent.model.Client;
import com.compurent.compurent.model.Reservation;
import com.compurent.compurent.model.report.CountClient;
import com.compurent.compurent.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }


    public List<Reservation> getReportDates(Date dateInit, Date dateEnd){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateInit, dateEnd);
    }

    public List<Reservation> getStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<CountClient> getTopClients(){
        List<CountClient> resultado=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0; i< report.size(); i++){
            resultado.add(new CountClient((Long) report.get(i)[1], (Client)report.get(i)[0]));
        }
        return resultado;
    }

    // public List<Reservation> getEmpleadosPorEstado(String estado){
    //     return reservationCrudRepository.findAllByEstado(estado);
    // }

    // public List<Reservation> getTopDepartamentos(){
    //     List<Reservation> res= new ArrayList<>(); 

    //     List<Object[]> reporte=reservationCrudRepository.countTotalEmpleadosByDepartamento();

          
    //     return null;
    // }
}
