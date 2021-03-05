package it.academy.web.controller;

import it.academy.model.Document;
import it.academy.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class HomeController {

    private static final Logger log = Logger.getLogger(HomeController.class.getName());

    @Autowired
//    @Qualifier("documentServiceImpl")
    private DocumentService documentService;

    @GetMapping("/index/")
    public String index(Model model){
        log.info("before for....");
        model.addAttribute("documentList", documentService.readAllDocuments());
        log.info("after for....");
        for (Document document : documentService.readAllDocuments()) {
            log.info(document.getCreationDate().toString() + ".......");
        }
        log.info("done....");

        return "index";
    }

    @GetMapping("/")
    public String home(){
        log.info("before for....");

        return "document";
    }
}
