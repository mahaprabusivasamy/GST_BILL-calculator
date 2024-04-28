// Gst.java
package com.example.javaP.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Gst")
public class Gst {
   
    @Id
    private String id;
    private int cgst;
    private int sgst;
    
    public Gst() {
    
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public int getCgst() {
        return cgst;
    }
    
    public void setCgst(int cgst) {
        this.cgst = cgst;
    }
    
    public int getSgst() {
        return sgst;
    }
    
    public void setSgst(int sgst) {
        this.sgst = sgst;
    }
}
