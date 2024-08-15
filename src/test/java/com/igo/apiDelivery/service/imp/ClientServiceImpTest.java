package com.igo.apiDelivery.service.imp;

import com.igo.apiDelivery.dto.ClientDTO;
import com.igo.apiDelivery.dto.mapper.ClientMapper;
import com.igo.apiDelivery.exception.RecordNotFoundException;
import com.igo.apiDelivery.model.Client;
import com.igo.apiDelivery.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientServiceImpTest {

    @InjectMocks
    private ClientServiceImp clientServiceImp;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    private Client client;
    private ClientDTO clientDTO;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startClient();

    }

    @Test
    void insertClient() {
    }

    @Test
    void findAllClients() {
    }

    @Test
    void findByIdClient() {
        Mockito.when(clientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(client));
        Mockito.when(clientMapper.toDto(client)).thenReturn(clientDTO);

        ClientDTO foundClient = clientServiceImp.findByIdClient(1L);


    }

    @Test
    void findByIdClient_NotFound() {
        Mockito.when(clientRepository.findById(2L)).thenReturn(Optional.empty());

        RecordNotFoundException exception = assertThrows(RecordNotFoundException.class, () -> {
            clientServiceImp.findByIdClient(2L);
        });

        assertEquals("Registro não encontrado com o id: 2", exception.getMessage());
    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClient() {
    }

    private void startClient() {
        client = new Client(1L, "camila", "camila@gmail.com", null, null);
        clientDTO = new ClientDTO(1L, "camila", "camila@gmail.com", null, null);
    }

}