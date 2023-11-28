package com.challenges.snipurl.Services;

import com.challenges.snipurl.Controllers.Urlcontroller;
import com.challenges.snipurl.Models.Url;
import com.challenges.snipurl.Repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class UrlService {
    UrlRepository urlRepository;

    @Autowired
    public  UrlService(UrlRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    public String persist(String longUrl){
        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setCreatedDate(new java.util.Date());
        Long number = generateNumber();
        String key = Encode(number);
        if(urlRepository.findById(key).isPresent()){
            persist(longUrl);
        }else{
            url.setId(key);
           urlRepository.save(url);
        }
        return url.getId();
    }
    public String getUrl(String key){
        Optional<Url> tempUrl =  urlRepository.findById(key);
        if(tempUrl.isPresent()){
            return tempUrl.get().getLongUrl();
        }else{
            return null;
        }
    }
    public String Encode(Long number){
        char[] charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        long    remainder = 0L;
        String Base62String = "";
        while(number>0){
            remainder= number%62;
            Base62String = Base62String + charSet[(int)remainder];
            number = number/62;
        }
        return Base62String;
    }

    public Long generateNumber(){
        Random rand = new Random();
        Long  min =1L;
        Long max = 3000000000L;
        return   rand.nextLong(max-min)+min;

    }
}
