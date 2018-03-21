package com.example.irismvc.controllers;

import com.example.irismvc.models.FlowerData;
import com.example.irismvc.models.FlowerData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.directory.Attribute;
import java.util.ArrayList;
import java.util.HashMap;




/**
 * Created by Brian Bailey
 */

@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value="results")
    public String search(Model model,
                         @RequestParam String searchType,
                         @RequestParam String searchTerm){
        ArrayList<HashMap<String, String>> flowers;
        if(searchType.equals("all")){
            flowers = FlowerData.findByValue(searchTerm);
        }
        else {
            flowers = FlowerData.findByColumnAndValue(searchType, searchTerm);
        }

        model.addAttribute("flowers", flowers);
        model.addAttribute("columns", ListController.columnChoices);
        return "search";

    }


}

