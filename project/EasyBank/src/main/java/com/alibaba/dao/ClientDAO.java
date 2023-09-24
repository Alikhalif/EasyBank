package com.alibaba.dao;

import com.alibaba.entities.Client;

import java.util.List;

public interface ClientDAO {
    void addClient(Client client);

    Client getClientByCode(int code);

    List<Client> getAllClients();

    void updateClient(Client client);

    void deleteClient(int code);
}
