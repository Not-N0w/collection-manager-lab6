package com.labs.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import com.labs.client.extra.Pair;
import com.labs.common.DataContainer;
import com.labs.common.core.Ticket;


/**
 * Класс-связка клиента. Через него осуществляется вызов клиента извне, а так же запуск основного цикла приложения. 
 */
public class Client {
    /**
     * Поле с классом, отвечающим за получение данных от пользователя.
    */
    private Input input;
    
    /**
     * Поле с классом, отвечающим за вывод данных.
    */
    private Output output;


    /**
     * Поле с классом, отвечающим за обработку данных.
    */
    private DataManager dataManager;

    /**
     * Полу с экземпляром главного цикла.
     */
    private Cycle cycle;
    private Transmitter transmitter;

    public Client() {
        output = new Output();
        input = new Input(output);
        transmitter = new Transmitter();
        dataManager = new DataManager(output, transmitter);
        cycle = new Cycle(input,output,dataManager);
    }


    /**
     * Метод, осуществляющий валидацию файла коллекции, отправку этих данных на сервер, запуск главного цикла.
     */
    @SuppressWarnings("unchecked")
    public void run() {
        DataContainer response = transmitter.connect();
        output.responseOut(response);
        cycle.cycle();
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
