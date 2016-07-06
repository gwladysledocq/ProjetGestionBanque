package com.groupe1.adaming.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.groupe1.adaming.entities.Client;
import com.groupe1.adaming.entities.Compte;
import com.groupe1.adaming.entities.Employe;
import com.groupe1.adaming.model.OperationModel;

@Controller
public class HomeCtrl {

	@RequestMapping(value="/home")
	public String indexHome(OperationModel operationModel, Model model){
		return "home";
	}
	
}
