package com.example.recipt_website_project.controller;

import com.example.recipt_website_project.service.EdamamApiService;
import com.example.recipt_website_project.service.impl.EdamamApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdamamApiController {

        @Autowired
        private EdamamApiService edamamApiService;

        public EdamamApiController(EdamamApiService edamamApiService){
            this.edamamApiService = edamamApiService;
        }
        @GetMapping("/get-recipes")
        public ResponseEntity<String> getDataFromEdamamApi(){
           String responseData = edamamApiService.callEdamamApi();
            return ResponseEntity.ok(responseData);
        }


}
