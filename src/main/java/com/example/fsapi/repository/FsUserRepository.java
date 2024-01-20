package com.example.fsapi.repository;

import com.example.fsapi.domain.FsUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FsUserRepository extends JpaRepository<FsUser, String> {
}
