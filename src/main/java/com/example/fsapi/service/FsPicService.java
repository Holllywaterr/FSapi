package com.example.fsapi.service;

import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsPicDto;

import java.util.List;

public interface FsPicService {

    FsPicDto.FsPicAfterCreateDto create(FsPicDto.FsPicCreateDto params);
    public FsPicDto.FsPicAfterUpdateDto update(FsPicDto.FsPicUpdateDto params);
    public FsPicDto.FsPicAfterUpdateDto delete(FsPicDto.FsPicUpdateDto params);
    public FsPicDto.FsPicSelectDto detail(String id);
    public List<FsPicDto.FsPicSelectDto> list(FsPicDto.FsPicListDto params);
    public List<FsPicDto.FsPicSelectDto> moreList(FsPicDto.FsPicMoreListDto params);
    public CommonAfterPagedListDto<FsPicDto.FsPicSelectDto> pagedList(FsPicDto.FsPicPagedListDto params);
}
