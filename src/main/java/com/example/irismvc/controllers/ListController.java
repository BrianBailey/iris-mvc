package com.example.irismvc.controllers;

import com.example.irismvc.models.FlowerData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;


@Controller
@RequestMapping(value = "list")
public class ListController {

    static HashMap<String, String> columnChoices = new HashMap<>();


    public ListController () {
        columnChoices.put("sepal_length", "Sepal_Length");
        columnChoices.put("sepal_width", "Sepal_Width");
        columnChoices.put("petal_length", "Petal_Length");
        columnChoices.put("petal_width", "Petal_Width");
        columnChoices.put("species", "Species");
        columnChoices.put("all", "All");
    }

    @RequestMapping(value = "")
    public String list(Model model) {

        model.addAttribute("columns", columnChoices);

        return "list";
    }

    @RequestMapping(value = "values")
    public String listColumnValues(Model model, @RequestParam String column) {

        if (column.equals("all")) {
            ArrayList<HashMap<String, String>> flowers = FlowerData.findAll();
            model.addAttribute("title", "All Flowers");
            model.addAttribute("flowers", flowers);
            return "list-flowers";
        } else {
            ArrayList<String> items = FlowerData.findAll(column);
            model.addAttribute("title", "All " + columnChoices.get(column) + " Values");
            model.addAttribute("column", column);
            model.addAttribute("items", items);
            return "list-column";
        }

    }

    @RequestMapping(value = "flowers")
    public String listFlowersByColumnAndValue(Model model,
                                           @RequestParam String column, @RequestParam String value) {

        ArrayList<HashMap<String, String>> flowers = FlowerData.findByColumnAndValue(column, value);
        model.addAttribute("title", "Flowers with " + columnChoices.get(column) + ": " + value);
        model.addAttribute("flowers", flowers);

        return "list-flowers";
    }
}