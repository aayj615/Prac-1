package com.example.demo.controller;

import com.example.demo.entity.Singers;
import com.example.demo.repository.SingersRepo;
import com.example.demo.service.SingersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/api/singers")
public class SingerController {
    @Autowired
    private SingersServiceImpl singersService;

    //Create
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Singers singers){
        ResponseEntity<String> responseEntity = null;
        try{
            Integer singers2 = singersService.saveSingers(singers); //singer '1' created
            responseEntity = new ResponseEntity<String>("Singer <" + singers2 + "> created", HttpStatus.OK);
        }catch(Exception e){
            responseEntity = new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }
        return responseEntity;
    }

    //Update
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Singers singers){
        ResponseEntity<String> responseEntity = null;
        boolean available = singersService.isAvailable(singers.getSingerPosition());

        if(available){
            singersService.update(singers);
            responseEntity = new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>("Record <"+singers.getSingerPosition()+"> not found",HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        ResponseEntity responseEntity = null;
        boolean availableSinger = singersService.isAvailable(id);

        if(availableSinger){
            singersService.delete(id);
            responseEntity = new ResponseEntity<String>("Deleted " + id + " successfully", HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<String>(id + " Not Exist", HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping(value="/getSingleSinger")
    public ResponseEntity getSingleSingerById(@PathVariable Integer id){
        ResponseEntity responseEntity = null;

        if(singersService.isAvailable(id)){
            Singers oneSinger = singersService.getOneSinger(id);
            responseEntity = new ResponseEntity<Singers>(oneSinger, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Record Not Found", HttpStatus.OK);
        }
        return responseEntity;
    }

    //fetch operation
    @GetMapping(value="/getAllSingers")
    public ResponseEntity getAllSingers(){
        ResponseEntity responseEntity = null;
        List<Singers> allSingers = singersService.getAllSingers();

        if(allSingers==null || allSingers.isEmpty()){
            String message = "No data found";
            responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<List<Singers>>(allSingers, HttpStatus.OK);
        }
        return responseEntity;
    }
}
