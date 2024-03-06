package com.proteccion.prueba.prueba.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FibonacciService {
    public String getFibonacciByTwoNumbersInit(int x, int y, int seconds) {
        if (x == 0) {
            throw new RuntimeException("Seconds are Zero");
        }
        ArrayList<Long> serie = new ArrayList<>();

        if (x > y) {
            serie.add((long) y);
            serie.add((long) x);
        } else {
            serie.add((long) x);
            serie.add((long) y);
        }

        for (int i = 0; i <= seconds + 2; i++) {
            Long s1 = serie.get(i);
            Long s2 = serie.get(i + 1);
            Long sum = s1 + s2;
            serie.add(sum);
        }

        return serie.toString();
    }
}
