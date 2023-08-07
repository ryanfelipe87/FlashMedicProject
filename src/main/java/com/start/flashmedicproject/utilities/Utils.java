package com.start.flashmedicproject.utilities;

import java.util.Random;

public class Utils {

    //Lógica em que gera as fichas aleatoriamente
    public static String generateNextFicha(){
        Random random = new Random();
        int numeroAleatorio = 100_000 + random.nextInt(900_000);
        return String.valueOf(numeroAleatorio);
    }
}
