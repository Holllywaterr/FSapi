package com.example.fsapi.domain;

import com.example.fsapi.dto.FsUserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Table(
        indexes = {
                @Index(name = "IDX_FsUser_createdAt", columnList = "createdAt")
                ,@Index(name = "IDX_FsUser_modifiedAt", columnList = "modifiedAt")
                ,@Index(name = "IDX_FsUser_process", columnList = "process")
        }
        , uniqueConstraints= {
        @UniqueConstraint(name = "UQ_FsUser_nick", columnNames = {"nick"})
}
)
@Entity
public class FsUser extends AuditingFields {

    @Setter
    @Column(nullable = false) private String uid;
    @Setter @Column(nullable = false) private String pw;
    @Setter @Column(nullable = false) private String nick;
    @Setter @Column(nullable = false) private String sfrom;
    @Setter @Column(nullable = false) private String process;
    @Setter @Column(nullable = true) private String name;
    @Setter @Column(nullable = true) private String phone;
    @Setter @Column(nullable = true) private String mpic;
    @Setter @Column(nullable = true, length = 10000) private String content; // 본문

    protected FsUser(){}
    private FsUser(String uid, String pw, String nick, String sfrom, String process) {
        this.uid = uid;
        this.pw = pw;
        this.nick = nick;
        this.sfrom = sfrom;
        this.process = process;
    }
    public static FsUser of(String uid, String pw, String nick, String sfrom, String process) {
        return new FsUser(uid, pw, nick, sfrom, process);
    }
    public static FsUser of(String uid, String pw) {
        return new FsUser(uid, pw, "", "", "0");
    }

    public FsUserDto.FsUserAfterCreateDto toAfterCreateDto() {
        return FsUserDto.FsUserAfterCreateDto.builder()
                .id(super.getId())
                .build();
    }
    public FsUserDto.FsUserAfterUpdateDto toAfterUpdateDto() {
        return FsUserDto.FsUserAfterUpdateDto.builder()
                .id(super.getId())
                .deleted(super.getDeleted())
                .build();
    }

}
