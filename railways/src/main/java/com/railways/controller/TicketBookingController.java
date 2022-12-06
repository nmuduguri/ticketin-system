package com.railways.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.railways.model.Ticket;
import com.railways.service.BookingService;
import com.railways.utils.UserUtility;

@Controller
public class TicketBookingController {

	@Autowired
	BookingService bser;
	@Autowired
	UserUtility userUtility;

	@PostMapping("/bookTicket")
	public String save(String fname, String lname, String gender, String doj, String age, String trainName, String tickets, String source, String destination,
			String amount, String mobile, String email, ModelMap model) {

		boolean errorFlag = userUtility.ticketValidation(fname, lname, gender, doj, age, trainName, tickets, source, destination, amount,
				mobile, email, model);

		if (errorFlag) {
			if (BookingService.available > 0)
				model.put("available", "Available Tickets Are : " + BookingService.available);
			else
				model.put("noAvailable", "Tickets Are Not Available and Waiting List Started ");
			return "bookticket";
		}

		Ticket ticket = new Ticket();
		ticket.setFname(fname);
		ticket.setLname(lname);
		ticket.setGender(gender);
		ticket.setDoj(doj);
		ticket.setTickets(Integer.valueOf(tickets));
		ticket.setAge(Integer.valueOf(age));
		ticket.setTrainName(trainName);
		ticket.setSource(source);
		ticket.setDestination(destination);
		ticket.setAmount(Integer.parseInt(amount));
		

		bser.save(ticket);
		model.put("successMsg", "Ticket Booking is Successfull");
		return "success";
	}
}
