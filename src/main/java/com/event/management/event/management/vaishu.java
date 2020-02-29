package com.event.management.event.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin

@RestController
@RequestMapping("/event")
public class vaishu {
	@GetMapping
	public String printString() {
		return " Team kxip";
	}

	@GetMapping
	@RequestMapping("/name")
	public String printStrings() {
		return "vaishu";
	}

	@GetMapping
	@RequestMapping("/details")
	public Sample returnDetails() {
		Sample sample = new Sample();
		sample.setName("vaishnavi");
		return sample;
	}

	@GetMapping
	@RequestMapping("/info")
	public Event returninfo() {
		Event sample = new Event();
		sample.setId("cse100");
		sample.setName("vaishu99");
		sample.setType("type");
		sample.setDate("feb 22");
		sample.setVenue("meglab");
		return sample;
	}

	@GetMapping
	 @RequestMapping("details/list")
	public List<Event> return2Event(){
		List<Event> e=new ArrayList<>();	
		Connection con =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventdb","root","root");
			Statement statement = con.createStatement();
			ResultSet r = statement.executeQuery("SELECT * FROM Event;");
			while(r.next()) {
				Event d=new Event();
				d.setId(r.getString("id"));
				d.setName(r.getString("name"));
				d.setType(r.getString("type"));
				d.setDate(r.getString("date"));

				d.setDate(r.getString("venue"));
				e.add(d);
			}			
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		return e;
		 
		 
		 
	 }
	@PostMapping
	public boolean addevent (@RequestBody Event event)
	{
		System.out.println(event.getName());
		return true;
	}
}
