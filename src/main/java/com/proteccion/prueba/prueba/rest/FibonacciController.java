package com.proteccion.prueba.prueba.rest;


import com.proteccion.prueba.prueba.rest.model.FibonacciDTO;
import com.proteccion.prueba.prueba.service.FibonacciService;
import com.proteccion.prueba.prueba.service.SendEmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/fibonacci")
public class FibonacciController {

    private final SendEmailService sendEmailService;
    private final FibonacciService fibonacciService;

    @GetMapping()
    public FibonacciDTO getFibonacci() {
        // Get Time to show
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(new Date());

        // get time to manage varible to fibonacci method
        LocalDateTime locaDate = LocalDateTime.now();
        int minutes = locaDate.getMinute();
        int seconds = locaDate.getSecond();

        // Prepare data to fibonacci method
        String minutesToString = Integer.toString(minutes);
        int x = Character.getNumericValue(minutesToString.charAt(0));
        int y = (minutesToString.length() > 1) ? Character.getNumericValue(minutesToString.charAt(1)) : 0;

        // call the fibonacci method
        var fibonacciArray = fibonacciService.getFibonacciByTwoNumbersInit(x, y, seconds);

        // Send Email
        sendEmailService.sendEmail("didier.correa@proteccion.com.co", "Prueba Técnica - Victor Manuel Zabala Garcia", "Hora: " + date + ", \r\n Serie Fibonacci: " + fibonacciArray);
        sendEmailService.sendEmail("correalondon@gmail.com", "Prueba Técnica - Victor Manuel Zabala Garcia", "Hora: " + date + ", \r\n Serie Fibonacci: " + fibonacciArray);

        // Create response to client
        var fibonacciResponse = new FibonacciDTO();
        fibonacciResponse.setHora(date);
        fibonacciResponse.setSerieFibonacci(fibonacciArray);

        return fibonacciResponse;
    }
}
