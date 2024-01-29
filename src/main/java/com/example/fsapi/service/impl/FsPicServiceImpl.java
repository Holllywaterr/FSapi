package com.example.fsapi.service.impl;

import com.example.fsapi.domain.FsPic;
import com.example.fsapi.repository.FsPicRepository;
import com.example.fsapi.mapper.FsPicMapper;
import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsPicDto;
import com.example.fsapi.exception.NoMatchingDataException;
import com.example.fsapi.service.FsPicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FsPicServiceImpl implements FsPicService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FsPicRepository FsPicRepository;
    private final FsPicMapper FsPicMapper;
    public FsPicServiceImpl(
            FsPicRepository FsPicRepository
            ,FsPicMapper FsPicMapper
    ) {
        this.FsPicRepository = FsPicRepository;
        this.FsPicMapper = FsPicMapper;
    }

    public FsPicDto.FsPicAfterCreateDto create(FsPicDto.FsPicCreateDto params){
        return FsPicRepository.save(params.toEntity()).toAfterCreateDto();
    }
    public FsPicDto.FsPicAfterUpdateDto update(FsPicDto.FsPicUpdateDto params){
        FsPic FsPic = FsPicRepository.findById(params.getId())
                .orElseThrow(() -> new NoMatchingDataException(""));
        if(params.getFsBoardId() != null){
            FsPic.setFsBoardId(params.getFsBoardId());
        }
        if(params.getContent() != null){
            FsPic.setContent(params.getContent());
        }
        if(params.getDeleted() != null){
            FsPic.setDeleted(params.getDeleted());
        }
        FsPicRepository.save(FsPic);
        return FsPic.toAfterUpdateDto();
    }
    public FsPicDto.FsPicAfterUpdateDto delete(FsPicDto.FsPicUpdateDto params){
        params.setDeleted("Y");
        return update(params);
    }

    public FsPicDto.FsPicSelectDto detail(String id){
        return FsPicMapper.detail(id);
    }
    public List<FsPicDto.FsPicSelectDto> list(FsPicDto.FsPicListDto params){
        return FsPicMapper.list(params);
    }
    public List<FsPicDto.FsPicSelectDto> moreList(FsPicDto.FsPicMoreListDto params){
        params.afterBuild();
        return FsPicMapper.moreList(params);
    }
    public CommonAfterPagedListDto<FsPicDto.FsPicSelectDto> pagedList(FsPicDto.FsPicPagedListDto params){
        return new CommonAfterPagedListDto<>(params.afterBuild(FsPicMapper.pagedListCount(params)), FsPicMapper.pagedList(params));
    }
}
