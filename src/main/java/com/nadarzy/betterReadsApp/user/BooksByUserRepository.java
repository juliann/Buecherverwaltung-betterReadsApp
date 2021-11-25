package com.nadarzy.betterReadsApp.user;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

/** @author Julian Nadarzy on 25/11/2021 */
public interface BooksByUserRepository extends CassandraRepository<BooksByUser, String> {
  Slice<BooksByUser> findAllById(String id, Pageable pageable);
}
