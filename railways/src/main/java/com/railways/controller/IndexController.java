package com.railways.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.railways.model.Comments;
import com.railways.model.Ticket;
import com.railways.service.BookingService;

@Controller
public class IndexController {

	@Autowired
	BookingService bookingService;

	@GetMapping("/")
	public String trainReservation() {
		return "index";
	}

	@GetMapping("/test")
	@ResponseBody
	public List<List<Comments>> test() {

		Comments c1 = new Comments();
		c1.setId(120);
		c1.setComments("test1");

		Comments c2 = new Comments();
		c2.setId(121);
		c2.setComments("test2");

		Comments c3 = new Comments();
		c3.setId(123);
		c3.setComments("test3");

		Comments c4 = new Comments();
		c4.setId(124);
		c4.setComments("test4");

		List<Comments> list1 = new ArrayList<>();

		list1.add(c1);
		list1.add(c2);

		List<Comments> list2 = new ArrayList<>();

		list2.add(c3);
		list2.add(c4);

		List<List<Comments>> clist = new ArrayList<>();
		clist.add(list1);
		clist.add(list2);
		
		return clist;

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

			List<Ticket> noOfTickets = bookingService.getAllTickets();

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

		bookingService.save(tb);
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
		bookingService.save(t);
		return null;
	}

}
