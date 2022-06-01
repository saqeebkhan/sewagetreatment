package com.example.demo.service;

import com.example.demo.entity.Worker;
import java.util.List;

public interface WorkerService {

    List<Worker> getAllWorker();
    Worker addWorker(Worker worker) throws Exception;
    Worker updateWorker(Worker worker,Long id)throws Exception;
    String deleteWorkerById(Long id);
    Worker findByState(String state);
    Worker findByCity(String city);

}
