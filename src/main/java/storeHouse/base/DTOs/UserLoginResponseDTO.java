package storeHouse.base.DTOs;

//Se utiliza para enviar el token una vez realizado el login
public class UserLoginResponseDTO {
    private String token;

    public UserLoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
