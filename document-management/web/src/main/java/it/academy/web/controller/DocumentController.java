package it.academy.web.controller;

import it.academy.dto.DocumentDto;
import it.academy.model.Document;
import it.academy.repository.DocumentRepository;
import it.academy.service.MapDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@Controller
public class DocumentController {

    public static final Logger logger =
            LoggerFactory.getLogger(DocumentController.class.getName());

    @Autowired
    DocumentRepository documentRepository;

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
    public String allDocuments(Model model){
        model.addAttribute("documentsList", mapDocumentService.getAllDocuments());
        return "documents";
    }

    @GetMapping("/pagination/")
    public String listDocuments(
            Model model,
//            @RequestParam(value = "size", required = false, defaultValue = "0") Integer size,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page
    ){
        Page<Document> pageDocuments = documentRepository.findAll(PageRequest.of(page, 5));
        model.addAttribute("documentsList", pageDocuments);
        model.addAttribute("numbers", IntStream.range(0, pageDocuments.getTotalPages()).toArray());
        return "all-documents";
    }
}
