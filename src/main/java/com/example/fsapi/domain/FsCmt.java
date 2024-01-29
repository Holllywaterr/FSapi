package com.example.fsapi.domain;

import com.example.fsapi.dto.FsCmtDto;
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
        @Index(columnList = "FsBoardId")
        ,@Index(columnList = "createdAt")
        ,@Index(columnList = "modifiedAt")
})
@Entity
public class FsCmt extends AuditingFields {

    @Setter
    @Column(nullable = false) private String fsBoardId; // 게시판의 pk
    @Setter @Column(nullable = false, length = 10000) private String content;

    protected FsCmt(){}
    private FsCmt(String FsBoardId, String content) {
        this.fsBoardId = FsBoardId;
        this.content = content;
    }
    public static FsCmt of(String FsBoardId, String content) {
        return new FsCmt(FsBoardId, content);
    }
    public static FsCmt of(String FsBoardId) {
        return new FsCmt(FsBoardId, "");
    }

    public FsCmtDto.FsCmtAfterCreateDto toAfterCreateDto() {
        return FsCmtDto.FsCmtAfterCreateDto.builder()
                .id(super.getId())
                .build();
    }
    public FsCmtDto.FsCmtAfterUpdateDto toAfterUpdateDto() {
        return FsCmtDto.FsCmtAfterUpdateDto.builder()
                .id(super.getId())
                .deleted(super.getDeleted())
                .fsBoardId(getFsBoardId())
                .content(getContent())
                .build();
    }

}
