package com.start.flashmedicproject.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class FichaAtendimentoService {

    public List<Integer> fichas = new ArrayList<>();
    private int nextNumber = 1;
    private Random random = new Random();

    //Método para gerar um número de ficha aleatório
    private int generateNumberFicha(){
        return random.nextInt(1000) + 1; //Números aleatórios de 1 a 1000
    }

    //Método para gerar a próxima ficha de atendimento ordenada
    public synchronized int generateNextFicha(){
        int numFicha = generateNumberFicha();
        while(fichas.contains(numFicha)){
            numFicha = generateNumberFicha();
        }
        fichas.add(numFicha);
        Collections.sort(fichas);
        return numFicha;
    }

    //Método para obter a próxima ficha de atendimento sem gerá-la
    public synchronized int obterNextFicha(){
        if(fichas.isEmpty()){
            return 1; //Caso não haja fichas, retorna a ficha 1 como padrão
        }
        return fichas.get(0);
    }

    //Método para remover a ficha de atendimento atual
    public synchronized void deleteFichaAtual(){
        if(!fichas.isEmpty()){
            fichas.remove(0);
        }
    }
}
