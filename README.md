# ProzorroRest

[![Build Status](https://travis-ci.org/JIeIIIa/ProzorroRest.svg?branch=master)](https://travis-ci.org/JIeIIIa/ProzorroRest)
[![Coverage Status](https://coveralls.io/repos/github/JIeIIIa/ProzorroRest/badge.svg?branch=master)](https://coveralls.io/github/JIeIIIa/ProzorroRest?branch=master)

ProzorroRest is a test project for IT Contract. See demo on: https://prozorro-rest.herokuapp.com/

## API Description

||||
| ------------- |:-------------:| :-----|
| **URL**  | /endpoints | Returns json data about all endpointData  |
| *Method* | GET           | |
| *Required URL Params* | None  |  |
| *Success Response:*   | Code: 200 | |
||||
| **URL**  | /endpoints/{id} | Returns json data about one endpointData with respective id  |
| *Method* | GET           | |
| *Required URL Params* | {id} | Long id |
| *Success Response:*   | Code: 200 | |
||||
| **URL**  | /endpoints/{id} | Update an endpointData with respective id and return json data about it |
| *Method* | PUT           | |
| *Required URL Params* | {id} | Long id |
| *Success Response:*   | Code: 200 | |
||||
| **URL**  | /endpoints/{id} | Delete an endpointData with respective id  |
| *Method* | DELETE        | |
| *Required URL Params* | {id} | Long id |
| *Success Response:*   | Code: 200 | |

## Examples of endpoints

* https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/23567e24f52746ef92c470be6059d193/documents 
* https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/4805f381d48948b1b34d6ea2daa029a3/documents 
* https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/47fa8764e1b74f4db58f84c9db460566/documents
