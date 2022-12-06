package com.railways.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import com.railways.UserDetailsCache;
import com.railways.model.Ticket;
import com.railways.model.UserDetails;
import com.railways.service.BookingService;

@Controller
public class WelcomeController {

	@Autowired
	UserDetailsCache userDetailsCache;

	@Autowired
	BookingService bser;

	@PostMapping("/welcome")
	public String welcome(String welcome, ModelMap model) {

		if (welcome != null) {

			if (welcome.equals("profile")) {

				if (userDetailsCache.getUserDetails() != null) {
					UserDetails user = userDetailsCache.getUserDetails();
					model.put("fname", user.getFname());
					model.put("lname", user.getLname());
					model.put("gender", user.getGender());
					model.put("dob", user.getDob());
					model.put("email", user.getEmail());
					model.put("city", user.getCity());
					model.put("mobile", user.getMobile());
				}

				return "profile";
			}

			else if (welcome.equals("canceltickets")) {
				List<Ticket> noOfTickets = bser.getAllTickets();

				System.out.println("no of tickets " + noOfTickets);
				if (noOfTickets != null && noOfTickets.size() > 0)
					model.put("tickets", noOfTickets);
				
				return "canceltickets";
			}
				
			else if (welcome.equals("bookedtickets")) {

				List<Ticket> noOfTickets = bser.getAllTickets();

				System.out.println("no of tickets " + noOfTickets);
				if (noOfTickets != null && noOfTickets.size() > 0)
					model.put("tickets", noOfTickets);

				return "bookedtickets";
			} else if (welcome.equals("bookticket")) {

				if (BookingService.available > 0)
					model.put("available", "Available Tickets : " + BookingService.available);
				else
					model.put("available", "No Tickets Are Available and Wating List Started ");
				return "bookticket";
			}

		}
		model.put("commonErrorMsg", "Something Problem with Site, Please try after some time");

		return "error";
	}

	@PostMapping("/backToWelcome")
	public String welcome() {

		return "welcome";
	}
}
