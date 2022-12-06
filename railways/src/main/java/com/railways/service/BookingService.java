package com.railways.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railways.model.Ticket;
import com.railways.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository brepo;

	public static int available = 5;
	public static Integer pnrNo = 4001;

	public void save(Ticket ticket) {
		// String pnrNo=UUID.randomUUID().toString();
		ticket.setPnrNo(pnrNo.toString());
		Integer totalTickets = ticket.getTickets();
		if (available != 0 && totalTickets > available) {

			ticket.setStatus("Confirmed");
			ticket.setTickets(available);
			brepo.save(ticket);

			System.out.println("ticket details are :" + ticket);

			pnrNo++;
			Ticket ticket2 = new Ticket(ticket.getFname(), ticket.getLname(), ticket.getGender(), ticket.getDoj(),
					ticket.getAge(), ticket.getTrainName(), ticket.getDestination(), (totalTickets - available),
					ticket.getSource(), ticket.getAmount(), "Waiting", pnrNo.toString());

			// Ticket(String fname, String lname, String gender, String doj, Integer age,
			// String trainName,
			// String destination, Integer tickets, String source, float amount, String
			// status, String pnrNo) {
			brepo.save(ticket2);

			System.out.println("ticket details are :" + ticket);

			available = 0;
		} else if (available != 0 && totalTickets < available)

		{

			ticket.setStatus("Confirmed");
			ticket.setTickets(ticket.getTickets());
			brepo.save(ticket);
			available = available - ticket.getTickets();
		} else {
			ticket.setStatus("Waiting");
			brepo.save(ticket);
		}
		pnrNo++;
	}

	public List<Ticket> getAllTickets() {
		return brepo.findAll();
	}

}
