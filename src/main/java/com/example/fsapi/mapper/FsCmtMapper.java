package com.example.fsapi.mapper;

import com.example.fsapi.dto.FsCmtDto;

import java.util.List;

public interface FsCmtMapper {

    FsCmtDto.FsCmtSelectDto detail(String id);
    List<FsCmtDto.FsCmtSelectDto> list(FsCmtDto.FsCmtListDto params);
    List<FsCmtDto.FsCmtSelectDto> moreList(FsCmtDto.FsCmtMoreListDto params);
    List<FsCmtDto.FsCmtSelectDto> pagedList(FsCmtDto.FsCmtPagedListDto params);
    int pagedListCount(FsCmtDto.FsCmtPagedListDto params);
}
