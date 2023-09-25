package org.launchcode.artgallery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GalleryController {
    private static int nextID = 6;
    private static final Map<Integer, String> artworks = new HashMap<>() {{
        put(1, "Girl with a Pearl Earring");
        put(2, "Mona Lisa");
        put(3, "The Birth of Venus");
        put(4, "The Persistence of Memory");
        put(5, "The Starry Night");
    }};
    @GetMapping("/")
    @ResponseBody
    public String renderHomePage() {
        return "<h2>Welcome to the Midtown Art Gallery</h2>" +
                "<p>View our <a href= '/artworks'>collection</a> of fine art</p>";
    }
    @GetMapping("/artworks")
    @ResponseBody
    public String renderArtworksHomePage() {
        return "<html>" +
                "<body>" +
                "<h3> ARTWORK ADDED</H3>" +
                "<p> Click <a href='/artworks/add'>here</a> to add another artwork. </p>" +
                "<body>" +
                "<html>";
    }

    @GetMapping("/artworks/add")
    @ResponseBody
    public String addArtwork(@RequestParam String artwork) {
        artworks.put(nextID, artwork);
        nextID++;
        return "<html>" +
                "<body>" +
                "<h3> ARTWORK ADDED</H3>" +
                "<p> You have successfully added" + artwork + "to the collection. </p>" +
                "<p><a href='/artworks'>View the updated list</a> of artworks,/p>";
    }

    @GetMapping("/artworks/details/{artworkId}")
    @ResponseBody
    public String displayArtworkDetails(@PathVariable int artworkId) {
        return "<html>" +
                "<body>" +
                "<h3> ARTWORK ADDED</H3>" +
                "<p><b>Name: </b> " + artworkId + "</p>" +
                "<body>" +
                "<html>";
    }
    }
