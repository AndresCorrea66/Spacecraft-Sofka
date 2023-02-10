package com.nasa.spacecraft.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nasa.spacecraft.domain.*;
import com.nasa.spacecraft.factory.SpacecraftType;
import com.nasa.spacecraft.service.SpacecraftService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = SpacecraftController.class)
public class SpacecraftControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpacecraftService spacecraftService;

    @Test
    public void testAddSpacecraft() throws Exception {
        AddSpacecraftDTO addSpacecraftDTO = new AddSpacecraftDTO("SPACE_PROBE");
        Spacecraft spacecraft = new SpaceProbe();

        when(spacecraftService.addSpacecraft(SpacecraftType.SPACE_PROBE)).thenReturn(spacecraft);

        mockMvc.perform(post("/spacecrafts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(addSpacecraftDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().json(toJson(spacecraft)));

        verify(spacecraftService, times(1)).addSpacecraft(SpacecraftType.SPACE_PROBE);
    }

    @Test
    public void testSearchSpacecraft() throws Exception {
        List<Spacecraft> spacecrafts = new ArrayList<>();
        spacecrafts.add(new MannedSpacecraft());
        when(spacecraftService.searchSpacecraft("keywords")).thenReturn(spacecrafts);

        mockMvc.perform(get("/spacecrafts/search?keywords=keywords"))
                .andExpect(status().isOk())
                .andExpect(content().json(toJson(spacecrafts)));

        verify(spacecraftService, times(1)).searchSpacecraft("keywords");
    }

    @Test
    public void testSearchMaxSpeedBetween() throws Exception {
        List<Spacecraft> spacecrafts = new ArrayList<>();
        spacecrafts.add(new SpaceProbe());
        when(spacecraftService.searchMaxSpeedBetween(10, 20)).thenReturn(spacecrafts);

        mockMvc.perform(get("/spacecrafts/search-by-speed?minSpeed=10&maxSpeed=20"))
                .andExpect(status().isOk())
                .andExpect(content().json(toJson(spacecrafts)));

        verify(spacecraftService, times(1)).searchMaxSpeedBetween(10, 20);
    }

    @Test
    public void testFindAll() throws Exception {
        List<Spacecraft> spacecrafts = new ArrayList<>();
        spacecrafts.add(new SupplySpacecraft());
        when(spacecraftService.findAll()).thenReturn(spacecrafts);

        mockMvc.perform(get("/spacecrafts"))
                .andExpect(status().isOk())
                .andExpect(content().json(toJson(spacecrafts)));

        verify(spacecraftService, times(1)).findAll();
    }

    private String toJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }
}
