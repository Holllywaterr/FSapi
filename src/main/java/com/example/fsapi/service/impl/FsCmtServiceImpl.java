package com.example.fsapi.service.impl;

import com.example.fsapi.domain.FsCmt;
import com.example.fsapi.dto.CommonAfterPagedListDto;
import com.example.fsapi.dto.FsCmtDto;
import com.example.fsapi.mapper.FsCmtMapper;
import com.example.fsapi.repository.FsCmtRepository;
import com.example.fsapi.exception.NoMatchingDataException;
import com.example.fsapi.service.FsCmtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FsCmtServiceImpl implements FsCmtService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FsCmtRepository FsCmtRepository;
    private final FsCmtMapper FsCmtMapper;
    public FsCmtServiceImpl(
            FsCmtRepository FsCmtRepository
            ,FsCmtMapper FsCmtMapper
    ) {
        this.FsCmtRepository = FsCmtRepository;
        this.FsCmtMapper = FsCmtMapper;
    }

    public FsCmtDto.FsCmtAfterCreateDto create(FsCmtDto.FsCmtCreateDto params){
        return FsCmtRepository.save(params.toEntity()).toAfterCreateDto();
    }
    public FsCmtDto.FsCmtAfterUpdateDto update(FsCmtDto.FsCmtUpdateDto params){
        FsCmt FsCmt = FsCmtRepository.findById(params.getId())
                .orElseThrow(() -> new NoMatchingDataException(""));
        if(params.getFsBoardId() != null){
            FsCmt.setFsBoardId(params.getFsBoardId());
        }
        if(params.getContent() != null){
            FsCmt.setContent(params.getContent());
        }
        if(params.getDeleted() != null){
            FsCmt.setDeleted(params.getDeleted());
        }
        FsCmtRepository.save(FsCmt);
        return FsCmt.toAfterUpdateDto();
    }

    public FsCmtDto.FsCmtSelectDto detail(String id){
        return FsCmtMapper.detail(id);
    }
    public List<FsCmtDto.FsCmtSelectDto> list(FsCmtDto.FsCmtListDto params){
        /*
        // 상세 정보 조회 하는 것을 디테일에만 맡길때
        List<FsCmtDto.FsCmtSelectDto> a_list = FsCmtMapper.list(params);
        List<FsCmtDto.FsCmtSelectDto> result_list = new ArrayList<>();
        for(FsCmtDto.FsCmtSelectDto a : a_list){
            result_list.add(detail(a.getId()));
        }
        return result_list;
         */
        return FsCmtMapper.list(params);
    }
    public List<FsCmtDto.FsCmtSelectDto> moreList(FsCmtDto.FsCmtMoreListDto params){
        params.afterBuild();
        return FsCmtMapper.moreList(params);
    }
    public CommonAfterPagedListDto<FsCmtDto.FsCmtSelectDto> pagedList(FsCmtDto.FsCmtPagedListDto params){
        return new CommonAfterPagedListDto<>(params.afterBuild(FsCmtMapper.pagedListCount(params)), FsCmtMapper.pagedList(params));
    }

}
