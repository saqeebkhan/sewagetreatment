package com.example.demo.controller;

import com.example.demo.entity.Worker;
import com.example.demo.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/worker")
@CrossOrigin(origins = "*")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/allWorker")
   public List<Worker> getAllWorker(){
           return workerService.getAllWorker();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addWorker")
    ResponseEntity<Worker> addWorker(@RequestBody Worker worker){
        try{
            workerService.addWorker(worker);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return  new ResponseEntity<>(worker,HttpStatus.OK);
    }



    @PutMapping("/updateWorker/{id}")
    ResponseEntity<Worker> updateWorker(@RequestBody Worker worker, @PathVariable("id")Long id){
            try {
                worker=workerService.updateWorker(worker,id);
            }catch (Exception e){
                e.getMessage();
                e.printStackTrace();
            }
        return  new ResponseEntity<>(worker,HttpStatus.OK);
    }


    @DeleteMapping("/deleteWorker/{id}")
    ResponseEntity<String> deleteWorkerById(@PathVariable Long id){
        try {
            workerService.deleteWorkerById(id);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    ResponseEntity<Worker> findByState(@RequestParam("state") String state){
        try{
            workerService.findByState(state);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
