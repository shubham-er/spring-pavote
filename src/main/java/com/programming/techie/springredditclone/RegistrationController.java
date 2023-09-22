/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.programming.techie.springredditclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ComponentScan(basePackages = {"com.aws.rest"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("youthVote/pennsylvania/registration")
public class RegistrationController {
    private final DynamoDBService dynamoDBService;

    @Autowired
    RegistrationController(
        DynamoDBService dbService
    ) {
        this.dynamoDBService = dbService;
    }

    @GetMapping("/all")
    public List<VoterRegistrationDAO> getAllVoters(@RequestParam(required=false) String archived) {
        return dynamoDBService.getAllItems();
    }

    @GetMapping("")
    public VoterRegistrationDAO getVoterRegistrationStatus(@RequestParam String registrationNumber) {
        return dynamoDBService.getRegistrationStatus(registrationNumber);
    }

    @PostMapping("")
    public String addItem(@RequestBody VoterRegistration payload) {


        VoterRegistrationDAO voterRegistration = new VoterRegistrationDAO();
        voterRegistration.setCounty(payload.getCounty());
        voterRegistration.setAddressLine2(payload.getAddress2());
        voterRegistration.setAddressLine1(payload.getAddress1());
        voterRegistration.setEmailAddress(payload.getEmail());
        voterRegistration.setDateOfBirth(payload.getBirthDate());
        voterRegistration.setPhoneNumber(payload.getPhoneNumber());
        voterRegistration.setFirstName(payload.getFirstName());
        voterRegistration.setLastName(payload.getLastName());
        voterRegistration.setZipCode(Integer.parseInt(payload.getZipCode()));


        return dynamoDBService.addRegistration(voterRegistration);

    }
}