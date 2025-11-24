package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.CarService.CarService;



@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarService carServiceImpl;

    @Autowired
    public CarsController(CarService carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }


    @GetMapping
    public String printSomeCar(@RequestParam(required = false) String count, ModelMap model) {
        if (count == null) {
            model.addAttribute("cars", carServiceImpl.getCars(0));
        } else {
            model.addAttribute("cars", carServiceImpl.getCars(Integer.parseInt(count)));
        }
        return "cars";
    }
}