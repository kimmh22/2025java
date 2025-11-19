package com.study.spring.bbs;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class BbsController {

    private final BbsRepository bbsRepository;

    @GetMapping("/")
    public String root() {
        return "hi";
    }

    /**
     * 목록 + 검색 + 페이지네이션
     * - page: 0부터 시작(프론트가 1부터 보낼 경우 page-1 해서 넘겨줘)
     * - size: 페이지당 개수
     * - title/name: 부분 검색(둘 다 비어있으면 전체 조회)
     */
    @GetMapping("/api/bbs")
    public ResponseEntity<Page<Bbs>> bbsList(
            @RequestParam(name = "title", defaultValue = "") String title,
            @RequestParam(name = "name",  defaultValue = "") String name,
            @RequestParam(name = "size",  defaultValue = "5") int size,
            @RequestParam(name = "page",  defaultValue = "0") int page
    ) {
        // size, page 방어코드
        if (size <= 0) size = 5;
        if (page < 0)  page = 0;

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));

        Page<Bbs> result;
        if (title.isBlank() && name.isBlank()) {
            result = bbsRepository.findAll(pageable);
        } else {
            result = bbsRepository.findByTitleContainingIgnoreCaseOrNameContainingIgnoreCase(
                    title, name, pageable
            );
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/api/bbs/{id}")
    public ResponseEntity<Optional<Bbs>> bbsView(@PathVariable("id") Long id) {
        return ResponseEntity.ok(bbsRepository.findById(id));
    }

    @PostMapping("/api/bbs")
    public ResponseEntity<Bbs> bbsCreate(@RequestBody BbsDto req) {
        Bbs bbs = Bbs.builder()
                .name(req.getName())
                .title(req.getTitle())
                .content(req.getContent())
                .build();
        return ResponseEntity.ok(bbsRepository.save(bbs));
    }

    @PutMapping("/api/bbs/{id}")
    public ResponseEntity<?> bbsUpdate(
            @PathVariable("id") Long id,
            @RequestBody BbsDto req
    ) {
        Optional<Bbs> view = bbsRepository.findById(id);
        log.info("정보확인 {}", view);

        if (view.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Bbs entity = view.get();
        entity.setName(req.getName());
        entity.setTitle(req.getTitle());
        entity.setContent(req.getContent());
        bbsRepository.save(entity);

        return ResponseEntity.ok("수정완료");
    }

    @DeleteMapping("/api/bbs/{id}")
    public ResponseEntity<?> bbsDelete(@PathVariable("id") Long id) {
        if (!bbsRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bbsRepository.deleteById(id);
        return ResponseEntity.ok("삭제완료");
    }
}
