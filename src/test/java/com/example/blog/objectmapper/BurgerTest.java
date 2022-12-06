package com.example.blog.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BurgerTest {
    @Test
    public void 자바_객체를_JSON으로변환() throws JsonProcessingException {
        // 준비
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> ingredients = Arrays.asList("통새우패티", "순쇠고기패티", "어니언소스");
        Burger burger = new Burger("맥도날드", 5500, ingredients);
        //수행
        String json = objectMapper.writeValueAsString(burger);
        //예상
        String expected = "{\"name\":\"맥도날드\",\"price\":5500,\"ingredient\":[\"통새우패티\",\"순쇠고기패티\",\"어니언소스\"]}";
        //검증
        assertEquals(expected, json);
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
    }
    @Test
    public void JSON을_자바_객체로_변환() throws JsonProcessingException {
        //준비
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "맥도날드");
        objectNode.put("price", 5500);

        ArrayNode arrayNode = objectMapper.createArrayNode();
        arrayNode.add("통새우패티");
        arrayNode.add("순쇠고기패티");
        arrayNode.add("어니언소스");
        objectNode.set("ingredient", arrayNode);
        String json = objectNode.toString();

        //수행
        Burger burger = objectMapper.readValue(json, Burger.class);
        //예상
        List<String> ingredients = Arrays.asList("통새우패티", "순쇠고기패티", "어니언소스");
        Burger expected = new Burger("맥도날드", 5500, ingredients);
        //검증
        assertEquals(expected.toString(), burger.toString());
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
        System.out.println(burger.toString());
    }
}