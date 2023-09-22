/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.programming.techie.springredditclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("youthVote/pennsylvania/registration/report")
public class ReportController {

    private final DynamoDBService dynamoDBService;

    @Autowired()
    ReportController(
        DynamoDBService dynamoDBService
    ) {
        this.dynamoDBService = dynamoDBService;
    }

    /*@PostMapping("")
    public String sendReport(@RequestBody Map<String, String> body) {
        var list = dynamoDBService.getOpenItems();
       try {
            InputStream is = writeExcel.write(list);
            sm.sendReport(is, body.get("email"));
            return "Report generated & sent";
        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }
        return "Failed to generate report";
    }*/
}