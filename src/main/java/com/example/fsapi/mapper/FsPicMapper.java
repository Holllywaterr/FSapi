package com.example.fsapi.mapper;

import com.example.fsapi.dto.FsPicDto;

import java.util.List;

public interface FsPicMapper {

    FsPicDto.FsPicSelectDto detail(String id);
    List<FsPicDto.FsPicSelectDto> list(FsPicDto.FsPicListDto params);
    List<FsPicDto.FsPicSelectDto> moreList(FsPicDto.FsPicMoreListDto params);
    List<FsPicDto.FsPicSelectDto> pagedList(FsPicDto.FsPicPagedListDto params);
    int pagedListCount(FsPicDto.FsPicPagedListDto params);
}
