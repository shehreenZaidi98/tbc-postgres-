package com.tbc.encryptionData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncryptionRepository extends JpaRepository<EncryptionData,String> {
}
