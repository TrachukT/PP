package commands;

import java.io.FileWriter;
import java.io.IOException;

public class ResultOfCommand<T> {
    private T result;
    private String information;
    private boolean isSuccessful;

    public ResultOfCommand(T result, String inform, boolean isSucceed) {
        this.result = result;
        this.information=inform;
        this.isSuccessful=isSucceed;
    }

    public T getResult() {
        return result;
    }

    //public void setInformation(String information) {
//        this.information = information;
//    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getInformation() {
        return information;
    }
    public boolean isSuccessful() {
        return isSuccessful;
    }

//    public void setSuccessful(boolean successful) {
//        isSuccessful = successful;
//    }
    public String Result() {
        return   "Result of command - " + result + "\ninfo - " + information +"\nIsSuccesful - " + isSuccessful;
    }
}
