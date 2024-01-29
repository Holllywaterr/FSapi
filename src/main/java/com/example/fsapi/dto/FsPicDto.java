package com.example.fsapi.dto;

import com.example.fsapi.domain.FsPic;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

public class FsPicDto {

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsPicCreateDto {
        @Schema(description = "fsBoardId", example="fsBoardId")
        @NotNull
        @NotEmpty
        @Size(max=100)
        private String fsBoardId;

        @Schema(description = "content", example="content")
        @NotNull
        @NotEmpty
        @Size(max=200)
        private String content;

        @Schema(description = "type", example="type")
        @NotNull
        @NotEmpty
        private String type;

        public FsPic toEntity() {
            return FsPic.of(fsBoardId, content, type);
        }
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsPicAfterCreateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsPicUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        @NotNull
        @NotEmpty
        @Size(max=32)
        private String id;

        @Schema(description = "fsBoardId", example="fsBoardId")
        @Size(max=100)
        private String fsBoardId;

        @Schema(description = "deleted", example="Y")
        @Size(max=1)
        private String deleted;

        @Schema(description = "content", example="content")
        @Size(max=200)
        private String content;

        @Schema(description = "type", example="type")
        private String type;
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsPicAfterUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
        @Schema(description = "deleted", example="Y")
        private String deleted;
        @Schema(description = "fsBoardId", example="fsBoardId")
        @Size(max=100)
        private String fsBoardId;
        @Schema(description = "content", example="content")
        @Size(max=200)
        private String content;
        @Schema(description = "type", example="type")
        private String type;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsPicSelectDto {

        @Schema(description = "id", example="id")
        private String id;
        @Schema(description = "fs_board_id", example="fs_board_id")
        private String fs_board_id;
        @Schema(description = "content", example="content")
        private String content;
        @Schema(description = "type", example="type")
        private String type;
        @Schema(description = "deleted", example="N")
        private String deleted;
        @Schema(description = "created_at", example="2024-01-01 00:00:00.000000")
        private String created_at;
        @Schema(description = "modified_at", example="2024-01-01 00:00:00.000000")
        private String modified_at;

    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsPicListDto {
        @Schema(description = "fs_board_id", example="fs_boardId")
        private String fs_board_id;
        @Schema(description = "content", example="content")
        private String content;
        @Schema(description = "type", example="type")
        private String type;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }

    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsPicPagedListDto extends CommonPagedListDto {
        @Schema(description = "fs_board_id", example="fs_board_id")
        private String fs_board_id;
        @Schema(description = "content", example="content")
        private String content;
        @Schema(description = "type", example="type")
        private String type;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }
    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsPicMoreListDto extends CommonMoreListDto {
        @Schema(description = "fs_board_id", example="fs_board_id")
        private String fs_board_id;
        @Schema(description = "content", example="content")
        private String content;
        @Schema(description = "type", example="type")
        private String type;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }
}
