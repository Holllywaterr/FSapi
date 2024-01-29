package com.example.fsapi.controller;

import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsCmtDto;
import com.example.fsapi.service.FsCmtService;
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

@Tag(name = "1. 댓글 API 안내",
        description = "댓글 관련 기능 정의한 RestController.")
@RequestMapping("/api/fscmt")
@RestController
public class FsCmtRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FsCmtService FsCmtService;
    public FsCmtRestController(FsCmtService FsCmtService) {
        this.FsCmtService = FsCmtService;
    }

    @Operation(summary = "댓글 글 등록",
            description = "댓글 신규 글 등록을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsCmtCreateDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<FsCmtAfterCreateDto\\> <br />"
                    + "@exception 중복 <br />"
    )
    @PostMapping("")
    public ResponseEntity<FsCmtDto.FsCmtAfterCreateDto> save(@Valid @RequestBody FsCmtDto.FsCmtCreateDto params, HttpServletRequest request, HttpServletResponse response) {
        /*logger.info("Ctrl- / test_auth : " + request.getAttribute("test_auth"));
        logger.info("Ctrl- / test_header : " + response.getHeader("test_header"));
        request.setAttribute("test_auth_1", "1Y");
        response.setHeader("test_header_1", "1!");*/
        return ResponseEntity.status(HttpStatus.CREATED).body(FsCmtService.create(params));
    }
    @Operation(summary = "댓글 글 수정",
            description = "댓글 기존 글 수정을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsCmtUpdateDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsCmtAfterUpdateDto\\> <br />"
                    + "@exception 해당 자료 없음 <br />"
    )
    @PutMapping("")
    public ResponseEntity<FsCmtDto.FsCmtAfterUpdateDto> update(@Valid @RequestBody FsCmtDto.FsCmtUpdateDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsCmtService.update(params));
    }

    @Operation(summary = "댓글 글 정보 조회",
            description = "댓글 글 1개 정보 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param id(PathVariable) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsCmtSelectDto\\> <br />"
                    + "@exception 정보 없음 <br />"
    )
    @GetMapping("/{id}")
    public ResponseEntity<FsCmtDto.FsCmtSelectDto> detail(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(FsCmtService.detail(id));
    }
    @Operation(summary = "댓글 글 정보 목록 조회(검색 기능 포함)",
            description = "댓글 글 전체 목록 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param (no parameter) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsCmtSelectDto\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/list")
    public ResponseEntity<List<FsCmtDto.FsCmtSelectDto>> list(@Valid @RequestBody FsCmtDto.FsCmtListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsCmtService.list(params));
    }
    @Operation(summary = "댓글 글 정보 추가조회 목록 조회(검색 기능 포함)",
            description = "댓글 추가 조회한 글 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsCmtSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/moreList")
    public ResponseEntity<List<FsCmtDto.FsCmtSelectDto>> moreList(@Valid @RequestBody FsCmtDto.FsCmtMoreListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsCmtService.moreList(params));
    }

    @Operation(summary = "댓글 글 정보 페이징 처리 한 목록 조회(검색 기능 포함)",
            description = "댓글 페이징 처리 한 글 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsCmtSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/pagedList")
    public ResponseEntity<CommonAfterPagedListDto<FsCmtDto.FsCmtSelectDto>> pagedList(@Valid @RequestBody FsCmtDto.FsCmtPagedListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsCmtService.pagedList(params));
    }

}
