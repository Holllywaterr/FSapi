package com.example.fsapi.service;

import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsCmtDto;

import java.util.List;

public interface FsCmtService {

    public FsCmtDto.FsCmtAfterCreateDto create(FsCmtDto.FsCmtCreateDto params);
    public FsCmtDto.FsCmtAfterUpdateDto update(FsCmtDto.FsCmtUpdateDto params);
    public FsCmtDto.FsCmtSelectDto detail(String id);
    public List<FsCmtDto.FsCmtSelectDto> list(FsCmtDto.FsCmtListDto params);
    public List<FsCmtDto.FsCmtSelectDto> moreList(FsCmtDto.FsCmtMoreListDto params);
    public CommonAfterPagedListDto<FsCmtDto.FsCmtSelectDto> pagedList(FsCmtDto.FsCmtPagedListDto params);
}
