package com.example.fsapi.service;

import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsBoardDto;

import java.util.List;

public interface FsBoardService {
    public FsBoardDto.FsBoardAfterCreateDto create(FsBoardDto.FsBoardCreateDto params);
    public FsBoardDto.FsBoardAfterUpdateDto update(FsBoardDto.FsBoardUpdateDto params);
    public FsBoardDto.FsBoardSelectDto detail(String id);
    public List<FsBoardDto.FsBoardSelectDto> list(FsBoardDto.FsBoardListDto params);
    public List<FsBoardDto.FsBoardSelectDto> moreList(FsBoardDto.FsBoardMoreListDto params);
    public CommonAfterPagedListDto<FsBoardDto.FsBoardSelectDto> pagedList(FsBoardDto.FsBoardPagedListDto params);
}
