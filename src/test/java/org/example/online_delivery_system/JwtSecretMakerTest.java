package org.example.online_delivery_system;

import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.Key;

class JwtSecretMakerTest {

    @Test
    void testGenerateSecret() {
        Key key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
        String encodedKey = java.util.Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Generated Secret Key: " + encodedKey);
        Assertions.assertNotNull(encodedKey);
    }
}
