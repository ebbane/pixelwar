package dev.project.pixelwar.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dev.project.pixelwar.model.PixelFront;
import dev.project.pixelwar.service.PixelwarService;
import java.util.List;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PixelController.class)
@ExtendWith(InstancioExtension.class)
class PixelControllerIT {


  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private PixelwarService pixelwarService;


  @Test
  void getMapPixels_controllerCalled_expectedJson() throws Exception {
    // GIVEN
    PixelFront pixelFrontList = Instancio.create(PixelFront.class);
    when(pixelwarService.getPixels()).thenReturn(List.of(pixelFrontList));

    // WHEN
    this.mockMvc.perform(get("/pixel").accept(MediaType.APPLICATION_JSON_VALUE))
        .andDo(print())
        // THEN
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$.[0].x").value(pixelFrontList.x()))
        .andExpect(jsonPath("$.[0].y").value(pixelFrontList.y()))
        .andExpect(jsonPath("$.[0].color").value(pixelFrontList.color()))
        .andReturn();
  }

}