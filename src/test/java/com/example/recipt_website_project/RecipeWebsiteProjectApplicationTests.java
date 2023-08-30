package com.example.recipt_website_project;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class RecipeWebsiteProjectApplicationTests {

    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>(); // jwt中間的body要用map集合裝key and value
        claims.put ("id" , 1);
        claims.put("name", "sam");
        claims.put("habit", "volleyball");

        byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS256).getEncoded(); //目的是創建一個符合 HS256 簽名算法要求的隨機密鑰，並將其轉換為字節數組，以便用於 JWT 的簽名操作。

        // jwt會是一個長長的字符串
        String jwt = Jwts.builder() //創建 JWT 的建構器（Builder）。您可以在建構器中設置 JWT 的各種屬性，例如簽名、內容、過期時間等。

                .signWith(SignatureAlgorithm.HS256, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")//簽名算法 , 也可以隨便自己取一個長度超過256bytes的字串,但還是推薦用加密過的
                .setClaims(claims) //自訂意的內容(payload)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//設置jwt有效期為1小時
                .compact();  //代表將結束 JWT 的建構過程，將所有設置應用到 JWT 物件上，並返回最終的 JWT 字串表示。

        System.out.println(jwt);
    }

    @Test
    public void parsejwt(){

        Claims claims = Jwts.parser()
                .setSigningKey("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJoYWJpdCI6InZvbGxleWJhbGwiLCJuYW1lIjoic2FtIiwiaWQiOjEsImV4cCI6MTY5Mjg0NTgyNn0._Gb3JaeX7q9ATnyk018x0kvpt5Pk2Wh0OSRQmtdjlys")
                .getBody();

        System.out.println(claims);
    }

}
