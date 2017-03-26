package main.java.br.com.votenofilme.service;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
}
