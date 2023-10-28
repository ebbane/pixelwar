package dev.project.pixelwar.service;

import dev.project.pixelwar.mapper.PixelMapper;
import dev.project.pixelwar.model.PixelFront;
import dev.project.pixelwar.model.PixelMb;
import dev.project.pixelwar.model.PixelMessageFront;
import dev.project.pixelwar.repository.PixelRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PixelwarService {

  private final PixelRepository pixelRepository;
  private final PixelMapper pixelMapper;

  public PixelwarService(PixelRepository pixelRepository, PixelMapper pixelMapper) {
    this.pixelRepository = pixelRepository;
    this.pixelMapper = pixelMapper;
  }

  public void savePixel(PixelMessageFront pixelMessageFront) {
    PixelMb pixelMb = pixelMapper.pixelMessageFrontToPixelMb(pixelMessageFront);
    pixelRepository.savePixel(pixelMb);
  }

  public List<PixelFront> getPixels() {
    return pixelMapper.pixelMbListToFront(pixelRepository.getPixels());
  }
}
