package apiautomation.pojos;

public class AuthResponseModel {


    private String token;


    public AuthResponseModel() {
    }

    public AuthResponseModel(String token) {
        this.token = token;
    }

    public String getTokenValue() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthResponseModel{" +
                "token='" + token + '\'' +
                '}';
    }
}
