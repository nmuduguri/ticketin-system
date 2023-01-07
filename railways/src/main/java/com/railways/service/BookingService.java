package com.railways.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railways.controller.TicketBookingController;
import com.railways.model.Ticket;
import com.railways.repository.BookingRepository;

@Service
public class BookingService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BookingService.class);


	@Autowired
	BookingRepository bookingRepository;

	public static int available = 5;
	public static Integer pnrNo = 4001;

	public void save(Ticket ticket) {
		
		LOGGER.info("Ticket Booking Started: {}",ticket);

		ticket.setPnrNo(pnrNo.toString());
		Integer totalTickets = ticket.getTickets();
		if (available != 0 && totalTickets > available) {

			ticket.setStatus("Confirmed");
			ticket.setTickets(available);
			bookingRepository.save(ticket);

			System.out.println("ticket details are :" + ticket);

			pnrNo++;
			Ticket ticket2 = new Ticket(ticket.getFname(), ticket.getLname(), ticket.getGender(), ticket.getDoj(),
					ticket.getAge(), ticket.getTrainName(), ticket.getDestination(), (totalTickets - available),
					ticket.getSource(), ticket.getAmount(), "Waiting", pnrNo.toString());

			
			bookingRepository.save(ticket2);

			System.out.println("ticket details are :" + ticket);

			available = 0;
		} else if (available != 0 && totalTickets < available)

		{

			ticket.setStatus("Confirmed");
			ticket.setTickets(ticket.getTickets());
			bookingRepository.save(ticket);
			available = available - ticket.getTickets();
		} else {
			ticket.setStatus("Waiting");
			bookingRepository.save(ticket);
		}
		pnrNo++;
		
		LOGGER.info("Ticket Booking Done..");
	}

	public List<Ticket> getAllTickets() {
		return bookingRepository.findAll();
	}

}
