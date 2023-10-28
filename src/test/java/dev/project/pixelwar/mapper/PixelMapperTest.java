package dev.project.pixelwar.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import dev.project.pixelwar.model.PixelMb;
import dev.project.pixelwar.model.PixelMessageFront;
import java.util.List;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PixelMapperTest {

  private PixelMapper pixelMapper;

  @BeforeEach
  void beforeEach() {
    pixelMapper = new PixelMapperImpl();
  }

  @Test
  void pixelMessageFrontToPixelMb_nominal_expectedObject() {
    //GIVEN
    PixelMessageFront given = Instancio.create(PixelMessageFront.class);

    //WHEN
    var actual = pixelMapper.pixelMessageFrontToPixelMb(given);

    //THEN
    assertThat(actual)
        .isNotNull()
        .satisfies(res -> {
          assertThat(res.getX()).isEqualTo(given.x());
          assertThat(res.getY()).isEqualTo(given.y());
          assertThat(res.getColor()).isEqualTo(given.color());
          assertThat(res.getUser()).isEqualTo(given.user());
        });

  }

  @Test
  void pixelMbListToFront_nominal_expectedObject() {
    //GIVEN
    List<PixelMb> given = Instancio.ofList(PixelMb.class).size(3).create();

    //WHEN
    var actual = pixelMapper.pixelMbListToFront(given);

    //THEN
    assertThat(actual).hasSize(3)
        .anySatisfy(res -> {
          assertThat(res.x()).isEqualTo(given.get(0).getX());
          assertThat(res.y()).isEqualTo(given.get(0).getY());
          assertThat(res.color()).isEqualTo(given.get(0).getColor());
        })
        .anySatisfy(res -> {
          assertThat(res.x()).isEqualTo(given.get(1).getX());
          assertThat(res.y()).isEqualTo(given.get(1).getY());
          assertThat(res.color()).isEqualTo(given.get(1).getColor());
        })
        .anySatisfy(res -> {
          assertThat(res.x()).isEqualTo(given.get(2).getX());
          assertThat(res.y()).isEqualTo(given.get(2).getY());
          assertThat(res.color()).isEqualTo(given.get(2).getColor());
        });

  }
}