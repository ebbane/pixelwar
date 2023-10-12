package dev.project.pixelwar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.project.pixelwar.mapper.PixelMapper;
import dev.project.pixelwar.model.PixelFront;
import dev.project.pixelwar.model.PixelMb;
import dev.project.pixelwar.model.PixelMessageFront;
import dev.project.pixelwar.repository.PixelRepository;
import java.util.List;
import org.instancio.Instancio;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class, InstancioExtension.class})
class PixelwarServiceTest {

  @Mock
  private PixelRepository pixelRepository;

  @Mock
  private PixelMapper pixelMapper;

  private PixelwarService pixelwarService;

  @BeforeEach
  void beforeEach() {
    pixelwarService = new PixelwarService(pixelRepository, pixelMapper);
  }

  @Test
  void savePixel_nominal_insert() {
    //GIVEN
    PixelMessageFront pixelMessageFront = Instancio.create(PixelMessageFront.class);
    PixelMb pixelMb = Instancio.create(PixelMb.class);
    when(pixelMapper.pixelMessageFrontToPixelMb(pixelMessageFront)).thenReturn(pixelMb);
    doNothing().when(pixelRepository).savePixel(pixelMb);

    //WHEN
    pixelwarService.savePixel(pixelMessageFront);

    //THEN
    verify(pixelMapper).pixelMessageFrontToPixelMb(pixelMessageFront);
    verify(pixelRepository).savePixel(pixelMb);
  }

  @Test
  void getPixels_nominal_expectedList() {
    //GIVEN
    List<PixelMb> pixelMbList = Instancio.ofList(PixelMb.class).size(3).create();
    when(pixelRepository.getPixels()).thenReturn(pixelMbList);
    List<PixelFront> pixelFrontList = Instancio.ofList(PixelFront.class).size(3).create();
    when(pixelMapper.pixelMbListToFront(pixelMbList)).thenReturn(pixelFrontList);

    //WHEN
    var actual = pixelwarService.getPixels();

    //THEN
    verify(pixelMapper).pixelMbListToFront(pixelMbList);
    verify(pixelRepository).getPixels();
    assertThat(actual).isEqualTo(pixelFrontList);
  }
}