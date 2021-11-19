package com.nadarzy.betterReadsApp.userbooks;

import org.springframework.data.cassandra.repository.CassandraRepository;

/** @author Julian Nadarzy on 19/11/2021 */
public interface UserBooksRepository extends CassandraRepository<UserBooks, UserBooksPrimaryKey> {}
