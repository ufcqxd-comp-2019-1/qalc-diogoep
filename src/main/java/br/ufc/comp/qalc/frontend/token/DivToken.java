package br.ufc.comp.qalc.frontend.token;

public class DivToken extends Token{
    public DivToken(long line, long start){
        super(line, start, start);
    }

    @Override
    public String toString(){
        return "/";
    }

    @Override
    public String getTokenIdentifier(){
        return "DIV";
    }
}
