package it.academy.web.controller;

import it.academy.dto.DocumentDto;
import it.academy.service.MapDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DocumentController {

    public static final Logger logger =
            LoggerFactory.getLogger(DocumentController.class.getName());
//
//    @Autowired
//    DocumentService documentService;

    @Autowired
    MapDocumentService mapDocumentService;

//    @GetMapping("/document/{id}")
//    public String getDocument(
//            @PathVariable(name = "id") String id,
//            Model model
//    ){
//        model.addAttribute("document", documentService.readDocument(id));
//        return "document";
//    }

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

//    @PostMapping("/document/check/")
//    public String checkDocument(
//            @ModelAttribute("documentDto") DtoToDocument dtoToDocument
//    ){
//        return "check-document";
//    }

    @GetMapping("/document/all/")
    public String allDocuments(Model model){
        model.addAttribute("documentsList", mapDocumentService.getAllDocuments());
        return "documents";
    }

}
