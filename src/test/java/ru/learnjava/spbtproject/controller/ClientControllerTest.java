package ru.learnjava.spbtproject.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ru.learnjava.spbtproject.model.Client;
import ru.learnjava.spbtproject.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;


@WebMvcTest(controllers = ClientController.class)
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    private List<Client> clientList;

    @BeforeEach
    void setUp(){
        this.clientList = new ArrayList<>();
        this.clientList.add(new Client("FirstFuckingClient", "Прайм", 100.2));
        this.clientList.add(new Client("SecondFuckingClient", "Прайм", 200.2));
    }

    @Test
    void shouldFinfAllClieents() throws Exception{
        given(clientService.getClientList()).willReturn(clientList);

        mockMvc.perform(get("/api/v1/client/get-list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(clientList.size())));
    }

    @Test
    void shouldGetClientById() throws Exception {
        final Long clientID = 1L;
        final Client client = new Client(1L, "ThridFuckingClient", "Масс", 500.2);

        given(clientService.getClientById(clientID)).willReturn(Optional.of(client));

        this.mockMvc.perform(get("/api/v1/client/get-by-id/{id}", clientID))

                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(client.getId())));

    }

    @Test
    @Disabled
    void createClient() {
    }

    @Test
    @Disabled
    void deleteClient() {
    }

    @Test
    @Disabled
    void updateClient() {
    }
}