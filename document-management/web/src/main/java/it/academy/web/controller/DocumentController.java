package it.academy.web.controller;

import it.academy.dto.DocumentDto;
import it.academy.service.MapDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Controller
public class DocumentController {

    public static final Logger logger =
            LoggerFactory.getLogger(DocumentController.class.getName());

    @Autowired
    MapDocumentService mapDocumentService;

    @GetMapping("/document/add/")
    public String addDocument(Model model){
        model.addAttribute("documentDto", new DocumentDto());
        return "add-document";
    }

    @PostMapping("/document/add/")
    public String addDocument(
            @ModelAttribute("documentDto") DocumentDto documentDto
    ){
        mapDocumentService.saveDocument(documentDto);
        return "redirect:/document/all/";
    }

    @GetMapping("/document/update/")
    public String updateDocument(
            @RequestParam("docId") String id,
            Model model
    ){
        DocumentDto documentDto = mapDocumentService.getDocument(id);
        model.addAttribute("documentDto", documentDto);
        return "add-document";
    }

    @GetMapping("/document/delete/")
    public String deleteDocument(@RequestParam("docId") String id){
        mapDocumentService.deleteDocument(id);
        return "redirect:/document/all/";
    }

    @GetMapping("/document/all/")
    public String listDocuments(
            Model model,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(value = "orderBy", required = false, defaultValue = "Creation Date") String orderBy
    ){
//        Page<DocumentDto> pageDtos = mapDocumentService
//                .findAll(PageRequest.of(page, size, Sort.by(orderBy)));
        System.out.println("Текущая страница: " + page + ", количество записей на странице: " + size);
        Page<DocumentDto> pageDtos = mapDocumentService
                .findAll(page, size, "ASC", orderBy);
        model.addAttribute("documentsList", pageDtos);
        model.addAttribute("numbers", IntStream.range(0, pageDtos.getTotalPages()).toArray());
        model.addAttribute("count", IntStream.of(5, 10, 20, 100).toArray());
        model.addAttribute("orderByParam",
                Stream.of("Creation Date", "Client Surname", "Provider Surname", "Completion Date").toArray());
        model.addAttribute("currentPage", page);
        model.addAttribute("currentSize", size);
        model.addAttribute("currentOrderBy", orderBy);
        return "documents";
    }
}
