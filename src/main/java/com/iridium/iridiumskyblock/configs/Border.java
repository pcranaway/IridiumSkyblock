package com.iridium.iridiumskyblock.configs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iridium.iridiumcore.Color;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Border {

    public Color defaultColor = Color.BLUE;
    public Map<Color, Boolean> enabled = new HashMap<>();

}
