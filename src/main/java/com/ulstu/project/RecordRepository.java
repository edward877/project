package com.ulstu.project;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepository  extends CrudRepository<RecordDto, Long> {

    List<RecordDto> findFirst10ByOrderByTimeAsc();
}
