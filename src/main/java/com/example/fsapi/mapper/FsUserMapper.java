package com.example.fsapi.mapper;

import com.example.fsapi.dto.FsUserDto;

import java.util.List;

public interface FsUserMapper {

    FsUserDto.FsUserSelectDto detail(String id);
    List<FsUserDto.FsUserSelectDto> list(FsUserDto.FsUserListDto params);
    List<FsUserDto.FsUserSelectDto> moreList(FsUserDto.FsUserMoreListDto params);
    List<FsUserDto.FsUserSelectDto> pagedList(FsUserDto.FsUserPagedListDto params);
    int pagedListCount(FsUserDto.FsUserPagedListDto params);
}
