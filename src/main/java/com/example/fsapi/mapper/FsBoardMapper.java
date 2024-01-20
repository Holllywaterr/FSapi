package com.example.fsapi.mapper;

import com.example.fsapi.dto.FsBoardDto;

import java.util.List;

public interface FsBoardMapper {
    FsBoardDto.FsBoardSelectDto detail(String id);
    List<FsBoardDto.FsBoardSelectDto> list(FsBoardDto.FsBoardListDto params);
    List<FsBoardDto.FsBoardSelectDto> moreList(FsBoardDto.FsBoardMoreListDto params);
    List<FsBoardDto.FsBoardSelectDto> pagedList(FsBoardDto.FsBoardPagedListDto params);
    int pagedListCount(FsBoardDto.FsBoardPagedListDto params);
}
