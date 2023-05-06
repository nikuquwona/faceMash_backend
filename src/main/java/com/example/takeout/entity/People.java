package com.example.takeout.entity;


import lombok.Data;

import java.io.Serializable;

@Data // get set
public class People implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String imageUrl;
    //    private byte[] imageUrl;
    private float score;


}
