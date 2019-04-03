package com.ulstu.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
