package br.com.desafio.totalshake.service.exeception;

public class DataBaseExeception extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public DataBaseExeception(String msg){
        super(msg);
    }
}