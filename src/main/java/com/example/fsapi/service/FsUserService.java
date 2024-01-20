package com.example.fsapi.service;

import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsUserDto;

import java.util.List;

public interface FsUserService {

    public FsUserDto.FsUserAfterCreateDto create(FsUserDto.FsUserCreateDto params);
    public FsUserDto.FsUserAfterUpdateDto update(FsUserDto.FsUserUpdateDto params);
    public FsUserDto.FsUserSelectDto detail(String id);
    public List<FsUserDto.FsUserSelectDto> list(FsUserDto.FsUserListDto params);
    public List<FsUserDto.FsUserSelectDto> moreList(FsUserDto.FsUserMoreListDto params);
    public CommonAfterPagedListDto<FsUserDto.FsUserSelectDto> pagedList(FsUserDto.FsUserPagedListDto params);
}
