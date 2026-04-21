package com.example.sample.service;

import com.example.sample.domain.Item;
import com.example.sample.dto.ItemRequest;
import com.example.sample.dto.ItemResponse;
import com.example.sample.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    // 전체 조회
    public List<ItemResponse> findAll() {
        return itemRepository.findAll()
                .stream()
                .map(ItemResponse::new)
                .collect(Collectors.toList());
    }

    // 단건 조회
    public ItemResponse findById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 항목입니다. id=" + id));
        return new ItemResponse(item);
    }

    // 생성
    @Transactional
    public ItemResponse create(ItemRequest request) {
        Item item = Item.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        return new ItemResponse(itemRepository.save(item));
    }

    // 수정
    @Transactional
    public ItemResponse update(Long id, ItemRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 항목입니다. id=" + id));
        item.update(request.getName(), request.getDescription(), request.getPrice());
        return new ItemResponse(item);
    }

    // 삭제
    @Transactional
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
