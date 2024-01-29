package com.example.fsapi.repository;

import com.example.fsapi.domain.FsCmt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FsCmtRepository extends JpaRepository<FsCmt, String> {
}
