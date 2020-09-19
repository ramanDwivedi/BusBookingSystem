package org.spring.busreservation.dao;

import org.spring.busreservation.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
@Query("from Ticket t where t.user.u_id=:userId")
 List<Ticket> findByUserId(@Param("userId") Long userId);
}
