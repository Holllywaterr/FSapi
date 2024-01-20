package com.example.fsapi.controller;

import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsUserDto;
import com.example.fsapi.service.FsUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "1. 회원 API 안내",
        description = "회원 관련 기능 정의한 RestController.")
@RequestMapping("/api/fsuser")
@RestController
public class FsUserRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FsUserService FsUserService;

    public FsUserRestController(FsUserService FsUserService) {
        this.FsUserService = FsUserService;
    }

    @Operation(summary = "회원 정보 등록",
            description = "회원 신규 정보 등록을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsUserCreateDto <br />"
                    + "@return HttpStatus.CREATED(201) ResponseEntity\\<FsUserAfterCreateDto\\> <br />"
                    + "@exception 중복 <br />"
    )
    @PostMapping("")
    public ResponseEntity<FsUserDto.FsUserAfterCreateDto> save(@Valid @RequestBody FsUserDto.FsUserCreateDto params) {
        return ResponseEntity.status(HttpStatus.CREATED).body(FsUserService.create(params));
    }
    @Operation(summary = "회원 정보 수정",
            description = "회원 기존 정보 수정을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsUserUpdateDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsUserAfterUpdateDto\\> <br />"
                    + "@exception 해당 자료 없음 <br />"
    )
    @PutMapping("")
    public ResponseEntity<FsUserDto.FsUserAfterUpdateDto> update(@Valid @RequestBody FsUserDto.FsUserUpdateDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsUserService.update(params));
    }

    @Operation(summary = "회원 정보 조회",
            description = "회원 정보 1개 정보 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param id(PathVariable) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsUserSelectDto\\> <br />"
                    + "@exception 정보 없음 <br />"
    )
    @GetMapping("/{id}")
    public ResponseEntity<FsUserDto.FsUserSelectDto> detail(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(FsUserService.detail(id));
    }
    @Operation(summary = "회원 정보 목록 조회(검색 기능 포함)",
            description = "회원 정보 전체 목록 조회를 위한 컨트롤러 (모두 접근 가능) <br />"
                    + "@param (no parameter) <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<FsUserSelectDto\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/list")
    public ResponseEntity<List<FsUserDto.FsUserSelectDto>> list(@Valid @RequestBody FsUserDto.FsUserListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsUserService.list(params));
    }
    @Operation(summary = "회원 정보 추가조회 목록 조회(검색 기능 포함)",
            description = "회원 추가 조회한 정보 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsUserSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/moreList")
    public ResponseEntity<List<FsUserDto.FsUserSelectDto>> moreList(@Valid @RequestBody FsUserDto.FsUserMoreListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsUserService.moreList(params));
    }

    @Operation(summary = "회원 정보 페이징 처리 한 목록 조회(검색 기능 포함)",
            description = "회원 페이징 처리 한 정보 검색을 위한 컨트롤러 (누구나 접근 가능) <br />"
                    + "@param FsUserSearchDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<Map<String, Object>\\> <br />"
                    + "@exception (no Exception) <br />"
    )
    @PostMapping("/pagedList")
    public ResponseEntity<CommonAfterPagedListDto<FsUserDto.FsUserSelectDto>> pagedList(@Valid @RequestBody FsUserDto.FsUserPagedListDto params) {
        return ResponseEntity.status(HttpStatus.OK).body(FsUserService.pagedList(params));
    }

}

