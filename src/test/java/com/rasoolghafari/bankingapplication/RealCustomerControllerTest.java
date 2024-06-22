package com.rasoolghafari.bankingapplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rasoolghafari.bankingapplication.controllers.RealCustomerController;
import com.rasoolghafari.bankingapplication.dto.RealCustomerDTO;
import com.rasoolghafari.bankingapplication.service.RealCustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
public class RealCustomerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private RealCustomerController customerController;

    @Mock
    private RealCustomerService customerService;

    @Test
    public void testCreateCustomer() throws Exception {
        RealCustomerDTO customerDTO = new RealCustomerDTO(1L, "+989371234567", "Rasool", "Ghafari");

        when(customerService.createCustomer(any(RealCustomerDTO.class))).thenReturn(customerDTO);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/real-customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customerDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value(customerDTO.getId()))
                .andExpect(jsonPath("$.name").value(customerDTO.getName()))
                .andExpect(jsonPath("$.phoneNumber").value(customerDTO.getPhoneNumber()))
                .andExpect(jsonPath("$.customerType").value("REAL"));

        verify(customerService, times(1)).createCustomer(any(RealCustomerDTO.class));
    }

    @Test
    public void testGetCustomerById() throws Exception {
        RealCustomerDTO customerDTO = new RealCustomerDTO(1L, "+989371234567", "Rasool", "Ghafari");

        when(customerService.find(eq(1L))).thenReturn(customerDTO);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/real-customers/find/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value(customerDTO.getId()))
                .andExpect(jsonPath("$.name").value(customerDTO.getName()))
                .andExpect(jsonPath("$.phoneNumber").value(customerDTO.getPhoneNumber()))
                .andExpect(jsonPath("$.customerType").value("REAL"));

        verify(customerService, times(1)).find(eq(1L));
    }

    private String asJsonString(Object obj) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}