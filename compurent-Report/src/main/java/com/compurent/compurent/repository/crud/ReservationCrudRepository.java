package com.compurent.compurent.repository.crud;

import java.util.Date;
import java.util.List;
import com.compurent.compurent.model.Reservation;

import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    @Query("select c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalReservationByClient();

    
    // @Query("select e.idReservation, COUNT(e.idReservation) from reservation as e group by e.idReservation order by COUNT(e.idReservation) desc")
    // public List<Object[]> countTotalEmpleadosByDepartamento(); 

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateInit, Date dateEnd);
    
    public List<Reservation> findAllByStatus(String status);
}
