package com.gmail.onishchenko.oleksii.prozorrorest.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {WelcomeController.class})
class WelcomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    static Stream<String> urls() {
        return Stream.of("", "/", "/index");
    }

    @ParameterizedTest(name = "[{index}] ==> url={0}")
    @MethodSource(value = {"urls"})
    void index(String url) throws Exception {
        //Given
        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get(url);

        //When
        ResultActions perform = mockMvc.perform(get);

        //Then
        perform.andExpect(status().isFound())
                .andExpect(redirectedUrl("/index.html"));
    }
}