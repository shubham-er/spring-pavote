/*
   Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
   SPDX-License-Identifier: Apache-2.0
*/

package com.programming.techie.springredditclone;

import lombok.Data;

@Data
public class VoterRegistration {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phoneNumber;
    private String email;
    private String county;

    private String address1;

    private String address2;
    private String zipCode;

    private String city;
    private String state;
}