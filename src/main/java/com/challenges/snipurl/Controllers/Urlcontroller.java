package com.challenges.snipurl.Controllers;

import com.challenges.snipurl.Models.Url;
import com.challenges.snipurl.Services.UrlService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Urlcontroller {

        @Autowired
        private UrlService urlService;

       @GetMapping(value = {"/home", "/","//" ,"/index"} )
        public String showUrlForm() {
           //   return "trail";
           return "urlTemplate";

       }
        @GetMapping("/{key}")
        public String redirectUrl(@PathVariable String key, HttpServletResponse response,Model model){
                String longUrl = urlService.getUrl(key);
                if(longUrl!=null) {
                    response.setHeader(HttpHeaders.LOCATION, longUrl);
                    return "redirect:"+longUrl;
                }else{
                    model.addAttribute("errorMessage","Invalid Url");
                    return "Error";
                }

        }

        @PostMapping("/shorten")
        public String postShortUrl(@RequestParam("longUrl") String longUrl, Model model){
                String shortUrl= urlService.persist(longUrl);
                model.addAttribute("shortUrl",shortUrl);
                model.addAttribute("domainName","localhost:8080/");
                return "urlTemplate";
        }
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        e.printStackTrace();

        // Set an error message in the model
        model.addAttribute("errorMessage", "An unexpected error occurred.");

        // Return the error view (you can customize the view name)
        return "Error";
    }


}
