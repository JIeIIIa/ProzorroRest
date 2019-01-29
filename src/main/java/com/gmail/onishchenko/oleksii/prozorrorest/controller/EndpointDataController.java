package com.gmail.onishchenko.oleksii.prozorrorest.controller;

import com.gmail.onishchenko.oleksii.prozorrorest.entity.EndpointData;
import com.gmail.onishchenko.oleksii.prozorrorest.service.EndpointDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/endpoints")
public class EndpointDataController {
    private final EndpointDataService endpointDataService;

    @Autowired
    public EndpointDataController(EndpointDataService endpointDataService) {
        this.endpointDataService = endpointDataService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<EndpointData> add(@ModelAttribute(value = "url") String url) {
        return ResponseEntity.ok(endpointDataService.add(url));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        endpointDataService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<EndpointData> update(@PathVariable("id") Long id) {
        return ResponseEntity.ok(endpointDataService.update(id));
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity<List<EndpointData>> all() {
        List<EndpointData> list = endpointDataService.retrieveAll();
        return ResponseEntity.ok(list);
    }
}
