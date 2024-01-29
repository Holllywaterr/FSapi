package com.example.fsapi.domain;

import com.example.fsapi.dto.FsPicDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Table(indexes = {
        @Index(columnList = "fsBoardId")
        ,@Index(columnList = "createdAt")
        ,@Index(columnList = "modifiedAt")
})
@Entity
public class FsPic extends AuditingFields {

    @Setter
    @Column(nullable = false) private String fsBoardId; // 게시판의 pk
    @Setter @Column(nullable = false, length = 10000) private String content;
    @Setter @Column(nullable = false) private String type;

    protected FsPic(){}
    private FsPic(String fsBoardId, String content, String type) {
        this.fsBoardId = fsBoardId;
        this.content = content;
        this.type = type;
    }
    public static FsPic of(String fsBoardId, String content, String type) {
        return new FsPic(fsBoardId, content, type);
    }
    /*
    public static FsPic of(String fsBoardId) {
        return new FsPic(fsBoardId, "", "");
    }
     */

    public FsPicDto.FsPicAfterCreateDto toAfterCreateDto() {
        return FsPicDto.FsPicAfterCreateDto.builder()
                .id(super.getId())
                .build();
    }
    public FsPicDto.FsPicAfterUpdateDto toAfterUpdateDto() {
        return FsPicDto.FsPicAfterUpdateDto.builder()
                .id(super.getId())
                .deleted(super.getDeleted())
                .fsBoardId(getFsBoardId())
                .content(getContent())
                .type(getType())
                .build();
    }

}

