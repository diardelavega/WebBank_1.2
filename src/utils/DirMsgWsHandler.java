package utils;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import system.DirectorQuery;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import comon.StaticVars;
import entity.Employee;
import entity.Transaction;
import functions.DirectorFunctions;

public class DirMsgWsHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(DirMsgWsHandler.class);

	public static String switchit(String msg) {
		JsonObject jobj = new Gson().fromJson(msg, JsonObject.class);
		String head = jobj.get("head").getAsString();
		DirectorFunctions df = new DirectorFunctions();
		JsonObject jo = new JsonObject();

		switch (head) {
		case "new":
			return newEmployee(df, jobj);
			// break;
		case "info":
			return employeeInfo(df, jobj);
			// break;
		case "alter":
			return alterEmployee(df, jobj);
			// break;
		case "delete":
			return deleteEmployee(df, jobj);
			// break;
		case "balance":
			return getBalance(df, jobj);
//			break;
		case "transaction":
			return getTransactions(df, jobj);
//			break;
		case "empAct":
			break;
		default:
			logger.info("invalid switch criterias");
		}

		return null;
	}

	private static String deleteEmployee(DirectorFunctions df, JsonObject jobj) {
		JsonObject jo = new JsonObject();
		int id = -1;
		try {
			String jsonId = jobj.get("id").getAsString();
			logger.info(" jobj id = {} ", jobj.get("id"));
			if (jsonId != null && !jsonId.equals("")) {
				id = jobj.get("id").getAsInt();
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("incorect id passage from jsomObj");
			jo.addProperty("head", "error");
			jo.addProperty("msg", "invalid empId");
		}

		logger.info("into variable search");
		logger.info("DATA: fname={}  lname={},  email={}", jobj.get("fname")
				.getAsString(), jobj.get("lname").getAsString(),
				jobj.get("eMail").getAsString());
		long empId = df.deleteEmployee(id);

		if (empId == StaticVars.DOES_NOT_EXISTS) {
			jo.addProperty("head", "error");
			jo.addProperty("msg", "EMPLOYEE DOES_NOT_EXISTS");
		} else if (empId == StaticVars.ERROR) {
			jo.addProperty("head", "error");
			jo.addProperty("msg", "unable to update, comit problem");
		} else {
			jo.addProperty("head", "deleteEmployee");
			jo.addProperty("newId", empId);
		}
		String jsonResp = new Gson().toJson(jo);
		logger.info("jsonResp ={}", jsonResp);
		return jsonResp;

	}

	private static String alterEmployee(DirectorFunctions df, JsonObject jobj) {
		JsonObject jo = new JsonObject();
		int id = -1;
		try {
			String jsonId = jobj.get("id").getAsString();
			logger.info(" jobj id = {} ", jobj.get("id"));
			if (jsonId != null && !jsonId.equals("")) {
				id = jobj.get("id").getAsInt();
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("incorect id passage from jsomObj");
			jo.addProperty("head", "error");
			jo.addProperty("msg", "invalid empId");
		}

		logger.info("into variable search");
		logger.info("DATA: fname={}  lname={},  email={}", jobj.get("fname")
				.getAsString(), jobj.get("lname").getAsString(),
				jobj.get("eMail").getAsString());

		String fname = jobj.get("fname").getAsString();
		String lname = jobj.get("lname").getAsString();
		String address = jobj.get("address").getAsString();
		String possition = jobj.get("possition").getAsString();
		String eMail = jobj.get("eMail").getAsString();
		String password = jobj.get("password").getAsString();

		long empId = df.alterEmployee(id, fname, lname, address, possition,
				eMail, password);
		if (empId != StaticVars.ERROR) {
			jo.addProperty("head", "alterEmployee");
			jo.addProperty("newId", empId);
		} else {
			jo.addProperty("head", "error");
			jo.addProperty("msg", "unable to update, comit problem");
		}
		String jsonResp = new Gson().toJson(jo);
		return jsonResp;

	}

	private static String newEmployee(DirectorFunctions df, JsonObject jobj) {
		// TODO call Director function and create an emp.
		JsonObject jo = new JsonObject();

		String fname = jobj.get("fname").getAsString();
		String lname = jobj.get("lname").getAsString();
		String address = jobj.get("address").getAsString();
		String possition = jobj.get("possition").getAsString();
		String eMail = jobj.get("eMail").getAsString();
		String password = jobj.get("password").getAsString();

		long newEmpId = df.createEmployee(fname, lname, address, possition,
				eMail, password);

		logger.info("new mployee id-----------------: {}", newEmpId);

		if (newEmpId == StaticVars.ERROR) {
			jo.addProperty("head", "error");
			jo.addProperty("msg", "UNABLE TP REGISTER EMPLYEE");
		}
		/*
		 * else if (newEmpId != StaticVars.DUPLICATE_ENTRY) {
		 * jo.addProperty("head", "error"); jo.addProperty("msg",
		 * "DUPLICATE EMPLOYEE ENTRY"); }
		 */
		else if (newEmpId == StaticVars.NON_UNIQUE_EMAIL) {
			jo.addProperty("head", "error");
			jo.addProperty("msg", "NON UNIQUE EMAIL");
		} else {
			jo.addProperty("head", "newEmployee");
			jo.addProperty("newId", newEmpId);
		}
		String jsonResp = new Gson().toJson(jo);
		logger.info(jsonResp);

		return jsonResp;
	}

	private static String employeeInfo(DirectorFunctions df, JsonObject jobj) {
		//
		JsonObject jo = new JsonObject();
		List<Employee> emps = new ArrayList<Employee>();
		int id = -1; // id from form or other data from form
		String jsonEmps = null;
		try {
			String jsonId = jobj.get("id").getAsString();
			logger.info(" jobj id = {} ", jobj.get("id"));
			if (jsonId != null && !jsonId.equals("")) {
				id = jobj.get("id").getAsInt();
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("incorect id passage from jsomObj");
		}

		if (id == -1) {
			logger.info("into variable search");
			logger.info("DATA: fname={}  lname={},  email={}", jobj
					.get("fname").getAsString(), jobj.get("lname")
					.getAsString(), jobj.get("eMail").getAsString());

			String fname = jobj.get("fname").getAsString();
			String lname = jobj.get("lname").getAsString();
			String address = jobj.get("address").getAsString();
			String possition = jobj.get("possition").getAsString();
			String eMail = jobj.get("eMail").getAsString();
			String password = jobj.get("password").getAsString();

			emps = df.getEmployees(fname, lname, address, possition, eMail,
					password);

			jo.addProperty("head", "empList");
			jo.add("employees", new Gson().toJsonTree(emps));
			jsonEmps = new Gson().toJson(jo);
			logger.info("JSON FORM jsonEmps ={}", jsonEmps);

		} else if (id != -1) {
			emps.add(df.getEmplyee(id));
			// emps.add(df.getEmplyee(5));
			// emps.add(df.getEmplyee(8));
			// emps.add(df.getEmplyee(2));
			jo.addProperty("head", "empList");
			jo.add("employees", new Gson().toJsonTree(emps));
			jsonEmps = new Gson().toJson(jo);
			logger.info(jsonEmps);
		}
		return jsonEmps;
	}

	private static String getBalance(DirectorFunctions df, JsonObject jobj) {

		Date fromDate = java.sql.Date.valueOf(jobj.get("date1").getAsString());
		Date toDate = null;
		try {
			if (jobj.has("date2"))
				toDate = java.sql.Date.valueOf(jobj.get("date2").getAsString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonObject jo = new JsonObject();
		List<Object[]> list = df.getBalance(fromDate, toDate);

		jo.addProperty("head", "balance");
		jo.add("balist", new Gson().toJsonTree(list));
		String jsonResp = new Gson().toJson(jo);
		logger.info(jsonResp);
		// TODO check values
		return jsonResp;

	}

	private static String getTransactions(DirectorFunctions df, JsonObject jobj) {
		Date fromDate = java.sql.Date.valueOf(jobj.get("date1").getAsString());
		Date toDate = null;
		try {
			if (jobj.has("date2"))
			toDate = java.sql.Date.valueOf(jobj.get("date2").getAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonObject jo = new JsonObject();
		List<Transaction> trl = df.getTransactions(fromDate, toDate);
		jo.addProperty("head", "transaction");
		jo.add("trlist", new Gson().toJsonTree(trl));
		String jsonResp = new Gson().toJson(jo);
		// TODO check values
		logger.info(jsonResp);
		return jsonResp;
	}

}
