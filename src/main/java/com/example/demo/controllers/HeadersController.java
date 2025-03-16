package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HeadersController {

    @GetMapping("/headers")
    public String showHeaders(HttpServletRequest request, Model model) {
        List<String> headersList = new LinkedList<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headersList.add(headerName + ": " + headerValue);
        }
        model.addAttribute("headers", headersList);
        return "headers";
    }
}