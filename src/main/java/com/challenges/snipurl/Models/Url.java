package com.challenges.snipurl.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

    @Data
    @Entity
    public class Url {
        private String longUrl;
        @Id
        /*we will generate the hash from the given url and store the key
        * mapping  shortUrl-_->Url object */
        private String Id;
        private Date createdDate;

    }
