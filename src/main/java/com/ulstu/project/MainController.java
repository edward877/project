package com.ulstu.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MainController {

    private final RecordService recordService;

    @Autowired
    public MainController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping("/add")
    public Map add(@RequestBody RecordDto recordDto) {
        return recordService.add(recordDto);
    }

    @GetMapping("/")
    public Map getAll() {
        return recordService.getTop();
    }

    @GetMapping("/difficulty")
    public Map getDifficulty(String difficulty) {
        return recordService.getTopByDif(difficulty);
    }
}
