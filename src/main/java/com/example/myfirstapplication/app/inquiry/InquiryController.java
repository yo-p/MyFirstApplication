package com.example.myfirstapplication.app.inquiry;

import com.example.myfirstapplication.entity.Inquiry;
import com.example.myfirstapplication.service.InquiryNotFoundException;
import com.example.myfirstapplication.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {
    private final InquiryService inquiryService;

    @Autowired
    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }
    @GetMapping
    public String index(Model model) {
        List<Inquiry> inquiryList = inquiryService.getAll();

//        Inquiry inquiry = new Inquiry();
//        inquiry.setId(4);
//        inquiry.setName("Hello");
//        inquiry.setEmail("sample@email");
//        inquiryService.update(inquiry);

        model.addAttribute("inquiryList", inquiryList);
        model.addAttribute("title", "Inquiry Index");
        return "inquiry/index_boot";
    }
    @GetMapping("/form")
    public  String form(InquiryForm inquiryForm,
                        Model model,
                        @ModelAttribute("complete") String complete) {
        model.addAttribute("title", "Inquiry Form");
        return "inquiry/form_boot";
    }
    @PostMapping("/form")
    public  String formGoBack(InquiryForm inquiryForm, Model model) {
        model.addAttribute("title", "Inquiry Form");
        return "inquiry/form_boot";
    }
    @PostMapping("/confirm")
    public  String confirm(@Validated InquiryForm inquiryForm,
                           BindingResult result,
                           Model model) {
        if(result.hasErrors()) {
            model.addAttribute("title", "Inquiry Form");
            return "inquiry/form_boot";
        }
        model.addAttribute("title", "confirm page");
        return "inquiry/confirm_boot";
    }
    @PostMapping("/complete")
    public String complete(@Validated InquiryForm inquiryForm,
                           BindingResult result,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            model.addAttribute("title", "InquiryForm");
            return "inquiry/form_boot";
        }
        Inquiry inquiry = new Inquiry();
        inquiry.setName(inquiryForm.getName());
        inquiry.setEmail(inquiryForm.getEmail());
        inquiry.setContents(inquiryForm.getContents());
        inquiry.setCreated(LocalDateTime.now());

        inquiryService.insert(inquiry);
        redirectAttributes.addFlashAttribute("complete", "Registered");
        return "redirect:/inquiry/form";
    }
//    @ExceptionHandler(InquiryNotFoundException.class)
//    public String handleException(InquiryNotFoundException e, Model model) {
//        model.addAttribute("message", e);
//        return "error/CustomPage";
//    }
}
