package com.ulstu.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    Map add(RecordDto recordDto) {
        Map<String, Boolean> map = new HashMap();
        map.put("success", recordRepository.save(recordDto) != null);
        return  map;
    }

    Map getTop() {
        Map<String, List<RecordDto>> map = new HashMap();
        map.put("records", recordRepository.findFirst10ByOrderByTimeAsc());
        return  map;
    }

    Map getTopByDif(String difficulty) {
        Map<String, List<RecordDto>> map = new HashMap();
        List<RecordDto>  records = recordRepository.findAllByDifficulty(difficulty);
        records.sort(Comparator.comparingInt(RecordDto::getTime));
        map.put("records", records);
        return  map;
    }
}
