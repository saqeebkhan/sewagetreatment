package com.example.demo.service.Impl;

import com.example.demo.Exceptions.CityNotFoundException;
import com.example.demo.Exceptions.StateNotFoundException;
import com.example.demo.Exceptions.WorkerNotFoundException;
import com.example.demo.entity.Worker;
import com.example.demo.repository.WorkerRepository;
import com.example.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;


    @Override
    public List<Worker> getAllWorker() {
        Worker worker = new Worker();
        if (worker!= null){
            return workerRepository.findAll();
        }else {
            throw new RuntimeException("Record Empty");
        }

    }

    @Override
    public Worker addWorker(Worker worker) {
        try{
            worker=workerRepository.save(worker);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return worker;
    }

    @Override
    public Worker updateWorker(Worker worker, Long id) {

        try{
        Worker updatedWorker=workerRepository.findById(id).orElseThrow(()->
                        new WorkerNotFoundException("Worker Not Found With This Id")

                    );
            updatedWorker.setName(worker.getName());
            updatedWorker.setPhoneNumber(worker.getPhoneNumber());
            updatedWorker.setAadharNumber(worker.getAadharNumber());
            updatedWorker.setState(worker.getState());
            updatedWorker.setCity(worker.getCity());
            updatedWorker.setImage(worker.getImage());
            workerRepository.save(updatedWorker);

        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return worker;
    }


    @Override
    public String deleteWorkerById(Long id) {
        try {
            Worker worker = workerRepository.findById(id).orElseThrow(() ->
                    new WorkerNotFoundException("Worker Not Found With This Id")

            );
            workerRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return "Worker Deleted sucessfully";
    }


    @Override
    public Worker findByState(String state) {
        Worker worker = new Worker();

            if (state!=null) {
                workerRepository.findByState(state);

            }else {
               throw new StateNotFoundException("State Not Found");
            }
            return worker;
    }

    @Override
    public Worker findByCity(String city) {
        Worker worker = new Worker();
        if (city!=null){
            workerRepository.findByCity(city);
        }else {
            throw new CityNotFoundException("City Not Found");
        }
        return worker;
    }
}
