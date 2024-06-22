package com.rasoolghafari.bankingapplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rasoolghafari.bankingapplication.controllers.LegalCustomerController;
import com.rasoolghafari.bankingapplication.dto.LegalCustomerDTO;
import com.rasoolghafari.bankingapplication.service.LegalCustomerService;
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
public class LegalCustomerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private LegalCustomerController customerController;

    @Mock
    private LegalCustomerService customerService;

    @Test
    public void testCreateCustomer() throws Exception {
        LegalCustomerDTO customerDTO = new LegalCustomerDTO(1L, "+989371234567", "Rasool", "Ghafari");

        when(customerService.createCustomer(any(LegalCustomerDTO.class))).thenReturn(customerDTO);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/legal-customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(customerDTO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value(customerDTO.getId()))
                .andExpect(jsonPath("$.name").value(customerDTO.getName()))
                .andExpect(jsonPath("$.phoneNumber").value(customerDTO.getPhoneNumber()))
                .andExpect(jsonPath("$.customerType").value("LEGAL"));

        verify(customerService, times(1)).createCustomer(any(LegalCustomerDTO.class));
    }

    @Test
    public void testGetCustomerById() throws Exception {
        LegalCustomerDTO customerDTO = new LegalCustomerDTO(1L, "+989371234567", "Rasool", "Ghafari");

        when(customerService.find(eq(1L))).thenReturn(customerDTO);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/legal-customers/find/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").value(customerDTO.getId()))
                .andExpect(jsonPath("$.name").value(customerDTO.getName()))
                .andExpect(jsonPath("$.phoneNumber").value(customerDTO.getPhoneNumber()))
                .andExpect(jsonPath("$.customerType").value("LEGAL"));

        verify(customerService, times(1)).find(eq(1L));
    }

    private String asJsonString(Object obj) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }
}