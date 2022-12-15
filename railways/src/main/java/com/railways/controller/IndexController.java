package com.railways.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railways.model.Ticket;
import com.railways.service.BookingService;

@Controller
public class IndexController {

	@Autowired
	BookingService bser;

	@GetMapping("/*")
	public String trainReservation() {
		return "index";
	}
	
	@GetMapping("/index")
	public String register(String login) {
		if (login != null && login.equalsIgnoreCase("login"))
			return "login";
		else
			return "registration";
	}
	
	
	
	

	@PostMapping("/book")
	public String bookTicket(String ticket, ModelMap model) {
		if (ticket.equals("book")) {
			return "ticketbooking";
		} else {

			List<Ticket> noOfTickets = bser.getAllTickets();

			System.out.println("no of tickets " + noOfTickets);
			if (noOfTickets != null && noOfTickets.size() > 0)
				model.put("tickets", noOfTickets);

			return "tickets";
		}
	}

	@PostMapping("/bookTicket123")
	public String save(String fname, String lname, String trainNo, String source, String distination, String amount,
			String mobile, String email) {
		Ticket tb = new Ticket();
		tb.setTrainName(trainNo);
		tb.setSource(source);
		tb.setDestination(distination);
		tb.setAmount(Integer.parseInt(amount));
		tb.setFname(fname);
		tb.setLname(lname);

		bser.save(tb);
		return "success";
	}

	/**
	 * This is for postman testing
	 * 
	 * @param t
	 * @return
	 */
	@PostMapping("/bookTicket2")
	@ResponseBody
	public Ticket bookTicket(@RequestBody Ticket t) {
		bser.save(t);
		return null;
	}

}
