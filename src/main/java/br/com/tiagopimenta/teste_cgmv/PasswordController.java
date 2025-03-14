package br.com.tiagopimenta.teste_cgmv;

import org.springframework.http.HttpStatus; // Importa a classe HttpStatus para definir códigos de status HTTP
import org.springframework.http.ResponseEntity; // Importa a classe ResponseEntity para retornar respostas HTTP
import org.springframework.web.bind.annotation.*; // Importa as anotações do Spring para mapeamento de endpoints

import java.util.HashSet; // Importa a classe HashSet para verificar caracteres únicos
import java.util.Set; // Importa a interface Set para manipular coleções de elementos únicos

// Define esta classe como um controlador REST e mapeia a URL base para "/api/v1/password"
@RestController
@RequestMapping("/api/v1/password")
public class PasswordController {

    // Define um endpoint POST para validar senhas
    @PostMapping("/validate")
    public ResponseEntity<Boolean> validatePassword(@RequestBody String password) {
        // Valida a senha utilizando o método isValidPassword
        boolean isValid = isValidPassword(password);
        
        // Exibe no console a senha recebida e se ela é válida ou não
        System.out.println("Senha recebida: " + password + " | Válida: " + isValid);

        // Retorna true se a senha for válida, caso contrário retorna status 400 e false
        if (isValid) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
    }

    // Método que realiza a validação da senha com base nas regras definidas
    private boolean isValidPassword(String password) {
        // Verifica se a senha é nula ou tem menos de 9 caracteres
        if (password == null || password.length() < 9) return false;

        // Variáveis para verificar os critérios obrigatórios da senha
        boolean hasDigit = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;
        Set<Character> uniqueChars = new HashSet<>(); // Conjunto para garantir que não há caracteres repetidos

        // Define os caracteres especiais permitidos na senha
        String specialChars = "!@#$%^&*()-+";

        // Percorre cada caractere da senha para verificar os critérios
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true; // Verifica se há pelo menos um dígito
            if (Character.isLowerCase(c)) hasLowerCase = true; // Verifica se há pelo menos uma letra minúscula
            if (Character.isUpperCase(c)) hasUpperCase = true; // Verifica se há pelo menos uma letra maiúscula
            if (specialChars.indexOf(c) != -1) hasSpecialChar = true; // Verifica se há pelo menos um caractere especial

            // Verifica se há caracteres repetidos
            if (!uniqueChars.add(c)) return false;
        }

        // Retorna true apenas se todos os critérios forem atendidos
        return hasDigit && hasLowerCase && hasUpperCase && hasSpecialChar;
    }
}
