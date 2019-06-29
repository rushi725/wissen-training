package com.example.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Transaction;
import com.example.repository.TxnRepository;
import com.example.service.TxrService;

@Controller
public class TxrController {

	@Autowired
	private TxrService txrService;
	
	@Autowired
	private TxnRepository txnRepository;

	@RequestMapping(value = "txr.htm", method = RequestMethod.GET)
	public String showTxrForm() {
		// ..
		return "txr-form";
	}
	
	@RequestMapping(value = "txrlist.htm", method = RequestMethod.GET)
	public String showTxrList() {
		// ..
		return "txr-details";
	}

	@RequestMapping(value = "txr.htm", method = RequestMethod.POST)
	public String doTxr(@ModelAttribute TxrRequest request,Model model) {
		boolean b = txrService.transfer(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
		TxrResponse response = new TxrResponse();
		response.setMessage(b ? "Txr Successfull" : "Txr Failed");
		model.addAttribute("status", response);
		return "txr-status";
	}
	
	@RequestMapping(value = "txrlist.htm", method = RequestMethod.POST)
	public String doTxrList(HttpServletRequest req,Model model) {
		List<Transaction> txrList = txnRepository.findByAccount(req.getParameter("accountnumber"));
		model.addAttribute("txrs", txrList);
		return "txr-list";
	}
	
	

}