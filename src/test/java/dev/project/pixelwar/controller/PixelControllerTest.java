package dev.project.pixelwar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import dev.project.pixelwar.model.PixelFront;
import dev.project.pixelwar.service.PixelwarService;
import java.util.List;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.instancio.junit.Seed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

@ExtendWith(InstancioExtension.class)
class PixelControllerTest {

  private PixelwarService pixelwarService;
  private PixelController pixelController;


  @BeforeEach
  void beforeEach() {
    pixelwarService = Mockito.mock(PixelwarService.class);
    pixelController = new PixelController(pixelwarService);
  }

  @Test
  @Seed(3)
  void getMapPixels_nominal_callService() {
    //GIVEN
    List<PixelFront> pixelFrontList = Instancio.ofList(PixelFront.class).size(3).create();
    when(pixelwarService.getPixels()).thenReturn(pixelFrontList);

    //WHEN
    List<PixelFront> actual = pixelController.getMapPixels();

    //THEN
    assertThat(actual).containsExactlyElementsOf(pixelFrontList);
  }
}
