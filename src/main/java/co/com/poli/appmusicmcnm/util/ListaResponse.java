package co.com.poli.appmusicmcnm.util;


public class ListaResponse {

    private Object messageBody;
    private int codeMessage;
    private String message;
    private Boolean state;

    public ListaResponse(Object messageBody, int codeMessage, String message, Boolean state) {
        this.messageBody = messageBody;
        this.codeMessage = codeMessage;
        this.message = message;
        this.state = state;
    }

    public ListaResponse(Object messageBody, int codeMessage, String message) {
        this.messageBody = messageBody;
        this.codeMessage = codeMessage;
        this.message = message;
    }

    public ListaResponse(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "codeMessage=" + codeMessage +
                ", message='" + message + '\'' +
                '}';
    }

    public ListaResponse(int codeMessage, String message) {
        this.codeMessage = codeMessage;
        this.message = message;
    }

    public ListaResponse() {
        this.codeMessage = 200;
    }

    public Object getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(Object messageBody) {
        this.messageBody = messageBody;
    }

    public int getCodeMessage() {
        return codeMessage;
    }

    public void setCodeMessage(int codeMessage) {
        this.codeMessage = codeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}