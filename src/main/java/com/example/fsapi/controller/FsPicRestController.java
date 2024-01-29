package com.example.fsapi.controller;

import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsPicDto;
import com.example.fsapi.service.FsPicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "1. 게시글 이미지 API 안내",
        description = "게시글 이미지 관련 기능 정의한 RestController.")
@RequestMapping("/api/fspic")
@RestController
public class FsPicRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FsPicService fsPicService;
    public FsPicRestController(FsPicService fsPicService) {
        this.fsPicService = fsPicService;
    }

    @Operation(summary = "게시글 이미지 글 등록",
            description = "게시글 이미지 신규 글 등록을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsPicCreateDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<FsPicAfterCreateDto\\> <br />"
                    + "@exception 중복 <br />"
    )
    @PostMapping("")
    public ResponseEntity<FsPicDto.FsPicAfterCreateDto> save(@Valid @RequestBody FsPicDto.FsPicCreateDto params, HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fsPicService.create(params));
    }
    @Operation(summary = "게시글 이미지 글 수정",
            description = "게시글 이미지 기존 글 수정을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsPicUpdateDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsPicAfterUpdateDto\\> <br />"
                    + "@exception 해당 자료 없음 <br />"
    )
    @PutMapping("")
    public ResponseEntity<FsPicDto.FsPicAfterUpdateDto> update(@Valid @RequestBody FsPicDto.FsPicUpdateDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(fsPicService.update(params));
    }
    @Operation(summary = "게시글 이미지 글 수정",
            description = "게시글 이미지 기존 글 수정을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsPicUpdateDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsPicAfterUpdateDto\\> <br />"
                    + "@exception 해당 자료 없음 <br />"
    )
    @DeleteMapping("")
    public ResponseEntity<FsPicDto.FsPicAfterUpdateDto> delete(@Valid @RequestBody FsPicDto.FsPicUpdateDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(fsPicService.delete(params));
    }

    @Operation(summary = "게시글 이미지 글 정보 조회",
            description = "게시글 이미지 글 1개 정보 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param id(PathVariable) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsPicSelectDto\\> <br />"
                    + "@exception 정보 없음 <br />"
    )
    @GetMapping("/{id}")
    public ResponseEntity<FsPicDto.FsPicSelectDto> detail(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(fsPicService.detail(id));
    }
    @Operation(summary = "게시글 이미지 글 정보 목록 조회(검색 기능 포함)",
            description = "게시글 이미지 글 전체 목록 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param (no parameter) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsPicSelectDto\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/list")
    public ResponseEntity<List<FsPicDto.FsPicSelectDto>> list(@Valid @RequestBody FsPicDto.FsPicListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(fsPicService.list(params));
    }
    @Operation(summary = "게시글 이미지 글 정보 추가조회 목록 조회(검색 기능 포함)",
            description = "게시글 이미지 추가 조회한 글 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsPicSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/moreList")
    public ResponseEntity<List<FsPicDto.FsPicSelectDto>> moreList(@Valid @RequestBody FsPicDto.FsPicMoreListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(fsPicService.moreList(params));
    }

    @Operation(summary = "게시글 이미지 글 정보 페이징 처리 한 목록 조회(검색 기능 포함)",
            description = "게시글 이미지 페이징 처리 한 글 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsPicSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/pagedList")
    public ResponseEntity<CommonAfterPagedListDto<FsPicDto.FsPicSelectDto>> pagedList(@Valid @RequestBody FsPicDto.FsPicPagedListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(fsPicService.pagedList(params));
    }

}
