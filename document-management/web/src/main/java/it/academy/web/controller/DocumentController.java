package it.academy.web.controller;

import it.academy.dto.DocumentDto;
import it.academy.dto.DtoToDocument;
import it.academy.service.DocumentService;
import it.academy.service.MapDocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DocumentController {

    public static final Logger log =
            LoggerFactory.getLogger(DocumentController.class.getName());

    @Autowired
    DocumentService documentService;

    @Autowired
    MapDocumentService mapDocumentService;

    @GetMapping("/document/{id}")
    public String getDocument(
            @PathVariable(name = "id") String id,
            Model model
    ){
        model.addAttribute("document", documentService.readDocument(id));
        return "document";
    }

    @GetMapping("/document/add/")
    public String addDocument(Model model){
        model.addAttribute("documentDto", new DtoToDocument());
        return "add-document";
    }

    @PostMapping("/document/add/")
    public String addDocument(
            @ModelAttribute(name = "documentDto") DtoToDocument dtoToDocument
    ){
        mapDocumentService.saveDocument(dtoToDocument);
        return "redirect:/document/all/";
    }

    @GetMapping("/document/all/")
    public String allDocuments(Model model){
        model.addAttribute("documentsList", mapDocumentService.getAllDocuments());
        return "documents";
    }

}
