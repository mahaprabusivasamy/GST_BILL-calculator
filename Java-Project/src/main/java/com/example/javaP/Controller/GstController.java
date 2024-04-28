// GstController.java
package com.example.javaP.Controller;

import com.example.javaP.Model.Gst;
import com.example.javaP.Repository.GstRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class GstController {
	public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")

                .allowedOrigins("http://localhost:5173")

                .allowedMethods("GET", "POST", "PUT", "DELETE")

                .allowedHeaders("*")

                .allowCredentials(true);

    }

    @Autowired
    private GstRepo gstRepo;

    @GetMapping("/getgst")
    public List<Gst> getAllGsts() {
        return gstRepo.findAll();
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<Gst> getGstById(@PathVariable("id") String id) {
        Optional<Gst> gst = gstRepo.findById(id);
        return gst.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                  .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/post/gst")
    public ResponseEntity<Gst> createGst(@RequestBody Gst gst) {
        Gst createdGst = gstRepo.save(gst);
        return new ResponseEntity<>(createdGst, HttpStatus.CREATED);
    }

    @PutMapping("/update/gst/{id}")
    public ResponseEntity<Gst> updateGst(@PathVariable("id") String id, @RequestBody Gst gst) {
        Optional<Gst> gstData = gstRepo.findById(id);

        if (gstData.isPresent()) {
            Gst updatedGst = gstData.get();
            updatedGst.setCgst(gst.getCgst());
            updatedGst.setSgst(gst.getSgst());
            Gst savedGst = gstRepo.save(updatedGst);
            return new ResponseEntity<>(savedGst, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("deleteGst/{id}")
    public ResponseEntity<HttpStatus> deleteGst(@PathVariable("id") String id) {
        try {
            gstRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
