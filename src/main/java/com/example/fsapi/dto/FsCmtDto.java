package com.example.fsapi.dto;

import com.example.fsapi.domain.FsCmt;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

public class FsCmtDto {

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsCmtCreateDto {
        @Schema(description = "fs_board_id", example="fs_board_id")
        @NotNull
        @NotEmpty
        @Size(max=100)
        private String fsBoardId;

        @Schema(description = "content", example="content")
        @NotNull
        @NotEmpty
        @Size(max=200)
        private String content;

        public FsCmt toEntity() {
            return FsCmt.of(fsBoardId, content);
        }
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsCmtAfterCreateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsCmtUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        @NotNull
        @NotEmpty
        @Size(max=32)
        private String id;

        @Schema(description = "fs_board_id", example="fs_board_id")
        @Size(max=100)
        private String fsBoardId;

        @Schema(description = "deleted", example="Y")
        @Size(max=1)
        private String deleted;

        @Schema(description = "content", example="content")
        @Size(max=200)
        private String content;
    }
    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsCmtAfterUpdateDto {
        @Schema(description = "id", example="length32textnumber")
        private String id;
        @Schema(description = "deleted", example="Y")
        private String deleted;
        @Schema(description = "fs_board_id", example="fs_board_id")
        @Size(max=100)
        private String fsBoardId;
        @Schema(description = "content", example="content")
        @Size(max=200)
        private String content;
    }

    @Schema
    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsCmtSelectDto {

        @Schema(description = "id", example="id")
        private String id;
        @Schema(description = "fs_board_id", example="fs_board_id")
        private String fs_board_id;
        @Schema(description = "content", example="content")
        private String content;
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
    public static class FsCmtListDto {
        @Schema(description = "fs_board_id", example="fs_board_id")
        private String fs_board_id;
        @Schema(description = "content", example="content")
        private String content;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }

    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsCmtPagedListDto extends CommonPagedListDto {
        @Schema(description = "fs_board_id", example="fs_board_id")
        private String fs_board_id;
        @Schema(description = "content", example="content")
        private String content;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }
    @Schema
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FsCmtMoreListDto extends CommonMoreListDto {
        @Schema(description = "fs_board_id", example="fs_board_id")
        private String fs_board_id;
        @Schema(description = "content", example="content")
        private String content;
        @Schema(description = "deleted", example="N")
        private String deleted;
    }
}
