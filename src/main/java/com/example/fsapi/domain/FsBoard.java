package com.example.fsapi.domain;

import com.example.fsapi.dto.FsBoardDto;
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
        @Index(columnList = "title")
})
@Entity
public class FsBoard extends AuditingFields {

        @Setter
        @Column(nullable = false) private String title; // 제목
        @Setter @Column(nullable = false, length = 10000) private String content; // 본문

        protected FsBoard(){}
        private FsBoard(String title, String content) {
            this.title = title;
            this.content = content;
        }
        public static FsBoard of(String title, String content) {
            return new FsBoard(title, content);
        }
        public static FsBoard of(String title) {
            return new FsBoard(title, "");
        }

        public FsBoardDto.FsBoardAfterCreateDto toAfterCreateDto() {
            return FsBoardDto.FsBoardAfterCreateDto.builder()
                    .id(super.getId())
                    .build();
        }
        public FsBoardDto.FsBoardAfterUpdateDto toAfterUpdateDto() {
            return FsBoardDto.FsBoardAfterUpdateDto.builder()
                    .id(super.getId())
                    .deleted(super.getDeleted())
                    .title(getTitle())
                    .content(getContent())
                    .build();
        }

}
