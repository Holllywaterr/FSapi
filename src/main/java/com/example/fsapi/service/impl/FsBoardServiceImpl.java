package com.example.fsapi.service.impl;

import com.example.fsapi.domain.FsBoard;
import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsBoardDto;
import com.example.fsapi.exception.NoMatchingDataException;
import com.example.fsapi.mapper.FsBoardMapper;
import com.example.fsapi.repository.FsBoardRepository;
import com.example.fsapi.service.FsBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FsBoardServiceImpl implements FsBoardService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FsBoardRepository FsBoardRepository;
    private final FsBoardMapper FsBoardMapper;

    public FsBoardServiceImpl(
            FsBoardRepository FsBoardRepository,
            FsBoardMapper FsBoardMapper 
    ) {
        this.FsBoardRepository = FsBoardRepository;
        this.FsBoardMapper = FsBoardMapper;
    }

    public FsBoardDto.FsBoardAfterCreateDto create(FsBoardDto.FsBoardCreateDto params){
        return FsBoardRepository.save(params.toEntity()).toAfterCreateDto();
    }
    public FsBoardDto.FsBoardAfterUpdateDto update(FsBoardDto.FsBoardUpdateDto params){
        FsBoard FsBoard = FsBoardRepository.findById(params.getId())
                .orElseThrow(() -> new NoMatchingDataException(""));
        if(params.getTitle() != null){
            FsBoard.setTitle(params.getTitle());
        }
        if(params.getContent() != null){
            FsBoard.setContent(params.getContent());
        }
        if(params.getDeleted() != null){
            FsBoard.setDeleted(params.getDeleted());
        }
        FsBoardRepository.save(FsBoard);
        return FsBoard.toAfterUpdateDto();
    }

    public FsBoardDto.FsBoardSelectDto detail(String id){
        return FsBoardMapper.detail(id);
    }
    public List<FsBoardDto.FsBoardSelectDto> list(FsBoardDto.FsBoardListDto params){
        return FsBoardMapper.list(params);
    }
    public List<FsBoardDto.FsBoardSelectDto> moreList(FsBoardDto.FsBoardMoreListDto params){
        params.afterBuild();
        return FsBoardMapper.moreList(params);
    }
    public CommonAfterPagedListDto<FsBoardDto.FsBoardSelectDto> pagedList(FsBoardDto.FsBoardPagedListDto params){
        return new CommonAfterPagedListDto<>(params.afterBuild(FsBoardMapper.pagedListCount(params)), FsBoardMapper.pagedList(params));
    }
}
