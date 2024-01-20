package com.example.fsapi.service.impl;

import com.example.fsapi.domain.FsUser;
import com.example.fsapi.repository.FsUserRepository;
import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsUserDto;
import com.example.fsapi.exception.NoMatchingDataException;
import com.example.fsapi.service.FsUserService;
import com.example.fsapi.mapper.FsUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FsUserServiceImpl implements FsUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FsUserRepository FsUserRepository;
    private final FsUserMapper FsUserMapper;
    public FsUserServiceImpl(
            FsUserRepository FsUserRepository
            ,FsUserMapper FsUserMapper
    ) {
        this.FsUserRepository = FsUserRepository;
        this.FsUserMapper = FsUserMapper;
    }

    public FsUserDto.FsUserAfterCreateDto create(FsUserDto.FsUserCreateDto params){
        return FsUserRepository.save(params.toEntity()).toAfterCreateDto();
    }
    public FsUserDto.FsUserAfterUpdateDto update(FsUserDto.FsUserUpdateDto params){
        FsUser FsUser = FsUserRepository.findById(params.getId())
                .orElseThrow(() -> new NoMatchingDataException(""));
        if(params.getPw() != null){
            FsUser.setPw(params.getPw());
        }
        if(params.getNick() != null){
            FsUser.setNick(params.getNick());
        }
        if(params.getSfrom() != null){
            FsUser.setSfrom(params.getSfrom());
        }
        if(params.getDeleted() != null){
            FsUser.setDeleted(params.getDeleted());
        }
        if(params.getProcess() != null){
            FsUser.setProcess(params.getProcess());
        }
        if(params.getName() != null){
            FsUser.setName(params.getName());
        }
        if(params.getPhone() != null){
            FsUser.setPhone(params.getPhone());
        }
        if(params.getMpic() != null){
            FsUser.setMpic(params.getMpic());
        }
        FsUserRepository.save(FsUser);
        return FsUser.toAfterUpdateDto();
    }

    public FsUserDto.FsUserSelectDto detail(String id){
        return FsUserMapper.detail(id);
    }
    public List<FsUserDto.FsUserSelectDto> list(FsUserDto.FsUserListDto params){
        return FsUserMapper.list(params);
    }
    public List<FsUserDto.FsUserSelectDto> moreList(FsUserDto.FsUserMoreListDto params){
        params.afterBuild();
        return FsUserMapper.moreList(params);
    }
    public CommonAfterPagedListDto<FsUserDto.FsUserSelectDto> pagedList(FsUserDto.FsUserPagedListDto params){
        return new CommonAfterPagedListDto<>(params.afterBuild(FsUserMapper.pagedListCount(params)), FsUserMapper.pagedList(params));
    }
}
