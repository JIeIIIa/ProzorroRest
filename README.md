#ProzorroRest

[![Build Status](https://travis-ci.org/JIeIIIa/ProzorroRest.svg?branch=master)](https://travis-ci.org/JIeIIIa/ProzorroRest)

ProzorroRest is a test project for IT Contract

##API Description

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