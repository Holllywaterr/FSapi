package com.example.fsapi.controller;

import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsBoardDto;
import com.example.fsapi.service.FsBoardService;
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

@Tag(name = "1. 게시판 API 안내",
        description = "게시판 관련 기능 정의한 RestController.")
@RequestMapping("/api/fsboard")
@RestController
public class FsBoardRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FsBoardService FsBoardService;
    public FsBoardRestController(FsBoardService FsBoardService) {
        this.FsBoardService = FsBoardService;
    }

    @Operation(summary = "게시판 글 등록",
            description = "게시판 신규 글 등록을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsBoardCreateDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<FsBoardAfterCreateDto\\> <br />"
                    + "@exception 중복 <br />"
    )
    @PostMapping("")
    public ResponseEntity<FsBoardDto.FsBoardAfterCreateDto> save(@Valid @RequestBody FsBoardDto.FsBoardCreateDto params, HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.CREATED).body(FsBoardService.create(params));
    }
    @Operation(summary = "게시판 글 수정",
            description = "게시판 기존 글 수정을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsBoardUpdateDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsBoardAfterUpdateDto\\> <br />"
                    + "@exception 해당 자료 없음 <br />"
    )
    @PutMapping("")
    public ResponseEntity<FsBoardDto.FsBoardAfterUpdateDto> update(@Valid @RequestBody FsBoardDto.FsBoardUpdateDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsBoardService.update(params));
    }

    @Operation(summary = "게시판 글 정보 조회",
            description = "게시판 글 1개 정보 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param id(PathVariable) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsBoardSelectDto\\> <br />"
                    + "@exception 정보 없음 <br />"
    )
    @GetMapping("/{id}")
    public ResponseEntity<FsBoardDto.FsBoardSelectDto> detail(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(FsBoardService.detail(id));
    }
    @Operation(summary = "게시판 글 정보 목록 조회(검색 기능 포함)",
            description = "게시판 글 전체 목록 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param (no parameter) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsBoardSelectDto\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/list")
    public ResponseEntity<List<FsBoardDto.FsBoardSelectDto>> list(@Valid @RequestBody FsBoardDto.FsBoardListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsBoardService.list(params));
    }
    @Operation(summary = "게시판 글 정보 추가조회 목록 조회(검색 기능 포함)",
            description = "게시판 추가 조회한 글 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsBoardSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/moreList")
    public ResponseEntity<List<FsBoardDto.FsBoardSelectDto>> moreList(@Valid @RequestBody FsBoardDto.FsBoardMoreListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsBoardService.moreList(params));
    }

    @Operation(summary = "게시판 글 정보 페이징 처리 한 목록 조회(검색 기능 포함)",
            description = "게시판 페이징 처리 한 글 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsBoardSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/pagedList")
    public ResponseEntity<CommonAfterPagedListDto<FsBoardDto.FsBoardSelectDto>> pagedList(@Valid @RequestBody FsBoardDto.FsBoardPagedListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsBoardService.pagedList(params));
    }

}
