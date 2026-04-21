package com.example.sample;

import com.example.sample.domain.Item;
import com.example.sample.dto.ItemRequest;
import com.example.sample.dto.ItemResponse;
import com.example.sample.repository.ItemRepository;
import com.example.sample.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("아이템 생성 테스트")
    void createItem() {
        // given
        ItemRequest request = new ItemRequest();

        // when - 리플렉션 없이 테스트하려면 RequestBuilder 패턴 권장
        // 여기서는 직접 엔티티로 테스트
        Item item = Item.builder()
                .name("테스트 아이템")
                .description("설명")
                .price(1000)
                .build();
        Item saved = itemRepository.save(item);

        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("테스트 아이템");
    }

    @Test
    @DisplayName("전체 아이템 조회 테스트")
    void findAllItems() {
        // given
        itemRepository.save(Item.builder().name("Item1").description("desc").price(100).build());
        itemRepository.save(Item.builder().name("Item2").description("desc").price(200).build());

        // when
        List<ItemResponse> result = itemService.findAll();

        // then
        assertThat(result).hasSizeGreaterThanOrEqualTo(2);
    }
}
